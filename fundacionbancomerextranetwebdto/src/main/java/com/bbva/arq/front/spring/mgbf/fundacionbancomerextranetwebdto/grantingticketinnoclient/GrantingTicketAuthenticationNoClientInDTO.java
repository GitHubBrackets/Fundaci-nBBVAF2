package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinnoclient;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class GrantingTicketAuthenticationNoClientInDTO
 * Contains the input values for the service GrantingTicket75
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class GrantingTicketAuthenticationNoClientInDTO {
	
	private String userID;
	private String consumerID;
	private String authenticationType;
	private List <GrantingTicketAuthenticatonDataNoClientInDTO> authenticationData;
	
  	/**      
    *
    * Method getUserID.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getUserID() {
		return userID;
	}
	
	/**      
    *
    * Method setUserID.
    * Contains the set parameter for the service
    * 
    * @param String userID
    * 
    */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
  	/**      
    *
    * Method getConsumerID.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getConsumerID() {
		return consumerID;
	}
	
	/**      
    *
    * Method setConsumerID.
    * Contains the set parameter for the service
    * 
    * @param String consumerID
    * 
    */
	public void setConsumerID(String consumerID) {
		this.consumerID = consumerID;
	}
	
  	/**      
    *
    * Method getAuthenticationType.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getAuthenticationType() {
		return authenticationType;
	}
	
	/**      
    *
    * Method setAuthenticationType.
    * Contains the set parameter for the service
    * 
    * @param String authenticationType
    * 
    */
	public void setAuthenticationType(String authenticationType) {
		this.authenticationType = authenticationType;
	}
	
  	/**      
    *
    * Method getAuthenticationData.
    * Contains the get parameter for the service
    * @return List<GrantingTicketAuthenticatonDataNoClientInDTO> value as parameter.
    *
    */
	public List<GrantingTicketAuthenticatonDataNoClientInDTO> getAuthenticationData() {
		return authenticationData;
	}
	
	/**      
    *
    * Method setAuthenticationData.
    * Contains the set parameter for the service
    * 
    * @param String List<GrantingTicketAuthenticatonDataNoClientInDTO> authenticationData
    * 
    */
	public void setAuthenticationData(
			List<GrantingTicketAuthenticatonDataNoClientInDTO> authenticationData) {
		this.authenticationData = authenticationData;
	}
	

}
