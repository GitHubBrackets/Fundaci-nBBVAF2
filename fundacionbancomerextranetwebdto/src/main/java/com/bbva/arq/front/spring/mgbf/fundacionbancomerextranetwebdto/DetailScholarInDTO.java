package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

/**
 * Class DetailScholarInDTO
 * Contains the input values for the service MGBFTB03
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */

public class DetailScholarInDTO {
	
	private String userScholar;

  	/**      
    *
    * Method getUserScholar.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getUserScholar() {
		return userScholar;
	}

	/**      
    *
    * Method setUserScholar.
    * Contains the set parameter for the service
    * 
    * @param String userScholar
    * 
    */
	public void setUserScholar(String userScholar) {
		this.userScholar = userScholar;
	}
	
}
