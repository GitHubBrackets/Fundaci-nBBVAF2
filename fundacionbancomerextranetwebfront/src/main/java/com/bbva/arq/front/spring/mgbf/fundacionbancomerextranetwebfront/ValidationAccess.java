package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.http.ResponseEntity;

/**
 * Interface ValidationAccess. 
 * Contains validatePermissions method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ValidationAccess {
	
 	/**
    *
    * Method validatePermissions
    * @return ResponseEntity<?> value as parameter.
    *
    * @param ProceedingJoinPoint  pjp
	*
    */
	public ResponseEntity<?> validatePermissions(ProceedingJoinPoint  pjp)throws Throwable;

}
