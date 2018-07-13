package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.LdapUpdatePasswordScholarBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UpdatePasswordScholarshipUserInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialLdapUpdateScholarServiceImpl;

/**
 * Class LdapUpdatePasswordScholarBackImpl implements the LdapUpdatePasswordScholar interface
 * Contains the implementations of the method ldapUpdateArmed to consume the service (Update Password Scholar-ldap)
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class LdapUpdatePasswordScholarBackImpl implements LdapUpdatePasswordScholarBack {
	private static final Logger log = Logger.getLogger(LdapUpdatePasswordScholarBackImpl.class);
	
	private boolean gtCad = false;

  	/**      
    *
    * Method ldapUpdateArmed.
    * Contains the parameters for get the URL for the service (Update Password Scholar-ldap)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param UpdatePasswordScholarshipUserInDTO beanUpdatePasswordScholarshipUserInDTO
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> ldapUpdateArmed(UpdatePasswordScholarshipUserInDTO beanUpdatePasswordScholarshipUserInDTO,HttpServletRequest request) {
		ResponseEntity<?> response=null;
		InitialLdapUpdateScholarServiceImpl initialLdapUpdateScholarImpl=null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		ClassPathXmlApplicationContext context=null;
		context=SingletonApplicationContext.getInstance();
		try{
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialLdapUpdateScholarImpl = (InitialLdapUpdateScholarServiceImpl) context.getBean("ldapUpdateScho");
			log.info("After Autoinstance - detailScholarArmed");
			headers.setContentType(MediaType.APPLICATION_JSON);					
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());	
			log.info("headers-detailScholarArmed = "+headers);
			response = initialLdapUpdateScholarImpl.ldapUpdateScholar(beanUpdatePasswordScholarshipUserInDTO, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - detailScholarArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();

				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.ldapUpdateArmed(beanUpdatePasswordScholarshipUserInDTO,request);
					gtCad = true;
				}
				if(!gtCad){
					errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
					errorDTO.setHttpStatusCode(String.valueOf(response.getStatusCode().value()));
					errorDTO.setCode(messageErrorDTO.getErrorcode());
					errorDTO.setMessage("Error, "+messageErrorDTO.getErrormessage());
					response = new ResponseEntity<ErrorDTO>(errorDTO, response.getStatusCode());
				}
			}
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context=null;
			initialLdapUpdateScholarImpl=null;
			headers=null;
			errorDTO=null;
			messageErrorDTO=null;
		}
			
	return response;
	}

}
