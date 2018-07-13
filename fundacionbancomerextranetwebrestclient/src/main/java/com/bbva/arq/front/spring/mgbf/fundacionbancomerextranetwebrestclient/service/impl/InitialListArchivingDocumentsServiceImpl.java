package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ListArchivingDocumentsInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialListArchivingDocumentsService;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;

/**
 * Class InitialListArchivingDocumentsServiceImpl implements the InitialListArchivingDocumentsService interface
 * Contains the implementations of method listArchivingDocumentsClient to consume the service (List Document-Archiving)
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class InitialListArchivingDocumentsServiceImpl implements InitialListArchivingDocumentsService {
	private static final Logger log = Logger.getLogger(InitialListArchivingDocumentsServiceImpl.class);
	

  	/**      
    *
    * Method listArchivingDocumentsClient.
    * Contains the parameters for get the URL for the service (List Document-Archiving)
    * @return HttpEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param ListArchivingDocumentsInDTO beanListArchivingDocumentsIn
    * @param HttpHeaders headers
	*
    */
	@Override
	public ResponseEntity<?> listArchivingDocumentsClient(ListArchivingDocumentsInDTO beanListArchivingDocumentsIn,HttpHeaders headers) {log.info("Inside listArchivingDocumentsClient");
		String finalUrl=null;
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context=null;
		AsoUtils asoUtils=null;
		ConsumerServiceImpl consumerServiceImpl=null;
		try{
			context=SingletonApplicationContext.getInstance();
			log.info("headers-listArchivingDocumentsClient = "+headers);
			asoUtils = (AsoUtils) context.getBean("asoUtils");
			consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
			log.info("After Autoinstancia - listArchivingDocumentsClient");
			finalUrl = asoUtils.getUrlsAso(AsoUtils.INT_URL_LIST_ARCHIVING_DOCUMENTS);
			log.info("EndUrl-listArchivingDocumentsClient = "+finalUrl);
			response = consumerServiceImpl.restServiceConsume(HttpMethod.POST, finalUrl, beanListArchivingDocumentsIn, headers);
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
