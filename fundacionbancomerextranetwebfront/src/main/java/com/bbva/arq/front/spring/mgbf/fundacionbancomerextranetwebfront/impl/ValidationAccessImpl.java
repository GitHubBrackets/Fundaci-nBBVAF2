package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.impl;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ValidationAccess;

/**
 * Class AlertFrontImpl implements the AlertFront interface
 * Contains the implementations of the method validatePermissions to consume the services with the App74
 * This class implement APO to validate logged in users.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@Aspect
public class ValidationAccessImpl implements ValidationAccess{
	private static final Logger log = Logger.getLogger(ValidationAccessImpl.class);

  	/**      
    *
    * Method validatePermissions.
    * Contains the parameters for get the URL for the services with the App74
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@Pointcut("execution(* com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.impl.*.*(..))")
	public void executeAroundValidPass(){}

	@Autowired
	@Around("executeAroundValidPass()")
	public ResponseEntity<?> validatePermissions(ProceedingJoinPoint  pjp) {log.info("Inside ValidationAccess");
		ClassPathXmlApplicationContext context = null;
		ErrorDTO errorDTO = null;
		ResponseEntity<?> response=null;
		ResponseEntity<?> responseNoAccess=null;	
		try{
			context=SingletonApplicationContext.getInstance();
			ServletRequestAttributes request = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			log.info("pjp.getSignature().getName() = "+pjp.getSignature().getName());
					 
			log.info("IV-USER validatePermissions = "+request.getRequest().getSession().getAttribute("iv-user"));
			log.info("TSEC validatePermissions = "+request.getRequest().getSession().getAttribute("tsec"));
			if(request.getRequest().getSession().getAttribute("iv-user") == null || 
					request.getRequest().getSession().getAttribute("iv-user").equals("null")  ||
					request.getRequest().getSession().getAttribute("iv-user").toString().toLowerCase().equals("unauthenticated")){
			
						log.info("iv-user without autorizacion");
						errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
						errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.FORBIDDEN));
						errorDTO.setCode(String.valueOf(errorDTO.hashCode()));
						errorDTO.setMessage("No tienes privilegios para accesar");
						responseNoAccess = new ResponseEntity<ErrorDTO>(errorDTO,null,HttpStatus.FORBIDDEN);
	
			}
			if(responseNoAccess==null){
				response = (ResponseEntity<?>) pjp.proceed();
			}else{
				response = responseNoAccess;
			}
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		} catch (Throwable e) {
			throw new FundacionBancomerExceptionHandler(e);
		}finally{
			errorDTO = null;
			context = null;
		}
	
		return response;
	}

}
