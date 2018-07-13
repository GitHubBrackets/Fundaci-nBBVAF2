package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.CreateScholarshipUserInDTO;

/**
 * Interface InitialLdapCreateScholar. 
 * Contains ldapCreateScholar method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialLdapCreateScholarService {
	
 	/**
    *
    * Method ldapCreateScholar
    * @return one HttpEntity<?> value as parameter.
    *
    * @param CreateScholarshipUserInDTO beanCreateScholarshipUserInDTO
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> ldapCreateScholar(CreateScholarshipUserInDTO beanCreateScholarshipUserInDTO,  HttpHeaders headers);

}
