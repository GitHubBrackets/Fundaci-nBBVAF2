package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.GetStatusScholarshipUserInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialLdapGetStatusScholarService;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;

/**
 * Class InitialLdapGetStatusScholarImpl implements the InitialLdapGetStatusScholar interface
 * Contains the implementations of method ldapGetStatusScholar to consume the service (Get Status Scholar-ldap)
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class InitialLdapGetStatusScholarServiceImpl implements InitialLdapGetStatusScholarService {
	private static final Logger log = Logger.getLogger(InitialLdapGetStatusScholarServiceImpl.class);
	

  	/**      
    *
    * Method ldapGetStatusScholar.
    * Contains the parameters for get the URL for the service (Get Status Scholar-ldap)
    * @return a HttpEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param GetStatusScholarshipUserInDTO beanGetStatusScholarshipUserInDTO
    * @param HttpHeaders headers
	*
    */
	@Override
	public ResponseEntity<?> ldapGetStatusScholar(GetStatusScholarshipUserInDTO beanGetStatusScholarshipUserInDTO,HttpHeaders headers) {log.info("Inside ldapGetStatusScholar");
		ClassPathXmlApplicationContext context=null;
		String finalUrl=null;
		ResponseEntity<?> response=null;
		AsoUtils asoUtils=null;
		ConsumerServiceImpl consumerServiceImpl=null;
		try{
			context=SingletonApplicationContext.getInstance();
			log.info("headers-ldapGetStatusScholar = "+headers);
			asoUtils = (AsoUtils) context.getBean("asoUtils");
			consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
			log.info("After autoinstance - ldapGetStatusScholar");
			finalUrl = asoUtils.getUrlsAso(AsoUtils.URL_LDAP_GETSTATUS_SCHOLAR);			
			log.info("EndUrl-ldapGetStatusScholar = "+finalUrl);
			response = consumerServiceImpl.restServiceConsume(HttpMethod.POST, finalUrl, beanGetStatusScholarshipUserInDTO, headers);			
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
