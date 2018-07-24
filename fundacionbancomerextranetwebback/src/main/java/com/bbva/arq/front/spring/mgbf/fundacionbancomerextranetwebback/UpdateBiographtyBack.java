package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UpdateBiographyInDTO;

/**
 * Interface UpdateBiographtyBack. 
 * Contains updateBiographyArmed method.
 * 
 * @author Diego Espinoza
 * @version 23 july 2018
 */
public interface UpdateBiographtyBack {
    
    /**
    *
    * Method updateBiographyArmed
    * @return ResponseEntity<?> value as parameter.
    *
    * @param UpdateBiographyInDTO updateBiographyInDTO
    * @param HttpServletRequest request
    *
    */
    ResponseEntity<?> updateBiographyArmed(UpdateBiographyInDTO beanUpdateBiographyInDTO,String scholarID, HttpServletRequest request);


}
