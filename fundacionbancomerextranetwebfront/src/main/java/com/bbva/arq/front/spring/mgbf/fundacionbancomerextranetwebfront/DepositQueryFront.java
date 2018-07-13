package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Interface DepositQueryFront. 
 * Contains getDepositQuery method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface DepositQueryFront {
	
 	/**
    *
    * Method getDepositQuery
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> getDepositQuery(@RequestBody String json,  HttpServletRequest request);
}
