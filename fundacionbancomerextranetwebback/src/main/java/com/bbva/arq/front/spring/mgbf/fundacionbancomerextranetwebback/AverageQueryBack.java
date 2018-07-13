package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.AveragesQueryInDTO;

/**
 * Interface AverageQueryBack. 
 * Contains averageQueryArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface AverageQueryBack {
	
 	/**
    *
    * Method averageQueryArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param AveragesQueryInDTO beanAverageQueryIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> averageQueryArmed(AveragesQueryInDTO beanAverageQueryIn, HttpServletRequest request);

}
