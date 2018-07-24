package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface UpdateBiographyFront. 
 * Contains alerts method.
 * 
 * @author Diego Espinoza
 * @version 23 july 2018
 */
public interface UpdateBiographyFront {
    
    /**
    *
    * Method updateBiography
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
    *
    */
    public ResponseEntity<?> updateBiography(String json, String valor, HttpServletRequest request);

}
