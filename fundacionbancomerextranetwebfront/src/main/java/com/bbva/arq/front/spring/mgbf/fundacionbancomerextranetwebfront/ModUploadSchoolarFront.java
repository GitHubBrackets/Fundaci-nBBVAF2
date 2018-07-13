package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Interface ModUploadSchoolarFront. 
 * Contains getModUploadSchoolar method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ModUploadSchoolarFront {
	
 	/**
    *
    * Method getModUploadSchoolar
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> getModUploadSchoolar(@RequestBody String json,  HttpServletRequest request);

}
