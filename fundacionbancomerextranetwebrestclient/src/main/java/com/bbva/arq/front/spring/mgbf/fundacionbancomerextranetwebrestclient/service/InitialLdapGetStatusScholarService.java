package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.GetStatusScholarshipUserInDTO;

/**
 * Interface InitialLdapGetStatusScholar. 
 * Contains ldapGetStatusScholar method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialLdapGetStatusScholarService {
	
 	/**
    *
    * Method ldapGetStatusScholar
    * @return one HttpEntity<?> value as parameter.
    *
    * @param GetStatusScholarshipUserInDTO beanGetStatusScholarshipUserInDTO
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> ldapGetStatusScholar(GetStatusScholarshipUserInDTO beanGetStatusScholarshipUserInDTO,  HttpHeaders headers);

}
