package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ListArchivingDocumentsBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ListArchivingDocumentsInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialListArchivingDocumentsServiceImpl;
    
/**
 * Class ListArchivingDocumentsBackImpl implements the ListArchivingDocumentsBack interface
 * Contains the implementations of the method listArchivingDocumentsArmed to consume the service (List Document-Archving)
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class ListArchivingDocumentsBackImpl implements ListArchivingDocumentsBack{
	private static final Logger log = Logger.getLogger(ListArchivingDocumentsBackImpl.class);
	private boolean gtCad = false;
	
  	/**      
    *
    * Method listArchivingDocumentsArmed.
    * Contains the parameters for get the URL for the service MGBFTK01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param ListArchivingDocumentsInDTO beanListArchivingDocumentsIn
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> listArchivingDocumentsArmed( ListArchivingDocumentsInDTO beanListArchivingDocumentsIn, HttpServletRequest request) {log.info("Inside listArchivingDocumentsArmed");
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context=null;
		InitialListArchivingDocumentsServiceImpl initialListArchivingDocumentsServiceImpl=null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialListArchivingDocumentsServiceImpl = (InitialListArchivingDocumentsServiceImpl) context.getBean("listArchDocuServiceCli");
			log.info("After Autoinstance - listArchivingDocumentsArmed");
			headers.setContentType(MediaType.APPLICATION_JSON);		
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());	
			log.info("headers-listArchivingDocumentsArmed = "+headers);
			response = initialListArchivingDocumentsServiceImpl.listArchivingDocumentsClient(beanListArchivingDocumentsIn, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - listArchivingDocumentsArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();

				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.listArchivingDocumentsArmed(beanListArchivingDocumentsIn,request);
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
			initialListArchivingDocumentsServiceImpl = null;
			headers = null;
			errorDTO = null;
			messageErrorDTO = null;
		}	
		return response;
	}

}
