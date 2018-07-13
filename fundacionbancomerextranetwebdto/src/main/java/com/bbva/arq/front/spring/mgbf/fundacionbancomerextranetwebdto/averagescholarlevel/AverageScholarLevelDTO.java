package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.averagescholarlevel;

import java.util.List;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.averageschoolgrade.AverageSchoolGradeDTO;

/**
 * Class AverageScholarLevelDTO
 * Contains the input values for the service MGBFTC03
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class AverageScholarLevelDTO {
	private String scholarLevel;
	private double averageScholarLevel;
	private List<AverageSchoolGradeDTO>averagesSchoolGrade;
	
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
    * Method getAverageScholarLevel.
    * Contains the get parameter for the service
    * @return double value as parameter.
    *
    */
	public double getAverageScholarLevel() {
		return averageScholarLevel;
	}
	
	/**      
    *
    * Method setAverageScholarLevel.
    * Contains the set parameter for the service
    * 
    * @param String averageScholarLevel
    * 
    */
	public void setAverageScholarLevel(float averageScholarLevel) {
		this.averageScholarLevel = averageScholarLevel;
	}
	
  	/**      
    *
    * Method getAveragesSchoolGrade.
    * Contains the get parameter for the service
    * @return List<AverageSchoolGradeDTO> value as parameter.
    *
    */
	public List<AverageSchoolGradeDTO> getAveragesSchoolGrade() {
		return averagesSchoolGrade;
	}
	
	/**      
    *
    * Method setAveragesSchoolGrade.
    * Contains the set parameter for the service
    * 
    * @param List<AverageSchoolGradeDTO> averagesSchoolGrade
    * 
    */
	public void setAveragesSchoolGrade(List<AverageSchoolGradeDTO> averagesSchoolGrade) {
		this.averagesSchoolGrade = averagesSchoolGrade;
	}
}
