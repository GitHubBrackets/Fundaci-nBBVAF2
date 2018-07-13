package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DepositQueryInDTO;

/**
 * Interface DepositQueryBack. 
 * Contains depositQueryArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface DepositQueryBack {
	
 	/**
    *
    * Method depositQueryArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param DepositQueryInDTO beanScholarIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> depositQueryArmed(DepositQueryInDTO beanScholarIn, HttpServletRequest request);
	
}