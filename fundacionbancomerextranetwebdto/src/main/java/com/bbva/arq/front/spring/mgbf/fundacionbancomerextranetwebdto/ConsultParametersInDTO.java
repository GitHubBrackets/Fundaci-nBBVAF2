package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

/**
 * Class ConsultParametersInDTO
 * Contains the input values for the service MGBFTP01
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class ConsultParametersInDTO {
	
	private String parameterType;
	private String status;
	private String programType;
	
  	/**      
    *
    * Method getParameterType.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getParameterType() {
		return parameterType;
	}
	
	/**      
    *
    * Method setParameterType.
    * Contains the set parameter for the service
    * 
    * @param String parameterType
    * 
    */
	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}
	
  	/**      
    *
    * Method getStatus.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getStatus() {
		return status;
	}
	
	/**      
    *
    * Method setStatus.
    * Contains the set parameter for the service
    * 
    * @param String status
    * 
    */
	public void setStatus(String status) {
		this.status = status;
	}
	
  	/**      
    *
    * Method getProgramType.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getProgramType() {
		return programType;
	}
	
	/**      
    *
    * Method setProgramType.
    * Contains the set parameter for the services
    * 
    * @param String programType
    * 
    */
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	
	
	

}
