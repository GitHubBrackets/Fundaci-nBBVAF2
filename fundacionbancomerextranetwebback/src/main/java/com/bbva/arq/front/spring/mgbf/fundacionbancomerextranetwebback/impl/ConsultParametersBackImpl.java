package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ConsultParametersBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ConsultParametersInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialConsultParametersServiceImpl;

/**
 * Class ConsultParametersBackImpl implements the ConsultParametersBack interface
 * Contains the implementations of the method consultParametersArmed to consume the service MGBFTP01
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class ConsultParametersBackImpl implements ConsultParametersBack {
	private static final Logger log = Logger.getLogger(ConsultParametersBackImpl.class);
	private boolean gtCad = false;
	
  	/**      
    *
    * Method consultParametersArmed.
    * Contains the parameters for get the URL for the service MGBFTP01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param ConsultParametersInDTO beanConsultParametersIn
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> consultParametersArmed(ConsultParametersInDTO beanConsultParametersIn,	HttpServletRequest request) {log.info("Inside consultParametersArmed");
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		InitialConsultParametersServiceImpl initialConsultParametersServiceImpl = null;
		HttpHeaders headers = null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialConsultParametersServiceImpl = (InitialConsultParametersServiceImpl) context.getBean("consultParamServiceCli");
			log.info("After Autoinstance - consultParametersArmed");																		   
			headers.setContentType(MediaType.APPLICATION_JSON);		
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());
			log.info("headers-consultParametersArmed = "+headers);
			response = initialConsultParametersServiceImpl.consultParameters(beanConsultParametersIn, headers);
			
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - consultParametersArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();
	
				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.consultParametersArmed(beanConsultParametersIn,request);
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
			initialConsultParametersServiceImpl=null;
		}			
		return response;
	}

}
