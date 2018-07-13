package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront;

import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;
/**
 * Interface ApplicationCatalogos. 
 * Contains getApCatalogos method.
 * 
 * @author Diego Espinoza
 * @version 12 July 2018
 */
public interface ApplicationCatalogsFront {

    
    /**
    *
    * Method getApCatalogos
    * @return ResponseEntity<?> value as parameter.
    *
    * @param HttpServletRequest request
    *
    */
    ResponseEntity<?> getApCatalogos( HttpServletRequest request);
}
