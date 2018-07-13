package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface AlertBack. 
 * Contains getUploadImage method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface UploadImageFolioFront {
	
 	/**
    *
    * Method getUploadImage
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> getUploadImage(String json,  HttpServletRequest request);

}
