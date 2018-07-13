package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.AlertInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialAlertService;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;

/**
 * Class InitialAlertServiceImpl implements the InitialAlertService interface
 * Contains the implementations of the method alertClient to consume the service MGBFTK01
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class InitialAlertServiceImpl implements InitialAlertService{
	private static final Logger log = Logger.getLogger(InitialAlertServiceImpl.class);

  	/**      
    *
    * Method alertClient.
    * Contains the parameters for get the URL for the service MGBFTK01
    * @return HttpEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param AlertInDTO valor
    * @param HttpHeaders headers
	*
    */
	@Override
	public ResponseEntity<?> alertClient(AlertInDTO valor, HttpHeaders headers) {log.info("Inside alertClient");
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context=null;
		String finalUrl=null;
		AsoUtils asoUtils=null;
		ConsumerServiceImpl consumerServiceImpl=null;
		try{
			context=SingletonApplicationContext.getInstance();
			log.info("headers-alertClient = "+headers);
			asoUtils = (AsoUtils) context.getBean("asoUtils");
			consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
			log.info("After autoinstance - alertClient");
			finalUrl = asoUtils.getUrlsAso(AsoUtils.INT_URL_ALERTS);
			log.info("EndUrl-alertClient = "+finalUrl);
			response = consumerServiceImpl.restServiceConsume(HttpMethod.POST, finalUrl, valor, headers);
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context = null;
			finalUrl=null;
			asoUtils=null;
			consumerServiceImpl=null;
		}
		return response;
	}

}
