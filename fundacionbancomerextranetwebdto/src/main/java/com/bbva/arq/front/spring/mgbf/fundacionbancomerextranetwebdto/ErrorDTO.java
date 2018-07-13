package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class ErrorDTO
 * Contains the input values for the Errors
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class ErrorDTO  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String httpStatusCode;
	private String code;
	private String message;
	
	/**      
    *
    * Method ErrorDTO.
    * Contains the set parameter for the service
    * @return String value as parameter.
    * 
    */
	public ErrorDTO(){
		super();
	}
	 
  	/**      
    *
    * Method getHttpStatusCode.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getHttpStatusCode() {
		return httpStatusCode;
	}

	/**      
    *
    * Method setHttpStatusCode.
    * Contains the set parameter for the service
    * 
    * @param String httpStatusCode
    * 
    */
	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

  	/**      
    *
    * Method getCode.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getCode() {
		return code;
	}

	/**      
    *
    * Method setCode.
    * Contains the set parameter for the service
    * 
    * @param String code
    * 
    */
	public void setCode(String code) {
		this.code = code;
	}

  	/**      
    *
    * Method getMessage.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getMessage() {
		return message;
	}

	/**      
    *
    * Method setMessage.
    * Contains the set parameter for the service
    * 
    * @param String message
    * 
    */
	public void setMessage(String message) {
		this.message = message;
	}

}
