package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DepositModificationInDTO;

/**
 * Interface InitialDepositModificationClientService. 
 * Contains depositModification method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialDepositModificationService {
	
 	/**
    *
    * Method depositModification
    * @return one HttpEntity<?> value as parameter.
    *
    * @param DepositModificationInDTO beanDepositModificationIn
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> depositModification(DepositModificationInDTO beanDepositModificationIn, HttpHeaders headers);
}
