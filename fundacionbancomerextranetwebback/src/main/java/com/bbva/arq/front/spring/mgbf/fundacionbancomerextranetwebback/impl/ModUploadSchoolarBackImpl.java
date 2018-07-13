package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ModUploadSchoolarBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ModUploadDataScholarInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialModUploadScholarServiceImpl;

/**
 * Class ModUploadSchoolarBackImpl implements the ModUploadSchoolarBack interface
 * Contains the implementations of the method modUploadSchoolarArmed to consume the service MGBFTB02
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class ModUploadSchoolarBackImpl implements ModUploadSchoolarBack{
	private static final Logger log = Logger.getLogger(ModUploadSchoolarBackImpl.class);
	private boolean gtCad = false;
	
  	/**      
    *
    * Method modUploadSchoolarArmed.
    * Contains the parameters for get the URL for the service MGBFTB02
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param ModUploadDataScholarInDTO beanModUploadDataSchoolarIn
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> modUploadSchoolarArmed(ModUploadDataScholarInDTO beanModUploadDataSchoolarIn, HttpServletRequest request) {log.info("Inside modUploadSchoolarArmed");
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context=null;
		InitialModUploadScholarServiceImpl initialModUploadScholarClientServiceImpl=null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialModUploadScholarClientServiceImpl = (InitialModUploadScholarServiceImpl) context.getBean("modUplSchoServiceCli");
			log.info("After Autoinstance - modUploadSchoolarArmed");
			headers.setContentType(MediaType.APPLICATION_JSON);		
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());
			log.info("headers-modUploadSchoolarArmed = "+headers);
			response = initialModUploadScholarClientServiceImpl.modUploadScholar(beanModUploadDataSchoolarIn, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - modUploadSchoolarArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();

				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.modUploadSchoolarArmed(beanModUploadDataSchoolarIn,request);
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
			initialModUploadScholarClientServiceImpl=null;
			headers=null;
			errorDTO=null;
			messageErrorDTO=null;
		}	
		return response;
		
	}
	
	

}
