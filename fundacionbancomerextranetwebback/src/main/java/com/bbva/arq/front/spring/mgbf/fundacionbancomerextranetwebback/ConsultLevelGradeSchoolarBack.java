package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ConsultLevelAndGradeScholarInDTO;

/**
 * Interface ConsultLevelGradeSchoolarBack. 
 * Contains consultLevelGradeSchoolarArmed method.
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface ConsultLevelGradeSchoolarBack {
	
 	/**
    *
    * Method consultLevelGradeSchoolarArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param ConsultLevelAndGradeScholarInDTO beanConsultLevelAndGradeIn
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> consultLevelGradeSchoolarArmed(ConsultLevelAndGradeScholarInDTO beanConsultLevelAndGradeIn, HttpServletRequest request);

}
