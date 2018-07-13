package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinclient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class AlertInDTO
 * Contains the input values for the service GrantingTicket  App74
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class GrantingTicketAuxClientInDTO {
	
	private String consumerID;
	private String authenticationType;
	private String idAuthenticationData;
	private String userId;
	private String accessCode;
	private String dialogId;
	
	
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
    * Method getUserId.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getUserId() {
		return userId;
	}
	
	/**      
    *
    * Method setUserId.
    * Contains the set parameter for the service
    * 
    * @param String userId
    * 
    */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
  	/**      
    *
    * Method getAccessCode.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getAccessCode() {
		return accessCode;
	}
	
	/**      
    *
    * Method setAccessCode.
    * Contains the set parameter for the service
    * 
    * @param String accessCode
    * 
    */
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}
	
  	/**      
    *
    * Method getDialogId.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getDialogId() {
		return dialogId;
	}
	
	/**      
    *
    * Method setDialogId.
    * Contains the set parameter for the service
    * 
    * @param String dialogId
    * 
    */
	public void setDialogId(String dialogId) {
		this.dialogId = dialogId;
	}

}
