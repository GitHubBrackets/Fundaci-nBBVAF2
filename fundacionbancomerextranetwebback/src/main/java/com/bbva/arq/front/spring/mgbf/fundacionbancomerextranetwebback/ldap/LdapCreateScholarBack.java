package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.CreateScholarshipUserInDTO;

/**
 * Interface LdapCreateScholar. 
 * Contains ldapCreateArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface LdapCreateScholarBack {
	
 	/**
    *
    * Method ldapCreateArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param CreateScholarshipUserInDTO beanCreateScholarshipUserInDTO
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> ldapCreateArmed(CreateScholarshipUserInDTO beanCreateScholarshipUserInDTO, HttpServletRequest request);

}
