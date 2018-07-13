package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.AveragesQueryInDTO;

/**
 * Interface InitialAverageQueryService. 
 * Contains averageQueryClient method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialAverageQueryService {
	
 	/**
    *
    * Method averageQueryClient
    * @return one HttpEntity<?> value as parameter.
    *
    * @param AveragesQueryInDTO beanAverageQueryIn
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> averageQueryClient(AveragesQueryInDTO beanAverageQueryIn,  HttpHeaders headers);

}
