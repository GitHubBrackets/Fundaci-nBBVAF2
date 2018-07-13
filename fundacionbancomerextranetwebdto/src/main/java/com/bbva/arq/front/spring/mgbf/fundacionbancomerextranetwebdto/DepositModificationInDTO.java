package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

/**
 * Class DepositModificationInDTO
 * Contains the input values for the service MGBFTH02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class DepositModificationInDTO {
	 private int userCurrent;
	 private String studentID;
	 private String monthConfirm;
	 private String yearConfirm;
	 private String programType;
	 private String scholarCycle;
	 private String scholarLevel;
	 private String scholarGrade;
	 private String statusScholarshipReceived;
	 private String statusReview;
	 private String staffAnswer;
	 
	  	/**      
	    *
	    * Method getUserCurrent.
	    * Contains the get parameter for the service
	    * @return int value as parameter.
	    *
	    */
	 public int getUserCurrent() {
		 return userCurrent;
	 }
	 
		/**      
	    *
	    * Method setUserCurrent.
	    * Contains the set parameter for the service
	    * 
	    * @param int userCurrent
	    * 
	    */
	 public void setUserCurrent(int userCurrent) {
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
	    * Method getMonthConfirm.
	    * Contains the get parameter for the service
	    * @return String value as parameter.
	    *
	    */
	 public String getMonthConfirm() {
		 return monthConfirm;
	 }
	 
		/**      
	    *
	    * Method setMonthConfirm.
	    * Contains the set parameter for the service
	    * 
	    * @param String monthConfirm
	    * 
	    */
	 public void setMonthConfirm(String monthConfirm) {
		 this.monthConfirm = monthConfirm;
	 }
	 
	  	/**      
	    *
	    * Method getYearConfirm.
	    * Contains the get parameter for the service
	    * @return String value as parameter.
	    *
	    */
	 public String getYearConfirm() {
		 return yearConfirm;
	 }
	 
		/**      
	    *
	    * Method setYearConfirm.
	    * Contains the set parameter for the service
	    * 
	    * @param String yearConfirm
	    * 
	    */
	 public void setYearConfirm(String yearConfirm) {
		 this.yearConfirm = yearConfirm;
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
	 
	  	/**      
	    *
	    * Method getStatusReview.
	    * Contains the get parameter for the service
	    * @return String value as parameter.
	    *
	    */
	 public String getStatusReview() {
		 return statusReview;
	 }
	 
		/**      
	    *
	    * Method setStatusReview.
	    * Contains the set parameter for the service
	    * 
	    * @param String statusReview
	    * 
	    */
	 public void setStatusReview(String statusReview) {
		 this.statusReview = statusReview;
	 }
	 
	  	/**      
	    *
	    * Method getStaffAnswer.
	    * Contains the get parameter for the service
	    * @return String value as parameter.
	    *
	    */
	 public String getStaffAnswer() {
		 return staffAnswer;
	 }
	 
		/**      
	    *
	    * Method setStaffAnswer.
	    * Contains the set parameter for the service
	    * 
	    * @param String staffAnswer
	    * 
	    */
	 public void setStaffAnswer(String staffAnswer) {
		 this.staffAnswer = staffAnswer;
	 }
}
