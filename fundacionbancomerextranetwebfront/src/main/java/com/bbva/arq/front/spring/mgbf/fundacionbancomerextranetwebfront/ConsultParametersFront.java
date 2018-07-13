package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface ConsultParametersFront. 
 * Contains listArchivingDocuments method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ConsultParametersFront {

 	/**
    *
    * Method listArchivingDocuments
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> listArchivingDocuments(String json,  HttpServletRequest request);
	
}
