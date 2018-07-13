package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.PropertyDTO;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class ErrorMetaInfoDTO
 * Contains the input values for the Errors
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class ErrorMetaInfoDTO {
	
	private List<PropertyDTO> property;

    /**      
    *
    * Method getProperty.
    * Contains the get parameter for the service
    * @return PropertyDTO Object as parameter.
    *
    */
    public List<PropertyDTO> getProperty() {
        return property;
    }

    /**      
    *
    * Method setProperty.
    * Contains the set parameter for the service
    * 
    * @param PropertyDTO property
    * 
    */
    public void setProperty(List<PropertyDTO> property) {
        this.property = property;
    }


    


   
	
}
