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
public class DocumentDTO {
	private String data;

  	/**      
    *
    * Method getData.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getData() {
		return data;
	}

	/**      
    *
    * Method setData.
    * Contains the set parameter for the service
    * 
    * @param String data
    * 
    */
	public void setData(String data) {
		this.data = data;
	}
}
