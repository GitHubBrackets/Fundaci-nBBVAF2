package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

/**
 * Interface InitialApplicationCatalogs. 
 * Contains catalogs method.
 * 
 * @author Diego Espinoza
 * @version 12 July 2018
 */
public interface InitialApplicationCatalogsService {

    
    /**
    *
    * Method catalogs
    * @return one HttpEntity<?> value as parameter.
    *
    * @param HttpHeaders headers
    *
    */
    ResponseEntity<?> catalogs( HttpHeaders headers);
    
}
