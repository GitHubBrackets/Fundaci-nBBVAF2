package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinnoclient;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class GrantingTicketAuthenticatonDataNoClientInDTO
 * Contains the input values for the service GrantingTicket75
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class GrantingTicketAuthenticatonDataNoClientInDTO {
	
	private String idAuthenticationData;
	private List<?> authenticationData;
	
	
  	/**      
    *
    * Method getIdAuthenticationData.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getIdAuthenticationData() {
		return idAuthenticationData;
	}
	
	/**      
    *
    * Method setIdAuthenticationData.
    * Contains the set parameter for the service
    * 
    * @param String idAuthenticationData
    * 
    */
	public void setIdAuthenticationData(String idAuthenticationData) {
		this.idAuthenticationData = idAuthenticationData;
	}
	
  	/**      
    *
    * Method getAuthenticationData.
    * Contains the get parameter for the service
    * @return List<?> value as parameter.
    *
    */
	public List<?> getAuthenticationData() {
		return authenticationData;
	}
	
	/**      
    *
    * Method setAuthenticationData.
    * Contains the set parameter for the service
    * 
    * @param List<?> authenticationData
    * 
    */
	public void setAuthenticationData(List<?> authenticationData) {
		this.authenticationData = authenticationData;
	}

}
