package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface ListMunicipalityBack. 
 * Contains listMunicipalityArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ListMunicipalityBack {
	
 	/**
    *
    * Method listMunicipalityArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param (int state
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> listMunicipalityArmed(int state, HttpServletRequest request);

}
