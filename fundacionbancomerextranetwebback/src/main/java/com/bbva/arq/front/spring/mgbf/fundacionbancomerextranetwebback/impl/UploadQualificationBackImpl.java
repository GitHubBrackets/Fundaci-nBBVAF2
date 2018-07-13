package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.UploadQualificationBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UploadQualificationsInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialUploadQualificationServiceImpl;

/**
 * Class UploadQualificationBackImpl implements the UploadQualificationBack interface
 * Contains the implementations of the method uploadQualificationArmed to consume the service MGBFTC01
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class UploadQualificationBackImpl implements UploadQualificationBack {
	private static final Logger log = Logger.getLogger(UploadQualificationBackImpl.class);

	private boolean gtCad = false;
	
  	/**      
    *
    * Method uploadQualificationArmed.
    * Contains the parameters for get the URL for the service MGBFTC01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param UploadQualificationsInDTO beanUpdateQualificationIn
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> uploadQualificationArmed(UploadQualificationsInDTO beanUpdateQualificationIn, HttpServletRequest request) {log.info("Inside uploadQualificationArmed");
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context=null;
		InitialUploadQualificationServiceImpl initialUploadQualificationServiceImpl=null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialUploadQualificationServiceImpl = (InitialUploadQualificationServiceImpl) context.getBean("uploadQualifServiceCli");
			log.info("After Autoinstance - uploadQualificationArmed");
			headers.setContentType(MediaType.APPLICATION_JSON);		
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());
			log.info("headers-uploadQualificationArmed = "+headers);
			response = initialUploadQualificationServiceImpl.uploadQualification(beanUpdateQualificationIn, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - uploadQualificationArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();

				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.uploadQualificationArmed(beanUpdateQualificationIn,request);
					log.info("response with Tsec Timed out = "+response);
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
			context=null;
			initialUploadQualificationServiceImpl=null;
			headers=null;
			errorDTO=null;
			messageErrorDTO=null;
		}	
		return response;
	}

}
