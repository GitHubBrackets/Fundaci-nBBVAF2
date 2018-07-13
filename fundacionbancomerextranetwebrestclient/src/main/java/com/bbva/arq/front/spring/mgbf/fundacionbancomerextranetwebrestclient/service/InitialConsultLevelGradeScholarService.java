package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ConsultLevelAndGradeScholarInDTO;

/**
 * Interface InitialConsultLevelGradeScholar. 
 * Contains consultLevelAndGradeScholar method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */

public interface InitialConsultLevelGradeScholarService {
	
 	/**
    *
    * Method consultLevelAndGradeScholar
    * @return one HttpEntity<?> value as parameter.
    *
    * @param ConsultLevelAndGradeScholarInDTO beanConsultLevelAndGradeScholarIn
    * @param HttpHeaders headers
	*
    */
	public ResponseEntity<?> consultLevelAndGradeScholar(ConsultLevelAndGradeScholarInDTO beanConsultLevelAndGradeScholarIn,  HttpHeaders headers);

}
