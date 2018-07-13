package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DepositModificationInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialDepositModificationService;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;

/**
 * Class InitialDepositModificationClientServiceImpl implements the InitialDepositModificationClientService interface
 * Contains the implementations of method depositModification to consume the service MGBFTH02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class InitialDepositModificationServiceImpl implements	InitialDepositModificationService {
	private static final Logger log = Logger.getLogger(InitialDepositModificationServiceImpl.class);
	

  	/**      
    *
    * Method depositModification.
    * Contains the parameters for get the URL for the service MGBFTH02
    * @return HttpEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param DepositModificationInDTO beanDepositModificationIn
    * @param HttpHeaders headers
	*
    */
	@Override
	public ResponseEntity<?> depositModification(DepositModificationInDTO beanDepositModificationIn,HttpHeaders headers) {log.info("Inside depositModification");
		ClassPathXmlApplicationContext context=null;
		String finalUrl=null;
		ResponseEntity<?> response=null;
		ConsumerServiceImpl consumerServiceImpl=null;
		AsoUtils asoUtils=null;
		try{
			context=SingletonApplicationContext.getInstance();
			log.info("headers-depositModification = "+headers);
			asoUtils = (AsoUtils) context.getBean("asoUtils");
			consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
			log.info("After autoinstance - depositModification");
			finalUrl = asoUtils.getUrlsAso(AsoUtils.INT_URL_MODIF_DEPOSIT);
			log.info("EndUrl-depositModification = "+finalUrl);
			response = consumerServiceImpl.restServiceConsume(HttpMethod.POST, finalUrl, beanDepositModificationIn, headers);
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context.close();
			context=null;
			finalUrl=null;
			consumerServiceImpl=null;
			asoUtils=null;
		}
			return response;
	}
}
