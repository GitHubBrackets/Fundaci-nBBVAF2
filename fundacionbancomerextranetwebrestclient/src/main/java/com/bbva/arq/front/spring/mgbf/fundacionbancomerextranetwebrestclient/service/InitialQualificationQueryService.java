package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.QualificationsQueryInDTO;

/**
 * Interface InitialQualificationQueryService. 
 * Contains qualificationQuery method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialQualificationQueryService {
	
 	/**
    *
    * Method qualificationQuery
    * @return one HttpEntity<?> value as parameter.
    *
    * @param QualificationsQueryInDTO beanQualificationsQueryInDTO
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> qualificationQuery(QualificationsQueryInDTO beanQualificationsQueryInDTO,  HttpHeaders headers);

}
