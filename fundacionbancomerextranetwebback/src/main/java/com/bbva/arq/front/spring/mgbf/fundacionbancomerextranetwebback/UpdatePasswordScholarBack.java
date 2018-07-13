package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UpdatePasswordScholarshipUserInDTO;

/**
 * Interface UpdatePasswordScholarBack. 
 * Contains updateArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface UpdatePasswordScholarBack {
	
 	/**
    *
    * Method updateArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param UpdatePasswordScholarshipUserInDTO beanUpdatePasswordScholarshipUserInDTO
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> updateArmed(UpdatePasswordScholarshipUserInDTO beanUpdatePasswordScholarshipUserInDTO, HttpServletRequest request);

}
