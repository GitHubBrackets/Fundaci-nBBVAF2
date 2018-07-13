package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UpdatePasswordScholarshipUserInDTO;

/**
 * Interface LdapUpdatePasswordScholar. 
 * Contains ldapUpdateArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface LdapUpdatePasswordScholar {
	
 	/**
    *
    * Method ldapUpdateArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * UpdatePasswordScholarshipUserInDTO beanUpdatePasswordScholarshipUserInDTO
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> ldapUpdateArmed(UpdatePasswordScholarshipUserInDTO beanUpdatePasswordScholarshipUserInDTO, HttpServletRequest request);

}
