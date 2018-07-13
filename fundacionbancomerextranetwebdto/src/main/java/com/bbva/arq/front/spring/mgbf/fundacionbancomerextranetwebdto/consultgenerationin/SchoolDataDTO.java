package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.consultgenerationin;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class SchoolDataDTO
 * Contains the input values for the service MGBFTB02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class SchoolDataDTO {
	
	private String duration;
	private String turn;
	private String typeCareer;
	private String nameCareer;
	private String area;
	private List<SchoolDTO> school;
	
  	/**      
    *
    * Method getDuration.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getDuration() {
		return duration;
	}
	
	/**      
    *
    * Method setUserScholar.
    * Contains the set parameter for the service
    * 
    * @param String duration
    * 
    */
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
  	/**      
    *
    * Method getTurn.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getTurn() {
		return turn;
	}
	
	/**      
    *
    * Method setTurn.
    * Contains the set parameter for the service
    * 
    * @param String turn
    * 
    */
	public void setTurn(String turn) {
		this.turn = turn;
	}
	
  	/**      
    *
    * Method getTypeCareer.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getTypeCareer() {
		return typeCareer;
	}
	
	/**      
    *
    * Method setTypeCareer.
    * Contains the set parameter for the service
    * 
    * @param String typeCareer
    * 
    */
	public void setTypeCareer(String typeCareer) {
		this.typeCareer = typeCareer;
	}
	
  	/**      
    *
    * Method getNameCareer.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getNameCareer() {
		return nameCareer;
	}
	
	/**      
    *
    * Method setNameCareer.
    * Contains the set parameter for the service
    * 
    * @param String nameCareer
    * 
    */
	public void setNameCareer(String nameCareer) {
		this.nameCareer = nameCareer;
	}
	
  	/**      
    *
    * Method getArea.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getArea() {
		return area;
	}
	
	/**      
    *
    * Method setArea.
    * Contains the set parameter for the service
    * 
    * @param String area
    * 
    */
	public void setArea(String area) {
		this.area = area;
	}
	
  	/**      
    *
    * Method getSchool.
    * Contains the get parameter for the service
    * @return List<SchoolDTO> value as parameter.
    *
    */
	public List<SchoolDTO> getSchool() {
		return school;
	}
	
	/**      
    *
    * Method setSchool.
    * Contains the set parameter for the service
    * 
    * @param List<SchoolDTO> school
    * 
    */
	public void setSchool(List<SchoolDTO> school) {
		this.school = school;
	}
	
}
