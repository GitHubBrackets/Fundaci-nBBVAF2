package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface ArchivingDocumentsFront. 
 * Contains the methods (listArchivingDocuments - sendArchivingDocuments - sendArchivingMultiDocuments)
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ArchivingDocumentsFront {
	
 	/**
    *
    * Method listArchivingDocuments
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> listArchivingDocuments(String json,  HttpServletRequest request);
	
 	/**
    *
    * Method sendArchivingDocuments
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> sendArchivingDocuments(String json,  HttpServletRequest request);
	
 	/**
    *
    * Method sendArchivingMultiDocuments
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> sendArchivingMultiDocuments(String json,  HttpServletRequest request);
	

	
}
