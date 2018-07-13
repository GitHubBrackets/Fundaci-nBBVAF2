package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ValidationscholarInDTO;

/**
 * Interface InitialValidationScholarClientService. 
 * Contains restServiceConsume method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialValidationScholarClientService {
	
 	/**
    *
    * Method restServiceConsume
    * @return one HttpEntity<?> value as parameter.
    *
    * @param ValidationscholarInDTO beanScholarIn
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> validationScholar(ValidationscholarInDTO beanScholarIn, HttpHeaders headers);

}
