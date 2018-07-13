package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interface ListMunicipalityFront. 
 * Contains getListMunicipality method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ListMunicipalityFront {
	
 	/**
    *
    * Method getListMunicipality
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String id
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> getListMunicipality(@RequestParam ("id") String id, HttpServletRequest request);

}
