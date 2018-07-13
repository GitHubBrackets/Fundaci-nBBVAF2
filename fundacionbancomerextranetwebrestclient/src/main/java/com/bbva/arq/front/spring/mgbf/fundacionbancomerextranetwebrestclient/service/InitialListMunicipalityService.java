package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

/**
 * Interface InitialListMunicipalityService. 
 * Contains listMunicipalityClient method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialListMunicipalityService {
	
 	/**
    *
    * Method listMunicipalityClient
    * @return one HttpEntity<?> value as parameter.
    *
    * @param int state
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> listMunicipalityClient(int state, HttpHeaders headers);

}
