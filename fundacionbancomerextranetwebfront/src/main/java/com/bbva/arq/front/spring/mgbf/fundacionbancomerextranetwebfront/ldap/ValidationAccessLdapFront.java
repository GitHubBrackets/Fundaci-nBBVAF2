package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ldap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.http.ResponseEntity;

/**
 * Interface ValidationAccessLdap. 
 * Contains validatePermissionsLdap method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ValidationAccessLdapFront {
	
 	/**
    *
    * Method validatePermissionsLdap
    * @return ResponseEntity<?> value as parameter.
    *
    * @param ProceedingJoinPoint  pjp
	*
    */
	public ResponseEntity<?> validatePermissionsLdap(ProceedingJoinPoint  pjp)throws Throwable;

}
