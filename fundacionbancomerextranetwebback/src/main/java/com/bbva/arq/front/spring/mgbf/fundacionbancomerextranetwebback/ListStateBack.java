package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface ListStateBack. 
 * Contains listArchivingDocumentsArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ListStateBack {
	
 	/**
    *
    * Method listArchivingDocumentsArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> listArchivingDocumentsArmed( HttpServletRequest request);

}
