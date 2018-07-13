package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.qualificationsqueryout;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class QualificationDTO
 * Contains the input values for the service MGBFTC02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class QualificationDTO {
	private String scholarLevel;
	private String schoolGrade;
	private String schoolPeriod;
	private double qualification;
	private String folio;
	
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
	
  	/**      
    *
    * Method getQualification.
    * Contains the get parameter for the service
    * @return double value as parameter.
    *
    */
	public double getQualification() {
		return qualification;
	}
	
	/**      
    *
    * Method setQualification.
    * Contains the set parameter for the service
    * 
    * @param double qualification
    * 
    */
	public void setQualification(double qualification) {
		this.qualification = qualification;
	}
	
  	/**      
    *
    * Method getFolio.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getFolio() {
		return folio;
	}
	
	/**      
    *
    * Method setFolio.
    * Contains the set parameter for the service
    * 
    * @param String userScholar
    * 
    */
	public void setFolio(String folio) {
		this.folio = folio;
	}
	
}
