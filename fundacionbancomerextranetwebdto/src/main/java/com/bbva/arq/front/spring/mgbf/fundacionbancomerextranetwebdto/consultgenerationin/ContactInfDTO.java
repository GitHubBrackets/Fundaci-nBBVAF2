package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.consultgenerationin;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class ContactInfDTO
 * Contains the input values for the service MGBFTB02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class ContactInfDTO {
	
	private String homePhone;
	private String cellPhone;
	private String messagePhone;
	private String email;
	private String email1;
	private String email2;
	
  	/**      
    *
    * Method getHomePhone.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getHomePhone() {
		return homePhone;
	}
	
	/**      
    *
    * Method setHomePhone.
    * Contains the set parameter for the service
    * 
    * @param String homePhone
    * 
    */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	
  	/**      
    *
    * Method getCellPhone.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getCellPhone() {
		return cellPhone;
	}
	
	/**      
    *
    * Method setCellPhone.
    * Contains the set parameter for the service
    * 
    * @param String cellPhone
    * 
    */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
  	/**      
    *
    * Method getMessagePhone.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getMessagePhone() {
		return messagePhone;
	}
	
	/**      
    *
    * Method setMessagePhone.
    * Contains the set parameter for the service
    * 
    * @param String messagePhone
    * 
    */
	public void setMessagePhone(String messagePhone) {
		this.messagePhone = messagePhone;
	}
	
  	/**      
    *
    * Method getEmail.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getEmail() {
		return email;
	}
	
	/**      
    *
    * Method setEmail.
    * Contains the set parameter for the service
    * 
    * @param String email
    * 
    */
	public void setEmail(String email) {
		this.email = email;
	}
	
  	/**      
    *
    * Method getEmail1.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getEmail1() {
		return email1;
	}
	
	/**      
    *
    * Method setEmail1.
    * Contains the set parameter for the service
    * 
    * @param String email1
    * 
    */
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	
  	/**      
    *
    * Method getEmail2.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getEmail2() {
		return email2;
	}
	
	/**      
    *
    * Method setEmail2.
    * Contains the set parameter for the service
    * 
    * @param String email2
    * 
    */
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

}
