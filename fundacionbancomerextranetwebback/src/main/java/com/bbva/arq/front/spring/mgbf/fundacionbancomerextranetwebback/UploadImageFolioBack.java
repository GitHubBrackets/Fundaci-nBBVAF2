package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UploadImageFolioInDTO;

/**
 * Interface UploadImageFolioBack. 
 * Contains uploadImageFolioArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface UploadImageFolioBack {
	
 	/**
    *
    * Method uploadImageFolioArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param UploadImageFolioInDTO beanUploadImageFolioIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> uploadImageFolioArmed(UploadImageFolioInDTO beanUploadImageFolioIn, HttpServletRequest request);

}
