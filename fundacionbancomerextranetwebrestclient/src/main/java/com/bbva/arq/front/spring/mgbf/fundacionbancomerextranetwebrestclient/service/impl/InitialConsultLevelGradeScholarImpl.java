package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ConsultLevelAndGradeScholarInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialConsultLevelGradeScholar;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;

/**
 * Class InitialConsultLevelGradeScholarImpl implements the InitialConsultLevelGradeScholar interface
 * Contains the implementations of method consultLevelAndGradeScholar to consume the service MGBFTB04
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class InitialConsultLevelGradeScholarImpl implements InitialConsultLevelGradeScholar {
	private static final Logger log = Logger.getLogger(InitialConsultLevelGradeScholarImpl.class);
	private static final String CONFILE= "classpath*:/META-INF/spring/applicationContext.xml";
	
  	/**      
    *
    * Method consultLevelAndGradeScholar.
    * Contains the parameters for get the URL for the service MGBFTB04
    * @return HttpEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param ConsultLevelAndGradeScholarInDTO beanConsultLevelAndGradeScholarIn
    * @param HttpHeaders headers
	*
    */
	@Override
	public ResponseEntity<?> consultLevelAndGradeScholar(ConsultLevelAndGradeScholarInDTO beanConsultLevelAndGradeScholarIn, HttpHeaders headers) {log.info("Inside consultLevelAndGradeScholar");
		String finalUrl=null;
		ConfigurableApplicationContext context=null;
		ResponseEntity<?> response=null;
		ConsumerServiceImpl consumerServiceImpl=null;
		AsoUtils asoUtils=null;
		context = new ClassPathXmlApplicationContext(CONFILE);
		try{
			log.info("headers-consultLevelAndGradeScholar = "+headers);
			asoUtils = (AsoUtils) context.getBean("asoUtils");
			consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
			log.info("After autoinstance - consultLevelAndGradeScholar");
			finalUrl = asoUtils.getUrlsAso(AsoUtils.INT_URL_CONSULT_LEVEL_AND_GRADE_SCHOLAR);
			log.info("EndUrl-consultLevelAndGradeScholar = "+finalUrl);
			response = consumerServiceImpl.restServiceConsume(HttpMethod.POST, finalUrl, beanConsultLevelAndGradeScholarIn, headers);
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
