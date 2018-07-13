package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ValidationscholarInDTO;

/**
 * Interface ValidationScholarBack. 
 * Contains validationScholarArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ValidationScholarBack {
	
 	/**
    *
    * Method validationScholarArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param ValidationscholarInDTO beanScholarIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> validationScholarArmed(ValidationscholarInDTO beanScholarIn, HttpServletRequest request);

}
