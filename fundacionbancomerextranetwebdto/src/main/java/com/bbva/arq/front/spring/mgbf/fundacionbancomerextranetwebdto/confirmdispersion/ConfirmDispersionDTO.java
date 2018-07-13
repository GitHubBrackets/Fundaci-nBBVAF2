package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.confirmdispersion;
/**
 * Class ConfirmDispersionDTO
 * Contains the input values for the service
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class ConfirmDispersionDTO {
	private String monthConfirm;
	private int yearConfirm;
	private String statusScholarshipReceived;
	private String staffAnswer;
	private String statusReview;
	
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
    * @return int value as parameter.
    *
    */
	public int getYearConfirm() {
		return yearConfirm;
	}
	
	/**      
    *
    * Method setYearConfirm.
    * Contains the set parameter for the service
    * 
    * @param int yearConfirm
    * 
    */
	public void setYearConfirm(int yearConfirm) {
		this.yearConfirm = yearConfirm;
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
}
