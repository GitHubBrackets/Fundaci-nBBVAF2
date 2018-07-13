package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

/**
 * Class GetStatusScholarshipUserInDTO
 * Contains the input values for the service MGBFTK01
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class GetStatusScholarshipUserInDTO {
	private String alias;

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
}
