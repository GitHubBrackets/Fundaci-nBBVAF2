package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.averageschoolgrade;

/**
 * Class AverageSchoolGradeDTO
 * Contains the input values for the service MGBFTC03
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class AverageSchoolGradeDTO {
	private String schoolGrade;
	private double averageSchoolGrade;
	
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
    * Method getAverageSchoolGrade.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public double getAverageSchoolGrade() {
		return averageSchoolGrade;
	}
	
	/**      
    *
    * Method setAverageSchoolGrade.
    * Contains the set parameter for the service
    * 
    * @param float averageSchoolGrade
    * 
    */
	public void setAverageSchoolGrade(float averageSchoolGrade) {
		this.averageSchoolGrade = averageSchoolGrade;
	}
}
