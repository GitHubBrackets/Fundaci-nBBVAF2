package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface AverageQueryFront. 
 * Contains getAverageQuery method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface AverageQueryFront {
	
 	/**
    *
    * Method getAverageQuery
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> getAverageQuery(String json,  HttpServletRequest request);

}
