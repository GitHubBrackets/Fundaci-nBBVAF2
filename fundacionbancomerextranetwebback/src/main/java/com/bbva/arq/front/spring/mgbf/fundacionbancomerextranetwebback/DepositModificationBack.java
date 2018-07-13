package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DepositModificationInDTO;

/**
 * Interface DepositModificationBack. 
 * Contains depositModificationArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface DepositModificationBack {
	
 	/**
    *
    * Method depositModificationArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param DepositModificationInDTO beanDepositModificationIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> depositModificationArmed(DepositModificationInDTO beanDepositModificationIn, HttpServletRequest request);
	
}
