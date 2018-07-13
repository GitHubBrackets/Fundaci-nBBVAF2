package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.DepositModificationBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DepositModificationInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialDepositModificationServiceImpl;

/**
 * Class DepositModificationBackImpl implements the DepositModificationBack interface
 * Contains the implementations of the method depositModificationArmed to consume the service MGBFTH02
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class DepositModificationBackImpl implements DepositModificationBack {
	private static final Logger log = Logger.getLogger(DepositModificationBackImpl.class);
	private boolean gtCad = false;
	
  	/**      
    *
    * Method depositModificationArmed.
    * Contains the parameters for get the URL for the service MGBFTH02
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param DepositModificationInDTO beanDepositModificationIn
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> depositModificationArmed(DepositModificationInDTO beanDepositModificationIn, HttpServletRequest request) {log.info("Inside DepositModificationBackImpl");
		ResponseEntity<?> response=null;
		InitialDepositModificationServiceImpl initialDepositModificationClientServiceImpl=null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		ClassPathXmlApplicationContext context=null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialDepositModificationClientServiceImpl = (InitialDepositModificationServiceImpl) context.getBean("depositModifServiceCli");
			log.info("After Autoinstance - DepositModificationBackImpl");
			headers.setContentType(MediaType.APPLICATION_JSON);		
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());	
			log.info("headers-DepositModificationBackImpl = "+headers);
			response = initialDepositModificationClientServiceImpl.depositModification(beanDepositModificationIn, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - DepositModificationBackImpl ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();

				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
				request.getSession().setAttribute("tsec", null);
					response = this.depositModificationArmed(beanDepositModificationIn,request);
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
			context = null;
			headers=null;
			errorDTO = null;
			messageErrorDTO = null;
			initialDepositModificationClientServiceImpl = null;
		}
			return response;
	}
}