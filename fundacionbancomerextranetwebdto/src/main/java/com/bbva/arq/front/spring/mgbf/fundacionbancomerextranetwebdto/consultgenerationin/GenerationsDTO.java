package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.consultgenerationin;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class GenerationsDTO
 * Contains the input values for the service MGBFTB02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class GenerationsDTO {
	
	private String generation;
	private String schoolLevel;
	
  	/**      
    *
    * Method getGeneration.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getGeneration() {
		return generation;
	}
	
	/**      
    *
    * Method setGeneration.
    * Contains the set parameter for the service
    * 
    * @param String generation
    * 
    */
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	
  	/**      
    *
    * Method getSchoolLevel.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getSchoolLevel() {
		return schoolLevel;
	}
	
	/**      
    *
    * Method setSchoolLevel.
    * Contains the set parameter for the service
    * 
    * @param String schoolLevel
    * 
    */
	public void setSchoolLevel(String schoolLevel) {
		this.schoolLevel = schoolLevel;
	}
	
}
