package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UpdatePasswordScholarshipUserInDTO;

/**
 * Interface InitialLdapUpdateScholar. 
 * Contains ldapUpdateScholar method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialLdapUpdateScholarService {
	
 	/**
    *
    * Method ldapUpdateScholar
    * @return one HttpEntity<?> value as parameter.
    *
    * @param UpdatePasswordScholarshipUserInDTO beanUpdatePasswordScholarshipUserInDTO
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> ldapUpdateScholar(UpdatePasswordScholarshipUserInDTO beanUpdatePasswordScholarshipUserInDTO,  HttpHeaders headers);
}
