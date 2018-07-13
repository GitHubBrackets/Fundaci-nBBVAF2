package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinnoclient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class GrantingTicketBackendUserRequestNoClientInDTO
 * Contains the input values for the service GrantingTicket75
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class GrantingTicketBackendUserRequestNoClientInDTO {
	
	private String userId;
	private String accessCode;
	private String dialogId;
	
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
