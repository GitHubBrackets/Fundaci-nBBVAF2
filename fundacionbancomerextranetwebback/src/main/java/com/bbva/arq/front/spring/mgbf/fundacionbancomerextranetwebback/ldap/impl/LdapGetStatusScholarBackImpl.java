package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.LdapGetStatusScholarBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.GetStatusScholarshipUserInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialLdapGetStatusScholarServiceImpl;

/**
 * Class LdapGetStatusScholarBackImpl implements the LdapGetStatusScholar interface
 * Contains the implementations of the method ldapGetStatusArmed to consume the service (Get Status Scholar-ldap)
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class LdapGetStatusScholarBackImpl implements LdapGetStatusScholarBack{
	private static final Logger log = Logger.getLogger(LdapGetStatusScholarBackImpl.class);

	private boolean gtCad = false;


  	/**      
    *
    * Method ldapGetStatusArmed.
    * Contains the parameters for get the URL for the service (Get Status Scholar-ldap)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param GetStatusScholarshipUserInDTO beanGetStatusScholarshipUserInDTO
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> ldapGetStatusArmed(GetStatusScholarshipUserInDTO beanGetStatusScholarshipUserInDTO,HttpServletRequest request) {
		ResponseEntity<?> response=null;
		InitialLdapGetStatusScholarServiceImpl initialLdapGetStatusScholarImpl=null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		ClassPathXmlApplicationContext context=null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialLdapGetStatusScholarImpl = (InitialLdapGetStatusScholarServiceImpl) context.getBean("ldapGetStatusScho");
			log.info("After Autoinstance - detailScholarArmed");
			headers.setContentType(MediaType.APPLICATION_JSON);					
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());	
			log.info("headers-detailScholarArmed = "+headers);
			response = initialLdapGetStatusScholarImpl.ldapGetStatusScholar(beanGetStatusScholarshipUserInDTO, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - detailScholarArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();

				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.ldapGetStatusArmed(beanGetStatusScholarshipUserInDTO, request);
					gtCad = true;
				}
				if(!gtCad){
					errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
					errorDTO.setHttpStatusCode(String.valueOf(response.getStatusCode().value()));
					errorDTO.setCode(messageErrorDTO.getErrorcode());
					errorDTO.setMessage(messageErrorDTO.getErrormessage());
					response = new ResponseEntity<ErrorDTO>(errorDTO, response.getStatusCode());
				}
			}
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context=null;
			initialLdapGetStatusScholarImpl=null;
			headers=null;
			errorDTO=null;
			messageErrorDTO=null;
		}
			
	return response;
	}

}
