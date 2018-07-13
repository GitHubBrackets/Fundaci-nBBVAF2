package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.session;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface TerminateSession. 
 * Contains the method expireSession
 * 
 * @author Diego Espinoza
 * @version 05 december 2017
 */
public interface TerminateSessionFront {
	
	/**
    *
    * Method expireSession
    * @return ResponseEntity<?> value as parameter.
	*
    */
	public ResponseEntity<?> expireSession(HttpServletRequest request);
	
}
