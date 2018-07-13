package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.consultparameters;

/**
 * Class ParametersDTO
 * Contains the input values for the service MGBFTP01
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class ParametersDTO {
	
	private String parameterType;
	private String parameterTypeDescription;
	private String parameterDescription;
	private int status; 
	private String programType;
	private String programName;
	
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
    * Method getParameterTypeDescription.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getParameterTypeDescription() {
		return parameterTypeDescription;
	}
	
	/**      
    *
    * Method setParameterTypeDescription.
    * Contains the set parameter for the service
    * 
    * @param String parameterTypeDescription
    * 
    */
	public void setParameterTypeDescription(String parameterTypeDescription) {
		this.parameterTypeDescription = parameterTypeDescription;
	}
	
  	/**      
    *
    * Method getParameterDescription.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getParameterDescription() {
		return parameterDescription;
	}
	
	/**      
    *
    * Method setParameterDescription.
    * Contains the set parameter for the service
    * 
    * @param String parameterDescription
    * 
    */
	public void setParameterDescription(String parameterDescription) {
		this.parameterDescription = parameterDescription;
	}
	
  	/**      
    *
    * Method getStatus.
    * Contains the get parameter for the service
    * @return int value as parameter.
    *
    */
	public int getStatus() {
		return status;
	}
	
	/**      
    *
    * Method setStatus.
    * Contains the set parameter for the service
    * 
    * @param int status
    * 
    */
	public void setStatus(int status) {
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
    * Contains the set parameter for the service
    * 
    * @param String programType
    * 
    */
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	
  	/**      
    *
    * Method getProgramName.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getProgramName() {
		return programName;
	}
	
	/**      
    *
    * Method setProgramName.
    * Contains the set parameter for the service
    * 
    * @param String programName
    * 
    */
	public void setProgramName(String programName) {
		this.programName = programName;
	}

}
