package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface ListStateFront. 
 * Contains getListState method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ListStateFront {

 	/**
    *
    * Method getListState
    * @return ResponseEntity<?> value as parameter.
    *
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> getListState( HttpServletRequest request);
}
