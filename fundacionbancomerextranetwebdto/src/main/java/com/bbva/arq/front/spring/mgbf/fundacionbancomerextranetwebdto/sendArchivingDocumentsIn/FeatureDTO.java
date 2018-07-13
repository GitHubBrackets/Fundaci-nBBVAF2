package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.sendArchivingDocumentsIn;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class DocumentDTO
 * Contains the input values for the service (Send Document-Archiving)
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class FeatureDTO {
	private String id;
	private String name;
	
  	/**      
    *
    * Method getId.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getId() {
		return id;
	}
	
	/**      
    *
    * Method setId.
    * Contains the set parameter for the service
    * 
    * @param String id
    * 
    */
	public void setId(String id) {
		this.id = id;
	}
	
  	/**      
    *
    * Method getName.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getName() {
		return name;
	}
	
	/**      
    *
    * Method setName.
    * Contains the set parameter for the service
    * 
    * @param String name
    * 
    */
	public void setName(String name) {
		this.name = name;
	}
}
