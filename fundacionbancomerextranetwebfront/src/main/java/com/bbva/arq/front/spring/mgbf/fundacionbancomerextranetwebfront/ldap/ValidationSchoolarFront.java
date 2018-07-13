package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ldap;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Interface ValidationSchoolarFront. 
 * Contains getValidationScholar method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ValidationSchoolarFront {
	
 	/**
    *
    * Method getValidationScholar
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> getValidationScholar(@RequestBody String json,  HttpServletRequest request);

}
