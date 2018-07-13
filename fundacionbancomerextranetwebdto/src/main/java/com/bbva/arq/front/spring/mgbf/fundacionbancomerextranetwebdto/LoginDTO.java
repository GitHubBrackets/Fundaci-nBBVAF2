package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class LoginDTO
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class LoginDTO {
	
	private String user;
	private String password;
	
  	/**      
    *
    * Method getUser.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getUser() {
		return user;
	}

	/**      
    *
    * Method setUser.
    * Contains the set parameter for the service
    * 
    * @param String user
    * 
    */
	public void setUser(String user) {
		this.user = user;
	}

  	/**      
    *
    * Method getPassword.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getPassword() {
		return password;
	}

	/**      
    *
    * Method setPassword.
    * Contains the set parameter for the service
    * 
    * @param String password
    * 
    */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
