package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.AlertInDTO;

/**
 * Interface AlertBack. 
 * Contains alertArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */

public interface AlertBack {
	
 	/**
    *
    * Method alertArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param AlertInDTO beanAverageQueryIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> alertArmed(AlertInDTO beanAverageQueryIn, HttpServletRequest request);

}
