package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

/**
 * Interface InitialListStateService. 
 * Contains listState method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialListStateService {
	
 	/**
    *
    * Method listState
    * @return one HttpEntity<?> value as parameter.
    *
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> listState( HttpHeaders headers);
	
}
