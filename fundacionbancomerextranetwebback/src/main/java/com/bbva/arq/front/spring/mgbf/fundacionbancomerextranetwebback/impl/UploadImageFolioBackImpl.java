package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.UploadImageFolioBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UploadImageFolioInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialUploadImageFolioServiceImpl;

/**
 * Class UploadImageFolioBackImpl implements the UploadImageFolioBack interface
 * Contains the implementations of the method uploadImageFolioArmed to consume the service MGBFTD01
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class UploadImageFolioBackImpl implements UploadImageFolioBack {
	private static final Logger log = Logger.getLogger(UploadImageFolioBackImpl.class);

	private boolean gtCad = false;
	
  	/**      
    *
    * Method uploadImageFolioArmed.
    * Contains the parameters for get the URL for the service MGBFTD01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param UploadImageFolioInDTO beanUploadImageFolioIn
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> uploadImageFolioArmed( UploadImageFolioInDTO beanUploadImageFolioIn,HttpServletRequest request) {log.info("Inside uploadImageFolioArmed");
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context=null;
		InitialUploadImageFolioServiceImpl initialUploadImageFolioServiceImpl=null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialUploadImageFolioServiceImpl = (InitialUploadImageFolioServiceImpl) context.getBean("uploadImgFolServiceCli");
			log.info("After Autoinstance - uploadImageFolioArmed");			
			headers.setContentType(MediaType.APPLICATION_JSON);		
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());
			log.info("headers-uploadImageFolioArmed = "+headers);
			response = initialUploadImageFolioServiceImpl.uploadImageClient(beanUploadImageFolioIn, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - uploadImageFolioArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();

				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.uploadImageFolioArmed(beanUploadImageFolioIn,request);
					gtCad = true;
				}
					if(!gtCad){
					errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
					errorDTO.setHttpStatusCode(String.valueOf(response.getStatusCode().value()));
					errorDTO.setCode(messageErrorDTO.getErrorcode());
					errorDTO.setMessage(messageErrorDTO.getErrormessage());
					response = new ResponseEntity<ErrorDTO>(errorDTO, response.getStatusCode());
				}
			}
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context = null;
			initialUploadImageFolioServiceImpl=null;
			headers=null;
			errorDTO=null;
			messageErrorDTO=null;
		}				
		return response;
		
	}

}
