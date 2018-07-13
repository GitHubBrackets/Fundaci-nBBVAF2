package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ListArchivingDocumentsInDTO;

/**
 * Interface InitialListArchivingDocumentsService. 
 * Contains listArchivingDocumentsClient method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialListArchivingDocumentsService {
	
 	/**
    *
    * Method listArchivingDocumentsClient
    * @return one HttpEntity<?> value as parameter.
    *
    * @param ListArchivingDocumentsInDTO beanListArchivingDocumentsIn
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> listArchivingDocumentsClient(ListArchivingDocumentsInDTO beanListArchivingDocumentsIn,  HttpHeaders headers);

}
