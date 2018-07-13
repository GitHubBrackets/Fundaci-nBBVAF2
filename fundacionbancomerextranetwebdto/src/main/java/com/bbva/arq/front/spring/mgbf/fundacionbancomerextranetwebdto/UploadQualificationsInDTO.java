package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class UploadQualificationsInDTO
 * Contains the input values for the service MGBFTC01
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class UploadQualificationsInDTO {
	private String studentID;
	private String programType;
	private String schoolGrade;
	private String schoolCycle;
	private String schoolPeriod;
	private String qualification;
	private String userCurrent;
	
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
    * Method getSchoolCycle.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getSchoolCycle() {
		return schoolCycle;
	}
	
	/**      
    *
    * Method setSchoolCycle.
    * Contains the set parameter for the service
    * 
    * @param String schoolCycle
    * 
    */
	public void setSchoolCycle(String schoolCycle) {
		this.schoolCycle = schoolCycle;
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
	
  	/**      
    *
    * Method getQualification.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getQualification() {
		return qualification;
	}
	
	/**      
    *
    * Method setQualification.
    * Contains the set parameter for the service
    * 
    * @param String qualification
    * 
    */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
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
	
}
