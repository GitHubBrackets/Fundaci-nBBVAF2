package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ConsultParametersInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialConsultParametersService;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;

/**
 * Class InitialConsultParametersServiceImpl implements the InitialConsultParametersService interface
 * Contains the implementations of method consultParameters to consume the service MGBFTP01
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class InitialConsultParametersServiceImpl implements InitialConsultParametersService {
	private static final Logger log = Logger.getLogger(InitialConsultParametersServiceImpl.class);
	

  	/**      
    *
    * Method consultParameters.
    * Contains the parameters for get the URL for the service MGBFTP01
    * @return HttpEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param ConsultParametersInDTO beanConsultParametersInDTOIn
    * @param HttpHeaders headers
	*
    */
	@Override
	public ResponseEntity<?> consultParameters(ConsultParametersInDTO beanConsultParametersInDTOIn,	HttpHeaders headers) {log.info("Inside consultParameters");
		String finalUrl=null;
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		ConsumerServiceImpl consumerServiceImpl=null;
		AsoUtils asoUtils=null;
		try{
			context=SingletonApplicationContext.getInstance();
			log.info("headers-consultParameters = "+headers);
			asoUtils = (AsoUtils) context.getBean("asoUtils");
			consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
			log.info("After autoinstance - consultParameters");
			finalUrl = asoUtils.getUrlsAso(AsoUtils.INT_URL_CONSULT_PARAMETERS);
			log.info("EndUrl-consultParameters = "+finalUrl);
			response = consumerServiceImpl.restServiceConsume(HttpMethod.POST, finalUrl, beanConsultParametersInDTOIn, headers);
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context.close();
			finalUrl=null;
			consumerServiceImpl=null;
			asoUtils=null;
			context = null;
		}	

			return response;
	}

}
