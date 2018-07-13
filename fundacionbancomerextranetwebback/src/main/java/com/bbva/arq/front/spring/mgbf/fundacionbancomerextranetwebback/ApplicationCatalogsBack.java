package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface ApplicationCatalogsBack. 
 * Contains catalogsArmed method.
 * 
 * @author Diego Espinoza
 * @version 12 July 2018
 */
public interface ApplicationCatalogsBack {
    
    /**
    *
    * Method catalogsArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param HttpServletRequest request
    *
    */
    ResponseEntity<?> catalogsArmed( HttpServletRequest request);

}
