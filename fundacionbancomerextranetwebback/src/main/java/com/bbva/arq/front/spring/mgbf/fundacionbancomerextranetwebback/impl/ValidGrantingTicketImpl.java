package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ValidGrantingTicket;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialClientGrantingTicketServiceImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialNoClientGrantingTicketServiceImpl;

/**
 * Class ValidGrantingTicketImpl implements the ValidGrantingTicket interface
 * Contains the implementations of the methods (getGrantingTicketNoClient - getGrantingTicketClient).
 * This class inplement APO for valid the GrantingTicket expired
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@Aspect
public class ValidGrantingTicketImpl implements ValidGrantingTicket {
	private static final Logger log = Logger.getLogger(ValidGrantingTicketImpl.class);

	
  	/**      
    *
    * Method getGrantingTicketNoClient.
    * contains validations on the GrantingTicket App75, validates if it is expired.
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service GrantingTicket.
    *
    * @param ProceedingJoinPoint pjp
    * @param HttpServletRequest request
	*
    */
	@Pointcut("execution(* com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.impl.*.*(..))")
	public void executeAftergetGTNoClient(){}

	@Autowired
	@Around("executeAftergetGTNoClient()")
	public ResponseEntity<?> getGrantingTicketNoClient(ProceedingJoinPoint pjp){log.info("Inside getGrantingTicketNoClient");
		ResponseEntity<?> response=null;
		ResponseEntity<?> responseGT=null;
		ClassPathXmlApplicationContext context = null;
		InitialNoClientGrantingTicketServiceImpl initialNoClientGrantingTicketServiceImpl = null;
		ResponseEntity<?> resultGrantingTicket = null;
		String tsec = null;
		ErrorDTO errorDTO = null;
		MessageErrorDTO messageErrorDTO=null;
		try{
			context=SingletonApplicationContext.getInstance();
			ServletRequestAttributes request = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			log.info("TSEC = "+request.getRequest().getSession().getAttribute("tsec"));
			if(request.getRequest().getSession().getAttribute("tsec") == null){log.info("TSECis null ValidGT");			
				log.info("Consult GT NO-CLIENTE");
				initialNoClientGrantingTicketServiceImpl = (InitialNoClientGrantingTicketServiceImpl) context.getBean("GrantingTicketServiceNoClient");
				response = resultGrantingTicket = initialNoClientGrantingTicketServiceImpl.consultGrantingTicketNoClient();
				log.info("After resultGrantingTicketNoClient");
				if(resultGrantingTicket.getStatusCode().value() == 200){
					tsec = resultGrantingTicket.getHeaders().getFirst("tsec");
					request.getRequest().getSession().setAttribute("tsec", tsec);
					log.info("Changue TSEC No-Client... To: "+tsec);
				}else{
					log.info("Error En GT NO-CLIENT");
					messageErrorDTO =(MessageErrorDTO)response.getBody();
					errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
					errorDTO.setHttpStatusCode(String.valueOf(response.getStatusCode().value()));
					errorDTO.setCode(messageErrorDTO.getErrorcode());
					errorDTO.setMessage("Error, "+messageErrorDTO.getErrormessage());
					responseGT = new ResponseEntity<ErrorDTO>(errorDTO, response.getStatusCode());
				}	
			}else{
				request.getRequest().getSession().setAttribute("tsec", null);
				this.getGrantingTicketClient(pjp);
			}
			
			log.info("value of tsec-NoClient = "+tsec);
			
			
			if(responseGT==null){
				response = (ResponseEntity<?>) pjp.proceed();
			}else{
				response = responseGT;
			}
			
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}catch(Throwable e){
			throw new FundacionBancomerExceptionHandler(e);
		}finally{
			initialNoClientGrantingTicketServiceImpl=null;
			resultGrantingTicket=null;
			tsec=null;
			errorDTO=null;
			context = null;
		} 
		return response;
	}
	
	
  	/**      
    *
    * Method getGrantingTicketClient.
    * contains validations on the GrantingTicket App75, validates if it is expired.
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service GrantingTicket.
    *
    * @param ProceedingJoinPoint pjp
    * @param HttpServletRequest request
	*
    */
	@Pointcut("execution(* com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.*.*(..))")
	public void executeAftergetGTClient(){}

	@Autowired
	@Around("executeAftergetGTClient()")
	public ResponseEntity<?> getGrantingTicketClient(ProceedingJoinPoint pjp){log.info("Inside getGrantingTicketClient");
		ResponseEntity<?> response=null;
		ResponseEntity<?> responseGT=null;
		ClassPathXmlApplicationContext context = null;
		InitialClientGrantingTicketServiceImpl initialClientGrantingTicketServiceImpl = null;
		ResponseEntity<?> resultGrantingTicket = null;
		String tsec = null;
		ErrorDTO errorDTO = null;
		MessageErrorDTO messageErrorDTO=null;
		try{
			context=SingletonApplicationContext.getInstance();
			ServletRequestAttributes request = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			log.info("TSEC CLIENT = "+request.getRequest().getSession().getAttribute("tsec"));

			if(request.getRequest().getSession().getAttribute("tsec") == null){log.info("TSECis null ValidGT");
						log.info("Consult GT CLIENT");
						initialClientGrantingTicketServiceImpl = (InitialClientGrantingTicketServiceImpl) context.getBean("GrantingTicketServiceClient");
						response = resultGrantingTicket = initialClientGrantingTicketServiceImpl.consultGrantingTicketClient();
						log.info("After resultGrantingTicketClient");
						if(resultGrantingTicket.getStatusCode().value() == 200){
							tsec = resultGrantingTicket.getHeaders().getFirst("tsec");
							request.getRequest().getSession().setAttribute("tsec", tsec);
							log.info("Changue TSEC Client... To: "+tsec);
						}else{
							log.info("Error En GT CLIENT");
							messageErrorDTO =(MessageErrorDTO)response.getBody();
							errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
							errorDTO.setHttpStatusCode(String.valueOf(response.getStatusCode().value()));
							errorDTO.setCode(messageErrorDTO.getErrorcode());
							errorDTO.setMessage("Error, "+messageErrorDTO.getErrormessage());
							responseGT = new ResponseEntity<ErrorDTO>(errorDTO, response.getStatusCode());
						}
			}
			log.info("value of tsec-Client = "+tsec);
			if(responseGT==null){
				response = (ResponseEntity<?>) pjp.proceed();
			}else{
				response = responseGT;
			}
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}catch(Throwable e){
			throw new FundacionBancomerExceptionHandler(e);
		}finally{
			context.close();
			initialClientGrantingTicketServiceImpl=null;
			resultGrantingTicket=null;
			tsec=null;
			errorDTO=null;
			context = null;
		} 		
		return response;
	}

}
