package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ModUploadDataScholarInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialModUploadScholarClientService;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;

/**
 * Class InitialModUploadScholarClientServiceImpl implements the InitialModUploadScholarClientService interface
 * Contains the implementations of method modUploadScholar to consume the service MGBFTB02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class InitialModUploadScholarClientServiceImpl implements InitialModUploadScholarClientService {
	private static final Logger log = Logger.getLogger(InitialModUploadScholarClientServiceImpl.class);
	private static final String CONFILE= "classpath*:/META-INF/spring/applicationContext.xml";

  	/**      
    *
    * Method modUploadScholar.
    * Contains the parameters for get the URL for the service MGBFTB02
    * @return HttpEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param ModUploadDataScholarInDTO beanModUploadDataScholarIn
    * @param HttpHeaders headers
	*
    */
	@Override
	public ResponseEntity<?> modUploadScholar(ModUploadDataScholarInDTO beanModUploadDataScholarIn,HttpHeaders headers) {log.info("Inside modUploadScholar");
		String finalUrl=null;
		ConfigurableApplicationContext context=null;
		ResponseEntity<?> response=null;
		AsoUtils asoUtils=null;
		ConsumerServiceImpl consumerServiceImpl=null;
		context = new ClassPathXmlApplicationContext(CONFILE);
		try{
			log.info("headers-modUploadScholar = "+headers);
			asoUtils = (AsoUtils) context.getBean("asoUtils");
			consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
			log.info("After Autoinstance - modUploadScholar");
			finalUrl = asoUtils.getUrlsAso(AsoUtils.INT_URL_MOD_UPLOAD_SCHOLAR);	
			log.info("EndUrl-modUploadScholar = "+finalUrl);
			response = consumerServiceImpl.restServiceConsume(HttpMethod.POST, finalUrl, beanModUploadDataScholarIn, headers);
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context.close();
			context=null;
			finalUrl=null;
			asoUtils=null;
			consumerServiceImpl=null;
		}	

			return response;
		
	}

}
