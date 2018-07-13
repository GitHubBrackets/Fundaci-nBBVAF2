package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class QualificationsQueryInDTO
 * Contains the input values for the service MGBFTC02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class QualificationsQueryInDTO {
	private String studentID;
	private String scholarLevel;
	private String schoolGrade;
	private String schoolPeriod;
	
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
	
  	/**      
    *
    * Method getSchoolPeriod.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getSchoolPeriod() {
		return schoolPeriod;
	}
	
	/**      
    *
    * Method setSchoolPeriod.
    * Contains the set parameter for the service
    * 
    * @param String schoolPeriod
    * 
    */
	public void setSchoolPeriod(String schoolPeriod) {
		this.schoolPeriod = schoolPeriod;
	}
	
}
