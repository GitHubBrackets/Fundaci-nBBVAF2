package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.SendArchDocuUploImageBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.SendArchivingDocumentsOutDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UploadImageFolioAndSendArchivingInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;

/**
 * Class SendArchDocuUploImageBackImpl implements the SendArchDocuUploImageBack interface
 * Contains the implementations of the method setUploadImageFolioAndSendArchiving to consume the service (Send Document Scholar-Archiving)
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class SendArchDocuUploImageBackImpl implements SendArchDocuUploImageBack{
	private static final Logger log = Logger.getLogger(SendArchDocuUploImageBackImpl.class);
	
	
  	/**      
    *
    * Method setUploadImageFolioAndSendArchiving.
    * Contains the parameters for get the URL for the service (Send Document Scholar-Archiving)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param UploadImageFolioAndSendArchivingInDTO beanUploadImageFolioAndSendArchivingInDTOIn
    * @param HttpServletRequest request
	*
    */
	@Consumes("{MediaType.APPLICATION_JSON}")
	@Override
	public ResponseEntity<?> setUploadImageFolioAndSendArchiving(UploadImageFolioAndSendArchivingInDTO beanUploadImageFolioAndSendArchivingInDTOIn, HttpServletRequest request) {log.info("Inside setUploadImageFolioAndSendArchiving");
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context=null;
		SendArchivingDocumentsBackImpl sendArchivingDocumentsBackImpl=null;
		HttpHeaders headers=null;
		SendArchivingDocumentsOutDTO sendArchivingDocumentsOutDTO = null;
		UploadImageFolioBackImpl uploadImageFolioBackImpl = null;
		ObjectMapper mapper = null;
		String jsonCambiado = null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			sendArchivingDocumentsBackImpl = (SendArchivingDocumentsBackImpl) context.getBean("sendArchDocuBack");
			log.info("After Autoinstance - setUploadImageFolioAndSendArchiving");
			headers.setContentType(MediaType.APPLICATION_JSON);		
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());	
			log.info("headers-setUploadImageFolioAndSendArchiving = "+headers);
			response = sendArchivingDocumentsBackImpl.sendArchivingDocumentsArmed(beanUploadImageFolioAndSendArchivingInDTOIn.getArchiving(), request);
			
			if(response.getStatusCode().value() == 200){
				log.info("Send Service Imagen");
				sendArchivingDocumentsOutDTO = (SendArchivingDocumentsOutDTO) context.getBean("SendArchDocuOutDTO");
				uploadImageFolioBackImpl = (UploadImageFolioBackImpl) context.getBean("uploadImgFolBack");	
				
				mapper = (ObjectMapper) context.getBean("objMapper");
				log.info("After Autoinstance - setUploadImageFolioAndSendArchiving Imagen");
				mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				String json = response.getBody().toString();
				log.info("json-RespSendArchivingDocument = "+json);
					String cadenaPrim = null;
					String descuentaCadena=json;
					int valigual=0;
					boolean entraUnaVez=false;
					boolean bandera=true;
					int validaComa=0;
					while(bandera){
						
								if(entraUnaVez==false){
									valigual = json.indexOf("=");
									cadenaPrim = "{\""+ json.substring(1, valigual)+"\"=";
									descuentaCadena= json.substring(valigual+1, json.length()).trim();	
								}
													
								if(descuentaCadena.indexOf(",") != -1 ){   
									validaComa = descuentaCadena.indexOf(",");
									cadenaPrim = cadenaPrim + descuentaCadena.substring(0, validaComa)+",";
									descuentaCadena = descuentaCadena.substring(validaComa+1, descuentaCadena.length()).trim();
								}					
											
								if(descuentaCadena.indexOf("=") != -1 ){			
											valigual = descuentaCadena.indexOf("=");
											cadenaPrim = cadenaPrim + "\""+ descuentaCadena.substring(0, valigual)+"\"=";
											descuentaCadena= descuentaCadena.substring(valigual+1, descuentaCadena.length()).trim();	
											
								}			
								
								if(descuentaCadena.indexOf("=") == -1 && descuentaCadena.indexOf("=") == -1){
												validaComa = descuentaCadena.indexOf("}");
												cadenaPrim = cadenaPrim + "\""+descuentaCadena.substring(0, validaComa)+"\"}";
												descuentaCadena = descuentaCadena.substring(validaComa+1, descuentaCadena.length()).trim();
												bandera=false;
								}
								entraUnaVez=true;		
					}	
					jsonCambiado = cadenaPrim.replace("=", ":");
				
				
				log.info("Json to send - Imagen = "+jsonCambiado);
				sendArchivingDocumentsOutDTO = mapper.readValue(jsonCambiado, SendArchivingDocumentsOutDTO.class);
				String folio = sendArchivingDocumentsOutDTO.getReferenceNumber();
				log.info("folio to send Imagen = "+folio);
				beanUploadImageFolioAndSendArchivingInDTOIn.getImagen().setFolio(folio);
				response = uploadImageFolioBackImpl.uploadImageFolioArmed(beanUploadImageFolioAndSendArchivingInDTOIn.getImagen(), request);
			}
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context = null;
			sendArchivingDocumentsBackImpl=null;
			headers=null;
			mapper = null;
			sendArchivingDocumentsOutDTO = null;
			uploadImageFolioBackImpl = null;
			jsonCambiado = null;
		} 
		return response;
	}

}
