package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.GetStatusScholarshipUserInDTO;

/**
 * Interface LdapGetStatusScholar. 
 * Contains ldapGetStatusArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface LdapGetStatusScholarBack {
	
 	/**
    *
    * Method ldapGetStatusArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param GetStatusScholarshipUserInDTO beanGetStatusScholarshipUserInDTO
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> ldapGetStatusArmed(GetStatusScholarshipUserInDTO beanGetStatusScholarshipUserInDTO, HttpServletRequest request);

}
