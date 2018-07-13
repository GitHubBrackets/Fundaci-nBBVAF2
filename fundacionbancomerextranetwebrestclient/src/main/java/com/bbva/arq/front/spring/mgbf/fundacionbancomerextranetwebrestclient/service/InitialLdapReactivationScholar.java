package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.RequestReactivationaScholarshipUserInDTO;

/**
 * Interface InitialLdapReactivationScholar. 
 * Contains ldapReactivationScholar method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialLdapReactivationScholar {
	
 	/**
    *
    * Method ldapReactivationScholar
    * @return one HttpEntity<?> value as parameter.
    *
    * @param RequestReactivationaScholarshipUserInDTO beanrequestReactivationaScholarshipUserInDTO
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> ldapReactivationScholar(RequestReactivationaScholarshipUserInDTO beanrequestReactivationaScholarshipUserInDTO,  HttpHeaders headers);

}
