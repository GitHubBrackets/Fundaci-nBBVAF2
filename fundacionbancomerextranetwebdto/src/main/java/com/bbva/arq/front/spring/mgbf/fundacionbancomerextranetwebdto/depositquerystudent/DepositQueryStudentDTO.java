package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.depositquerystudent;

import java.util.List;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.confirmdispersion.ConfirmDispersionDTO;

/**
 * Class DepositQueryStudentDTO
 * Contains the input values for the service MGFBTH01
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class DepositQueryStudentDTO {
	private int studentID;
	private String programType;
	private String scholarCycle;
	private String scholarGrade;
	private String scholarLevel;
	private List<ConfirmDispersionDTO>confirmDisp;
	
  	/**      
    *
    * Method getStudentID.
    * Contains the get parameter for the service
    * @return int value as parameter.
    *
    */
	public int getStudentID() {
		return studentID;
	}
	
	/**      
    *
    * Method setStudentID.
    * Contains the set parameter for the service
    * 
    * @param int studentID
    * 
    */
	public void setStudentID(int studentID) {
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
    * Method getScholarCycle.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getScholarCycle() {
		return scholarCycle;
	}
	
	/**      
    *
    * Method setScholarCycle.
    * Contains the set parameter for the service
    * 
    * @param String scholarCycle
    * 
    */
	public void setScholarCycle(String scholarCycle) {
		this.scholarCycle = scholarCycle;
	}
	
  	/**      
    *
    * Method getScholarGrade.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getScholarGrade() {
		return scholarGrade;
	}
	
	/**      
    *
    * Method setScholarGrade.
    * Contains the set parameter for the service
    * 
    * @param String scholarGrade
    * 
    */
	public void setScholarGrade(String scholarGrade) {
		this.scholarGrade = scholarGrade;
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
    * Method getConfirmDisp.
    * Contains the get parameter for the service
    * @return List<ConfirmDispersionDTO> value as parameter.
    *
    */
	public List<ConfirmDispersionDTO> getConfirmDisp() {
		return confirmDisp;
	}
	
	/**      
    *
    * Method setConfirmDisp.
    * Contains the set parameter for the service
    * 
    * @param List<ConfirmDispersionDTO> confirmDisp
    * 
    */
	public void setConfirmDisp(List<ConfirmDispersionDTO> confirmDisp) {
		this.confirmDisp = confirmDisp;
	}
	
}
