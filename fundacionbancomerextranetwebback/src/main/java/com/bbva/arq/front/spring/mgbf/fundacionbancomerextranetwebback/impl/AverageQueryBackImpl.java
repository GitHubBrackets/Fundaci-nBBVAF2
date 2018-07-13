package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.AverageQueryBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.AveragesQueryInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialAverageQueryServiceImpl;

/**
 * Class AverageQueryBackImpl implements the AverageQueryBack interface
 * Contains the implementations of the method averageQueryArmed to consume the service MGBFTC03
 * 
 * @author Diego Espinoza
 * @version 28 november 2017 
 */
public class AverageQueryBackImpl implements AverageQueryBack {
	private static final Logger log = Logger.getLogger(AverageQueryBackImpl.class);
	private boolean gtCad = false;
	
  	/**      
    *
    * Method averageQueryArmed.
    * Contains the parameters for get the URL for the service MGBFTC03
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param AveragesQueryInDTO beanAverageQueryIn
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> averageQueryArmed(AveragesQueryInDTO beanAverageQueryIn, HttpServletRequest request) {	log.info("Dentro de averageQueryArmed");
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		InitialAverageQueryServiceImpl initialAverageQueryServiceImpl = null;
		HttpHeaders headers = null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		try{	
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialAverageQueryServiceImpl = (InitialAverageQueryServiceImpl) context.getBean("averagQueryServCli");
			log.info("After Autoinstance - averageQueryArmed");
			headers.setContentType(MediaType.APPLICATION_JSON);		
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());
			log.info("headers-averageQueryArmed = "+headers);
			response = initialAverageQueryServiceImpl.averageQueryClient(beanAverageQueryIn, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - averageQueryArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();
	
				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.averageQueryArmed(beanAverageQueryIn,request);
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
			initialAverageQueryServiceImpl=null;
			errorDTO = null;
			messageErrorDTO = null;
		}			
		return response;
	}

}
