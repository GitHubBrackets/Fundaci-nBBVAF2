package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) 

/**
 * Class DepositQueryInDTO
 * Contains the input values for the service MGFBTH01
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class DepositQueryInDTO {
	private String userCurrent;
	private String studentID;
	private String programType;
	private String statusScholarshipReceived;
	
  	/**      
    *
    * Method getUserCurrent.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getUserCurrent() {
		return userCurrent;
	}
	
	/**      
    *
    * Method setUserCurrent.
    * Contains the set parameter for the service
    * 
    * @param String userCurrent
    * 
    */
	public void setUserCurrent(String userCurrent) {
		this.userCurrent = userCurrent;
	}
	
  	/**      
    *
    * Method getStudentID.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getStudentID() {
		return studentID;
	}
	
	/**      
    *
    * Method setStudentID.
    * Contains the set parameter for the service
    * 
    * @param String studentID
    * 
    */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
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
    * Method getStatusScholarshipReceived.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getStatusScholarshipReceived() {
		return statusScholarshipReceived;
	}
	
	/**      
    *
    * Method setStatusScholarshipReceived.
    * Contains the set parameter for the service
    * 
    * @param String statusScholarshipReceived
    * 
    */
	public void setStatusScholarshipReceived(String statusScholarshipReceived) {
		this.statusScholarshipReceived = statusScholarshipReceived;
	}
}
