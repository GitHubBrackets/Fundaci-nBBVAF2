package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.RequestReactivationaScholarshipUserInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialLdapReactivationScholar;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;

/**
 * Class InitialLdapReactivationScholarImpl implements the InitialLdapReactivationScholar interface
 * Contains the implementations of method ldapReactivationScholar to consume the service (Reactivation Scholar-ldap)
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class InitialLdapReactivationScholarImpl implements InitialLdapReactivationScholar {
	private static final Logger log = Logger.getLogger(InitialLdapReactivationScholarImpl.class);
	private static final String CONFILE= "classpath*:/META-INF/spring/applicationContext.xml";

  	/**      
    *
    * Method ldapReactivationScholar.
    * Contains the parameters for get the URL for the service (Reactivation Scholar-ldap)
    * @return HttpEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param RequestReactivationaScholarshipUserInDTO beanrequestReactivationaScholarshipUserInDTO
    * @param HttpHeaders headers
	*
    */
	@Override
	public ResponseEntity<?> ldapReactivationScholar(RequestReactivationaScholarshipUserInDTO beanrequestReactivationaScholarshipUserInDTO,HttpHeaders headers) {log.info("Inside ldapReactivationScholar");
		ConfigurableApplicationContext context=null;
		String finalUrl=null;
		ResponseEntity<?> response=null;
		AsoUtils asoUtils=null;
		ConsumerServiceImpl consumerServiceImpl=null;
		context = new ClassPathXmlApplicationContext(CONFILE);
		try{
			log.info("headers-ldapReactivationScholar = "+headers);
			asoUtils = (AsoUtils) context.getBean("asoUtils");
			consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
			log.info("After autoinstance - ldapReactivationScholar");
			finalUrl = asoUtils.getUrlsAso(AsoUtils.URL_LDAP_REACTIVATION_SCHOLAR);			
			log.info("EndUrl-ldapReactivationScholar = "+finalUrl);
			response = consumerServiceImpl.restServiceConsume(HttpMethod.POST, finalUrl, beanrequestReactivationaScholarshipUserInDTO, headers);			
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
