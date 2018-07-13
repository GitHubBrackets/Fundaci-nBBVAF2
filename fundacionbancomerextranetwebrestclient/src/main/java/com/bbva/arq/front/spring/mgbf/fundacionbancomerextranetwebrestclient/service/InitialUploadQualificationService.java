package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UploadQualificationsInDTO;

/**
 * Interface InitialUploadQualificationService. 
 * Contains uploadQualification method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialUploadQualificationService {
	
 	/**
    *
    * Method uploadQualification
    * @return one HttpEntity<?> value as parameter.
    *
    * @param UploadQualificationsInDTO beanUploadQualificationnIn
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> uploadQualification(UploadQualificationsInDTO beanUploadQualificationnIn,  HttpHeaders headers);

}
