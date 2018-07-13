package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinclient.GrantingTicketAuthenticationClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinclient.GrantingTicketBackendUserRequestClientInDTO;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class GrantingTicketClientInDTO
 * Contains the input values for the service GrantingTicket for App74
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class GrantingTicketClientInDTO {
	
	private GrantingTicketAuthenticationClientInDTO authentication;
	private GrantingTicketBackendUserRequestClientInDTO backendUserRequest;
	
  	/**      
    *
    * Method GrantingTicketAuthenticationClientInDTO.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public GrantingTicketAuthenticationClientInDTO getAuthentication() {
		return authentication;
	}
	
	/**      
    *
    * Method setAuthentication.
    * Contains the set parameter for the service
    * 
    * @param GrantingTicketAuthenticationClientInDTO authentication
    * 
    */
	public void setAuthentication(GrantingTicketAuthenticationClientInDTO authentication) {
		this.authentication = authentication;
	}
	
  	/**      
    *
    * Method GrantingTicketBackendUserRequestClientInDTO.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public GrantingTicketBackendUserRequestClientInDTO getBackendUserRequest() {
		return backendUserRequest;
	}
	
	/**      
    *
    * Method setBackendUserRequest.
    * Contains the set parameter for the service
    * 
    * @param GrantingTicketBackendUserRequestClientInDTO backendUserRequest
    * 
    */
	public void setBackendUserRequest(
			GrantingTicketBackendUserRequestClientInDTO backendUserRequest) {
		this.backendUserRequest = backendUserRequest;
	}
	
	
	

}
