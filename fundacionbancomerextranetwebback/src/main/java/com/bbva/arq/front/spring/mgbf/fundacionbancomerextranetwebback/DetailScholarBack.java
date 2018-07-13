package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DetailScholarInDTO;

/**
 * Interface DetailScholarBack. 
 * Contains detailScholarArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface DetailScholarBack {
	
 	/**
    *
    * Method detailScholarArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param DetailScholarInDTO beanDetailScholarIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> detailScholarArmed(DetailScholarInDTO beanDetailScholarIn, HttpServletRequest request);

}
