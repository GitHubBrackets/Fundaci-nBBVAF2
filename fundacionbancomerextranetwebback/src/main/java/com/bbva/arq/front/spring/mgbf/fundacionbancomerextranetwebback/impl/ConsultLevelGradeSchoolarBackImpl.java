package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ConsultLevelGradeSchoolarBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ConsultLevelAndGradeScholarInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialConsultLevelGradeScholarServiceImpl;

/**
 * Class ConsultLevelGradeSchoolarBackImpl implements the ConsultLevelGradeSchoolarBack interface
 * Contains the implementations of the method consultLevelGradeSchoolarArmed to consume the service MGBFTB04
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class ConsultLevelGradeSchoolarBackImpl implements ConsultLevelGradeSchoolarBack {
	private static final Logger log = Logger.getLogger(ConsultLevelGradeSchoolarBackImpl.class);
	private boolean gtCad = false;
	
  	/**      
    *
    * Method consultLevelGradeSchoolarArmed.
    * Contains the parameters for get the URL for the service MGBFTB04
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param ConsultLevelAndGradeScholarInDTO beanConsultLevelAndGradeIn
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> consultLevelGradeSchoolarArmed(ConsultLevelAndGradeScholarInDTO beanConsultLevelAndGradeIn, HttpServletRequest request) {log.info("Inside consultLevelGradeSchoolarArmed");
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		InitialConsultLevelGradeScholarServiceImpl initialConsultLevelGradeScholarImpl=null;
		HttpHeaders headers=null;
		ErrorDTO errorDTO=null;
		MessageErrorDTO messageErrorDTO=null;
		try{
			context=SingletonApplicationContext.getInstance();
			headers = (HttpHeaders) context.getBean("httpHeaders");
			initialConsultLevelGradeScholarImpl = (InitialConsultLevelGradeScholarServiceImpl) context.getBean("consultLevGradSchoServiceCli");
			log.info("After Autoinstance - consultLevelGradeSchoolarArmed");
			headers.setContentType(MediaType.APPLICATION_JSON);		
			headers.set("tsec", request.getSession().getAttribute("tsec").toString());
			log.info("headers-consultLevelGradeSchoolarArmed = "+headers);
			response = initialConsultLevelGradeScholarImpl.consultLevelAndGradeScholar(beanConsultLevelAndGradeIn, headers);
			if(response.getStatusCode().value() != 200){
				log.info("Error consult - consultLevelGradeSchoolarArmed ");
				messageErrorDTO =(MessageErrorDTO)response.getBody();

				if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
					request.getSession().setAttribute("tsec", null);
					response = this.consultLevelGradeSchoolarArmed(beanConsultLevelAndGradeIn,request);
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
			initialConsultLevelGradeScholarImpl=null;
			context=null;
			headers=null;
			errorDTO=null;
			messageErrorDTO=null;
		}	
		return response;		
	}

}
