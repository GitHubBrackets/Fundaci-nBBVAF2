package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.SendArchivingDocumentsInDTO;

/**
 * Interface InitialSendArchivingDocumentsService. 
 * Contains sendArchivingDocumentsClient method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialSendArchivingDocumentsService {
	
 	/**
    *
    * Method sendArchivingDocumentsClient
    * @return one HttpEntity<?> value as parameter.
    *
    * @param SendArchivingDocumentsInDTO beanSendArchivingDocumentsInDTO
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> sendArchivingDocumentsClient(SendArchivingDocumentsInDTO beanSendArchivingDocumentsInDTO,  HttpHeaders headers);

}
