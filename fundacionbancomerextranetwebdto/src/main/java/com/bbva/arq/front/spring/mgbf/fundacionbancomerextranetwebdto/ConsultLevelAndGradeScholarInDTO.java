package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class ConsultLevelAndGradeScholarInDTO
 * Contains the input values for the service MGBFTB04
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class ConsultLevelAndGradeScholarInDTO {
	
	
	private String studentID;
	private String scholarLevel;
	
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
    * Method getScholarLevel.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getScholarLevel() {
		return scholarLevel;
	}
	
	/**      
    *
    * Method setScholarLevel.
    * Contains the set parameter for the service
    * 
    * @param String scholarLevel
    * 
    */
	public void setScholarLevel(String scholarLevel) {
		this.scholarLevel = scholarLevel;
	}
	
	

}
