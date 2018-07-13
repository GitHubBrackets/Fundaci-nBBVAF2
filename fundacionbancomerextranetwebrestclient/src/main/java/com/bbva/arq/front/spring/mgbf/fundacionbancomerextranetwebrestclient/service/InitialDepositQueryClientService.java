package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DepositQueryInDTO;

/**
 * Interface InitialDepositQueryClientService. 
 * Contains depositQuery method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialDepositQueryClientService {
	
 	/**
    *
    * Method depositQuery
    * @return one HttpEntity<?> value as parameter.
    *
    * @param DepositQueryInDTO beanScholarIn
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> depositQuery(DepositQueryInDTO beanScholarIn, HttpHeaders headers);
}
