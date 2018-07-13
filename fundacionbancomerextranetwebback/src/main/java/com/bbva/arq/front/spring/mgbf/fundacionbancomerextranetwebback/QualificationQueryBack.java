package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.QualificationsQueryInDTO;

/**
 * Interface QualificationQueryBack. 
 * Contains qualificationsQueryInDTOArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface QualificationQueryBack {
	
 	/**
    *
    * Method qualificationsQueryInDTOArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param QualificationsQueryInDTO beanQualificationsQueryIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> qualificationsQueryInDTOArmed(QualificationsQueryInDTO beanQualificationsQueryIn, HttpServletRequest request);

}
