package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.LdapReactivationScholarBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.RequestReactivationaScholarshipUserInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialLdapReactivationScholarServiceImpl;

/**
 * Class LdapReactivationScholarBackImpl implements the LdapReactivationScholar interface
 * Contains the implementations of the method ldapReactivationArmed to consume the service (Reactivation Scholar-ldap)
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class LdapReactivationScholarBackImpl implements  LdapReactivationScholarBack{
	private static final Logger log = Logger.getLogger(LdapReactivationScholarBackImpl.class);
	
	private boolean gtCad = false;

  	/**      
    *
    * Method ldapReactivationArmed.
    * Contains the parameters for get the URL for the service (Reactivation Scholar-ldap)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param RequestReactivationaScholarshipUserInDTO beanRequestReactivationaScholarshipUserInDTO
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> ldapReactivationArmed(RequestReactivationaScholarshipUserInDTO beanRequestReactivationaScholarshipUserInDTO,HttpServletRequest request) {
		ResponseEntity<?> response=null;
		InitialLdapReactivationScholarServiceImpl initialLdapReactivationScholarImpl=null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		ClassPathXmlApplicationContext context=null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialLdapReactivationScholarImpl = (InitialLdapReactivationScholarServiceImpl) context.getBean("ldapReactivaScho");
			log.info("After Autoinstance - detailScholarArmed");
			headers.setContentType(MediaType.APPLICATION_JSON);					
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());	
			log.info("headers-detailScholarArmed = "+headers);
			response = initialLdapReactivationScholarImpl.ldapReactivationScholar(beanRequestReactivationaScholarshipUserInDTO, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - detailScholarArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();

				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.ldapReactivationArmed(beanRequestReactivationaScholarshipUserInDTO,request);
					gtCad = true;
				}
				if(gtCad == false){
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
			initialLdapReactivationScholarImpl=null;
			headers=null;
			errorDTO=null;
			messageErrorDTO=null;
		}
			
	return response;
	}

}
