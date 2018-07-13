package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.ValidationScholarBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ValidationscholarInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialValidationScholarServiceImpl;

/**
 * Class ValidationScholarBackImpl implements the ValidationScholarBack interface
 * Contains the implementations of the method validationScholarArmed to consume the service MGBFTL01
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class ValidationScholarBackImpl implements ValidationScholarBack {
	private static final Logger log = Logger.getLogger(ValidationScholarBackImpl.class);
	
	private boolean gtCad = false;
	
  	/**      
    *
    * Method validationScholarArmed.
    * Contains the parameters for get the URL for the service MGBFTL01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param ValidationscholarInDTO beanScholarIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> validationScholarArmed(ValidationscholarInDTO beanScholarIn, HttpServletRequest request) {log.info("Inside validationScholarArmed");
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		InitialValidationScholarServiceImpl initialValidationScholarClientServiceImpl = null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		try{			
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialValidationScholarClientServiceImpl = (InitialValidationScholarServiceImpl) context.getBean("validSchoServiceCli");
			log.info("After Autoinstance - validationScholarArmed");
			headers.setContentType(MediaType.APPLICATION_JSON);	
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());	
			log.info("headers-validationScholarArmed = "+headers);
			response = initialValidationScholarClientServiceImpl.validationScholar(beanScholarIn, headers);
			log.info("response111 = "+response);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - validationScholarArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();

				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.validationScholarArmed(beanScholarIn,request);
					log.info("response with Tsec Timed out = "+response);
					gtCad = true;
				}
				if(!gtCad){
					errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
					errorDTO.setHttpStatusCode(String.valueOf(response.getStatusCode().value()));
					errorDTO.setCode(messageErrorDTO.getErrorcode());
					errorDTO.setMessage("Error, "+messageErrorDTO.getErrormessage());
					response = new ResponseEntity<ErrorDTO>(errorDTO, response.getStatusCode());
				}
			}
		}catch(Exception exc){
				throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context=null;
			initialValidationScholarClientServiceImpl=null;
			headers=null;
			errorDTO=null;
			messageErrorDTO=null;
		}	
		return response;
	}

}
