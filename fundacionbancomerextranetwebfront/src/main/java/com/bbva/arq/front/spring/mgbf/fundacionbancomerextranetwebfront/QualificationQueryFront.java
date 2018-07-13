package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Interface AlertBack. 
 * Contains getQualificationQuery method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface QualificationQueryFront {
	
 	/**
    *
    * Method getQualificationQuery
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> getQualificationQuery(@RequestBody String json,  HttpServletRequest request);

}
