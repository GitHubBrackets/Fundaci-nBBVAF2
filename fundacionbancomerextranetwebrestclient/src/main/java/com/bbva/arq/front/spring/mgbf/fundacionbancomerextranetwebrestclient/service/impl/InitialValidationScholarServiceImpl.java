package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;


import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ValidationscholarInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialValidationScholarService;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;

/**
 * Class InitialValidationScholarClientServiceImpl implements the InitialValidationScholarClientService interface
 * Contains the implementations of method validationScholar to consume the service MGBFTL01
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */

public class InitialValidationScholarServiceImpl implements InitialValidationScholarService {
	private static final Logger log = Logger.getLogger(InitialValidationScholarServiceImpl.class);


  	/**      
    *
    * Method validationScholar.
    * Contains the parameters for get the URL for the service MGBFTL01
    * @return HttpEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param ValidationscholarInDTO beanScholarIn
    * @param HttpHeaders headers
	*
    */
	@Override
	public ResponseEntity<?> validationScholar(	ValidationscholarInDTO beanScholarIn, HttpHeaders headers) {log.info("Inside validationScholar");
		ClassPathXmlApplicationContext context=null;
		String finalUrl=null;
		ResponseEntity<?> response=null;
		AsoUtils asoUtils=null;
		ConsumerServiceImpl consumerServiceImpl=null;
		try{
			context=SingletonApplicationContext.getInstance();
			log.info("headers-validationScholar = "+headers);
			asoUtils = (AsoUtils) context.getBean("asoUtils");
			consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
			log.info("After Autoinstance - validationScholar");
			finalUrl = asoUtils.getUrlsAso(AsoUtils.INT_URL_VALIDATE_SCHOLAR);		
			log.info("EndUrl-validationScholar = "+finalUrl);
			response = consumerServiceImpl.restServiceConsume(HttpMethod.POST, finalUrl, beanScholarIn, headers);
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context=null;
			finalUrl=null;
			asoUtils=null;
			consumerServiceImpl=null;
		}
		return response;
	}
	
}
