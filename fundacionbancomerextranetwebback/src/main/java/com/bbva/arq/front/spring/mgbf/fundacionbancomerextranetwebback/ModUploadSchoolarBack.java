package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ModUploadDataScholarInDTO;

/**
 * Interface ModUploadSchoolarBack. 
 * Contains modUploadSchoolarArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ModUploadSchoolarBack {
	
 	/**
    *
    * Method modUploadSchoolarArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param ModUploadDataScholarInDTO beanModUploadDataSchoolarIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> modUploadSchoolarArmed(ModUploadDataScholarInDTO beanModUploadDataSchoolarIn, HttpServletRequest request);

}
