package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ConsultParametersInDTO;

/**
 * Interface InitialConsultParametersService. 
 * Contains consultParameters method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialConsultParametersService {
	
 	/**
    *
    * Method consultParameters
    * @return one HttpEntity<?> value as parameter.
    *
    * @param ConsultParametersInDTO beanConsultParametersInDTOIn
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> consultParameters(ConsultParametersInDTO beanConsultParametersInDTOIn,  HttpHeaders headers);

}
