package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.consultgenerationin;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class TutorDataDTO
 * Contains the input values for the service MGBFTB02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class TutorDataDTO {
	
	private String tutorName;
	private String firstNameTutor;
	private String lastNameTutor;
	private String kinship;
	private String kinshipType;
	
  	/**      
    *
    * Method getTutorName.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getTutorName() {
		return tutorName;
	}
	
	/**      
    *
    * Method setTutorName.
    * Contains the set parameter for the service
    * 
    * @param String tutorName
    * 
    */
	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}
	
  	/**      
    *
    * Method getFirstNameTutor.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getFirstNameTutor() {
		return firstNameTutor;
	}
	
	/**      
    *
    * Method setFirstNameTutor.
    * Contains the set parameter for the service
    * 
    * @param String firstNameTutor
    * 
    */
	public void setFirstNameTutor(String firstNameTutor) {
		this.firstNameTutor = firstNameTutor;
	}
	
  	/**      
    *
    * Method getLastNameTutor.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getLastNameTutor() {
		return lastNameTutor;
	}
	
	/**      
    *
    * Method setLastNameTutor.
    * Contains the set parameter for the service
    * 
    * @param String lastNameTutor
    * 
    */
	public void setLastNameTutor(String lastNameTutor) {
		this.lastNameTutor = lastNameTutor;
	}
	
  	/**      
    *
    * Method getKinship.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getKinship() {
		return kinship;
	}
	
	/**      
    *
    * Method setKinship.
    * Contains the set parameter for the service
    * 
    * @param String kinship
    * 
    */
	public void setKinship(String kinship) {
		this.kinship = kinship;
	}
	
  	/**      
    *
    * Method getKinshipType.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getKinshipType() {
		return kinshipType;
	}
	
	/**      
    *
    * Method setKinshipType.
    * Contains the set parameter for the service
    * 
    * @param String kinshipType
    * 
    */
	public void setKinshipType(String kinshipType) {
		this.kinshipType = kinshipType;
	}
	

}
