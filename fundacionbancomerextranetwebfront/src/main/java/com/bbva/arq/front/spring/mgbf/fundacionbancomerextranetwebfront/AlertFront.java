package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface AlertFront. 
 * Contains alerts method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface AlertFront {
	
 	/**
    *
    * Method alerts
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> alerts(String json,  HttpServletRequest request);

}
