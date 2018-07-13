package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ModUploadDataScholarInDTO;

/**
 * Interface InitialModUploadScholarClientService. 
 * Contains modUploadScholar method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialModUploadScholarClientService {
	
 	/**
    *
    * Method modUploadScholar
    * @return one HttpEntity<?> value as parameter.
    *
    * @param ModUploadDataScholarInDTO beanModUploadDataScholarIn
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> modUploadScholar(ModUploadDataScholarInDTO beanModUploadDataScholarIn,  HttpHeaders headers);

}
