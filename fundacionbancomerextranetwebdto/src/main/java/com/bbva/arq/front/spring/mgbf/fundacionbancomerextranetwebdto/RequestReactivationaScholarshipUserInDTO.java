package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

/**
 * Class RequestReactivationaScholarshipUserInDTO
 * Contains the input values for the service (reactivationa scholar-ldap)
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class RequestReactivationaScholarshipUserInDTO {
	private String alias;
	private String password;
	
  	/**      
    *
    * Method getAlias.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getAlias() {
		return alias;
	}
	
	/**      
    *
    * Method setAlias.
    * Contains the set parameter for the service
    * 
    * @param String alias
    * 
    */
	public void setAlias(String alias) {
		this.alias = alias;
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
