package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DetailScholarInDTO;

/**
 * Interface InitialDetailScholarService. 
 * Contains detailScholarClient method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialDetailScholarService {
	
 	/**
    *
    * Method detailScholarClient
    * @return one HttpEntity<?> value as parameter.
    *
    * @param DetailScholarInDTO beanDetailScholarIn
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> detailScholarClient(DetailScholarInDTO beanDetailScholarIn,  HttpHeaders headers);

}
