package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UpdatePasswordScholarshipUserInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialLdapUpdateScholarService;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;

/**
 * Class InitialLdapUpdateScholarImpl implements the InitialLdapUpdateScholar interface
 * Contains the implementations of method ldapUpdateScholar to consume the service (Update Scholar-ldap)
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class InitialLdapUpdateScholarServiceImpl implements InitialLdapUpdateScholarService {
	private static final Logger log = Logger.getLogger(InitialLdapUpdateScholarServiceImpl.class);


  	/**      
    *
    * Method ldapUpdateScholar.
    * Contains the parameters for get the URL for the service (Update Scholar-ldap)
    * @return HttpEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param UpdatePasswordScholarshipUserInDTO beanUpdatePasswordScholarshipUserInDTO
    * @param HttpHeaders headers
	*
    */
	@Override
	public ResponseEntity<?> ldapUpdateScholar(UpdatePasswordScholarshipUserInDTO beanUpdatePasswordScholarshipUserInDTO,HttpHeaders headers) {log.info("Inside ldapUpdateScholar");
		ClassPathXmlApplicationContext context=null;
		String finalUrl=null;
		ResponseEntity<?> response=null;
		AsoUtils asoUtils=null;
		ConsumerServiceImpl consumerServiceImpl=null;
		try{
			context=SingletonApplicationContext.getInstance();
			log.info("headers-ldapUpdateScholar = "+headers);
			asoUtils = (AsoUtils) context.getBean("asoUtils");
			consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
			log.info("After autoinstance - ldapUpdateScholar");
			finalUrl = asoUtils.getUrlsAso(AsoUtils.URL_LDAP_UPDATEPASSWORD_SCHOLAR);			
			log.info("EndUrl-ldapUpdateScholar = "+finalUrl);
			response = consumerServiceImpl.restServiceConsume(HttpMethod.POST, finalUrl, beanUpdatePasswordScholarshipUserInDTO, headers);			
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
