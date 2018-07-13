package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.RequestReactivationaScholarshipUserInDTO;

/**
 * Interface LdapReactivationScholar. 
 * Contains ldapReactivationArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface LdapReactivationScholarBack {
	
 	/**
    *
    * Method ldapReactivationArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param RequestReactivationaScholarshipUserInDTO beanRequestReactivationaScholarshipUserInDTO
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> ldapReactivationArmed(RequestReactivationaScholarshipUserInDTO beanRequestReactivationaScholarshipUserInDTO, HttpServletRequest request);

}
