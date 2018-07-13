package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.QualificationQueryBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.QualificationsQueryInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialQualificationQueryServiceImpl;

/**
 * Class QualificationQueryBackImpl implements the QualificationQueryBack interface
 * Contains the implementations of the method qualificationsQueryInDTOArmed to consume the service MGBFTC02
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class QualificationQueryBackImpl implements QualificationQueryBack {
	private static final Logger log = Logger.getLogger(QualificationQueryBackImpl.class);
	
	private boolean gtCad = false;
	
  	/**      
    *
    * Method qualificationsQueryInDTOArmed.
    * Contains the parameters for get the URL for the service MGBFTC02
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param QualificationsQueryInDTO beanQualificationsQueryIn
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> qualificationsQueryInDTOArmed(	QualificationsQueryInDTO beanQualificationsQueryIn,	HttpServletRequest request) {log.info("Inside qualificationsQueryInDTOArmed");
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context=null;
		InitialQualificationQueryServiceImpl initialQualificationQueryServiceImpl=null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialQualificationQueryServiceImpl = (InitialQualificationQueryServiceImpl) context.getBean("qualifQuerServiceCli");
			log.info("After Autoinstance - qualificationsQueryInDTOArmed");		
			headers.setContentType(MediaType.APPLICATION_JSON);		
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());
			log.info("headers-qualificationsQueryInDTOArmed = "+headers);
			response = initialQualificationQueryServiceImpl.qualificationQuery(beanQualificationsQueryIn, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - qualificationsQueryInDTOArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();

				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.qualificationsQueryInDTOArmed(beanQualificationsQueryIn,request);
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
			initialQualificationQueryServiceImpl=null;
			context=null;
			headers=null;
			errorDTO=null;
			messageErrorDTO=null;
		}				
			return response;
	}

}
