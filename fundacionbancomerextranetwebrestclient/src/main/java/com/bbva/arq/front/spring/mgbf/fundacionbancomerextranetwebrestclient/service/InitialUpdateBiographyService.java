package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UpdateBiographyInDTO;


/**
 * Interface InitialUpdateBiographyService. 
 * Contains updateBiography method.
 * 
 * @author Diego Espinoza
 * @version 23 july 2018
 */
public interface InitialUpdateBiographyService {
     
    /**
    *
    * Method updateBiography
    * @return one HttpEntity<?> value as parameter.
    *
    * @param UpdateBiographyInDTO valor
    * @param HttpHeaders headers
    *
    */
    public ResponseEntity<?> updateBiography(UpdateBiographyInDTO valor, String scholarID, HttpHeaders headers);
    

}
