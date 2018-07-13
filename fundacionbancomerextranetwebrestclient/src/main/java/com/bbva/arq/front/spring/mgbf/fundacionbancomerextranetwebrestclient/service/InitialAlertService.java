package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.AlertInDTO;

/**
 * Interface InitialAlertService. 
 * Contains alertClient method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialAlertService {

 	/**
    *
    * Method restServiceConsume
    * @return one HttpEntity<?> value as parameter.
    *
    * @param AlertInDTO valor
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> alertClient(AlertInDTO valor, HttpHeaders headers);
	
}
