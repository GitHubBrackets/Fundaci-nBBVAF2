package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UploadQualificationsInDTO;

/**
 * Interface UploadQualificationBack. 
 * Contains uploadQualificationArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface UploadQualificationBack {
	
 	/**
    *
    * Method uploadQualificationArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param UploadQualificationsInDTO beanUpdateQualificationIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> uploadQualificationArmed(UploadQualificationsInDTO beanUpdateQualificationIn, HttpServletRequest request);

}
