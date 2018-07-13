package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.SendArchivingDocumentsInDTO;

/**
 * Interface SendArchivingDocumentsBack. 
 * Contains sendArchivingDocumentsArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface SendArchivingDocumentsBack{

 	/**
    *
    * Method sendArchivingDocumentsArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param SendArchivingDocumentsInDTO beanSendArchivingDocumentsIn
    * @param HttpServletRequest headers
	*
    */
	public ResponseEntity<?> sendArchivingDocumentsArmed( SendArchivingDocumentsInDTO beanSendArchivingDocumentsIn, HttpServletRequest request);

}
