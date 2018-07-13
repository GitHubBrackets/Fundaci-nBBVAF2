package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface UpdatePassword. 
 * Contains getUploadImage method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface UpdatePasswordFront {

 	/**
    *
    * Method getUploadImage
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> updatePassword(String json,  HttpServletRequest request);
	
}
