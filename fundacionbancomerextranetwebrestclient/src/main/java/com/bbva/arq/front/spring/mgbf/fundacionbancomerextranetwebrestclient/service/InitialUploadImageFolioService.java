package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UploadImageFolioInDTO;

/**
 * Interface InitialUploadImageFolioService. 
 * Contains uploadImageClient method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialUploadImageFolioService {
	
 	/**
    *
    * Method uploadImageClient
    * @return one HttpEntity<?> value as parameter.
    *
    * @param UploadImageFolioInDTO beanUploadImageFolioIn
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> uploadImageClient(UploadImageFolioInDTO beanUploadImageFolioIn,  HttpHeaders headers);

}
