package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.DepositQueryBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DepositQueryInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialDepositQueryServiceImpl;

/**
 * Class DepositQueryBackImpl implements the DepositQueryBack interface
 * Contains the implementations of the method depositQueryArmed to consume the service MGFBTH01
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class DepositQueryBackImpl implements DepositQueryBack {
	private static final Logger log = Logger.getLogger(DepositQueryBackImpl.class);
	private boolean gtCad = false;
	
  	/**      
    *
    * Method depositQueryArmed.
    * Contains the parameters for get the URL for the service MGFBTH01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param DepositQueryInDTO beanScholarIn
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> depositQueryArmed(DepositQueryInDTO beanScholarIn, HttpServletRequest request) {log.info("Inside depositQueryArmed");
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		InitialDepositQueryServiceImpl initialDepositQueryClientServiceImpl=null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialDepositQueryClientServiceImpl = (InitialDepositQueryServiceImpl) context.getBean("depositQuerServiceCli");
			log.info("After Autoinstance - depositQueryArmed");
			headers.setContentType(MediaType.APPLICATION_JSON);		
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());
			log.info("headers-depositQueryArmed = "+headers);
			response = initialDepositQueryClientServiceImpl.depositQuery(beanScholarIn, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - depositQueryArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();

				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.depositQueryArmed(beanScholarIn,request);
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
		} finally{
			context = null;
			headers=null;
			errorDTO = null;
			messageErrorDTO = null;
			initialDepositQueryClientServiceImpl = null;
		}
			return response;
	}
}
