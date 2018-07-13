package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.DetailScholarBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DetailScholarInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialDetailScholarServiceImpl;

/**
 * Class DetailScholarBackImpl implements the DetailScholarBack interface
 * Contains the implementations of the method detailScholarArmed to consume the service MGBFTB03
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public class DetailScholarBackImpl implements DetailScholarBack{
	private static final Logger log = Logger.getLogger(DetailScholarBackImpl.class);
	private boolean gtCad = false;
	
  	/**      
    *
    * Method detailScholarArmed.
    * Contains the parameters for get the URL for the service MGBFTB03
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param DetailScholarInDTO beanDetailScholarIn
    * @param HttpServletRequest request
	*
    */
	@Override
	public ResponseEntity<?> detailScholarArmed( DetailScholarInDTO beanDetailScholarIn, HttpServletRequest request) {log.info("Inside detailScholarArmed");
		ResponseEntity<?> response=null;
			InitialDetailScholarServiceImpl initialDetailScholarServiceImpl=null;
			HttpHeaders headers=null;
			ErrorDTO errorDTO=null;
			MessageErrorDTO messageErrorDTO=null;
			ClassPathXmlApplicationContext context=null;	
			try{
				context=SingletonApplicationContext.getInstance();
				headers = (HttpHeaders) context.getBean("httpHeaders");
				initialDetailScholarServiceImpl = (InitialDetailScholarServiceImpl) context.getBean("detailSchoServiceCli");
				log.info("After Autoinstance - detailScholarArmed");
				headers.setContentType(MediaType.APPLICATION_JSON);					
				headers.set("tsec", request.getSession().getAttribute("tsec").toString());	
				log.info("headers-detailScholarArmed = "+headers);
				response = initialDetailScholarServiceImpl.detailScholarClient(beanDetailScholarIn, headers);
				if(response.getStatusCode().value() != 200){
					log.info("Error consult - detailScholarArmed ");
					messageErrorDTO =(MessageErrorDTO)response.getBody();

					if(messageErrorDTO.getErrorcode().equals("68")){log.info("TSEC is timed out");
						request.getSession().setAttribute("tsec", null);
						response = this.detailScholarArmed(beanDetailScholarIn,request);
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
				initialDetailScholarServiceImpl=null;
				headers=null;
				errorDTO=null;
				messageErrorDTO=null;
			}
				
		return response;
		
	}
	


}
