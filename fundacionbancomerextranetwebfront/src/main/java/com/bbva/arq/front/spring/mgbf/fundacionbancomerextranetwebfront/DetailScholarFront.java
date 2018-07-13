package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface DetailScholarFront. 
 * Contains getDetailScholar method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface DetailScholarFront {
	
 	/**
    *
    * Method getDetailScholar
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> getDetailScholar(String json,  HttpServletRequest request);


}
