package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ConsultParametersInDTO;

/**
 * Interface ConsultParametersBack. 
 * Contains consultParametersArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ConsultParametersBack {
	
 	/**
    *
    * Method consultParametersArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param ConsultParametersInDTO beanConsultParametersIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> consultParametersArmed(ConsultParametersInDTO beanConsultParametersIn, HttpServletRequest request);

}
