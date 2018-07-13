package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class AveragesQueryInDTO
 * Contains the input values for the service MGBFTC03
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class AveragesQueryInDTO {
	private String studentID;
	private String scholarLevel;
	private String schoolGrade;
	
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
    * @return a String value as parameter.
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
	
  	/**      
    *
    * Method getSchoolGrade.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getSchoolGrade() {
		return schoolGrade;
	}
	
	/**      
    *
    * Method setSchoolGrade.
    * Contains the set parameter for the service
    * 
    * @param String schoolGrade
    * 
    */
	public void setSchoolGrade(String schoolGrade) {
		this.schoolGrade = schoolGrade;
	}
}
