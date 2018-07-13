package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinnoclient.GrantingTicketAuthenticationNoClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinnoclient.GrantingTicketBackendUserRequestNoClientInDTO;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class GrantingTicketNoClientInDTO
 * Contains the input values for the service GrantingTicket for App75
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class GrantingTicketNoClientInDTO {
	
	private GrantingTicketAuthenticationNoClientInDTO authentication;
	private GrantingTicketBackendUserRequestNoClientInDTO backendUserRequest;
	
  	/**      
    *
    * Method GrantingTicketAuthenticationNoClientInDTO.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public GrantingTicketAuthenticationNoClientInDTO getAuthentication() {
		return authentication;
	}
	
	/**      
    *
    * Method setAuthentication.
    * Contains the set parameter for the service
    * @return GrantingTicketAuthenticationClientInDTO Object as parameter.
    * 
    * @param GrantingTicketAuthenticationClientInDTO authentication
    * 
    */
	public void setAuthentication(GrantingTicketAuthenticationNoClientInDTO authentication) {
		this.authentication = authentication;
	}
	
  	/**      
    *
    * Method GrantingTicketBackendUserRequestNoClientInDTO.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public GrantingTicketBackendUserRequestNoClientInDTO getBackendUserRequest() {
		return backendUserRequest;
	}
	
	/**      
    *
    * Method setBackendUserRequest.
    * Contains the set parameter for the service
    * 
    * @param GrantingTicketBackendUserRequestNoClientInDTO backendUserRequest
    * 
    */
	public void setBackendUserRequest(
			GrantingTicketBackendUserRequestNoClientInDTO backendUserRequest) {
		this.backendUserRequest = backendUserRequest;
	}
	
	

}
