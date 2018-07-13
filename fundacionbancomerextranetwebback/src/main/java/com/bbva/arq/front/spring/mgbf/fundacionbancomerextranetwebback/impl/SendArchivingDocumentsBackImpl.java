package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.SendArchivingDocumentsBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.SendArchivingDocumentsInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialSendArchivingDocumentsServiceImpl;

/**
 * Class LdapCreateScholarBackImpl implements the LdapCreateScholar interface
 * Contains the implementations of the method sendArchivingDocumentsArmed to consume the service (Send Document-Archiving)
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class SendArchivingDocumentsBackImpl implements SendArchivingDocumentsBack{
	private static final Logger log = Logger.getLogger(SendArchivingDocumentsBackImpl.class);
	
	private boolean gtCad = false;
	
  	/**      
    *
    * Method sendArchivingDocumentsArmed.
    * Contains the parameters for get the URL for the service (Send Document-Archiving)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param SendArchivingDocumentsInDTO beanSendArchivingDocumentsIn
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> sendArchivingDocumentsArmed( SendArchivingDocumentsInDTO beanSendArchivingDocumentsIn, HttpServletRequest request) {log.info("Inside sendArchivingDocumentsArmed");
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context=null;
		InitialSendArchivingDocumentsServiceImpl initialSendArchivingDocumentsServiceImpl=null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialSendArchivingDocumentsServiceImpl = (InitialSendArchivingDocumentsServiceImpl) context.getBean("sendArchDocuServiceCli");
			log.info("After Autoinstance - sendArchivingDocumentsArmed");
			headers.setContentType(MediaType.APPLICATION_JSON);		
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());	
			log.info("headers-sendArchivingDocumentsArmed = "+headers);
			response = initialSendArchivingDocumentsServiceImpl.sendArchivingDocumentsClient(beanSendArchivingDocumentsIn, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - sendArchivingDocumentsArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();
				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.sendArchivingDocumentsArmed(beanSendArchivingDocumentsIn,request);
					gtCad=true;
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
			initialSendArchivingDocumentsServiceImpl=null;
			context = null;
			headers=null;
			errorDTO=null;
			messageErrorDTO=null;
		}	
			return response;
	}

}
