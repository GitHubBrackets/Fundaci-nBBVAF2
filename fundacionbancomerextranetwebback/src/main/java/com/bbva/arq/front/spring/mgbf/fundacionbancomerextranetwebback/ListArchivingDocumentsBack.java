package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ListArchivingDocumentsInDTO;

/**
 * Interface ListArchivingDocumentsBack. 
 * Contains listArchivingDocumentsArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ListArchivingDocumentsBack{

 	/**
    *
    * Method listArchivingDocumentsArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param ListArchivingDocumentsInDTO beanListArchivingDocumentsIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> listArchivingDocumentsArmed( ListArchivingDocumentsInDTO beanListArchivingDocumentsIn, HttpServletRequest request);

}
