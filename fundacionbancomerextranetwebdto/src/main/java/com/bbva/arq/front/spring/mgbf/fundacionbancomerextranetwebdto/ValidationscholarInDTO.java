package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class ValidationscholarInDTO
 * Contains the input values for the service MGBFTL01
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class ValidationscholarInDTO {
	
	private String tutorName;
	private String tutorLastName;
	private String tutorSecondLastName;
	private String studentName;
	private String studentLastName;
	private String studentSecondLastName;
	private String studentCURP;
	
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
    * Method getTutorLastName.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getTutorLastName() {
		return tutorLastName;
	}
	
	/**      
    *
    * Method setTutorLastName.
    * Contains the set parameter for the service
    * 
    * @param String tutorLastName
    * 
    */
	public void setTutorLastName(String tutorLastName) {
		this.tutorLastName = tutorLastName;
	}
	
  	/**      
    *
    * Method getTutorSecondLastName.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getTutorSecondLastName() {
		return tutorSecondLastName;
	}
	
	/**      
    *
    * Method setTutorSecondLastName.
    * Contains the set parameter for the service
    * 
    * @param String tutorSecondLastName
    * 
    */
	public void setTutorSecondLastName(String tutorSecondLastName) {
		this.tutorSecondLastName = tutorSecondLastName;
	}
	
  	/**      
    *
    * Method getStudentName.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getStudentName() {
		return studentName;
	}
	
	/**      
    *
    * Method setStudentName.
    * Contains the set parameter for the service
    * 
    * @param String studentName
    * 
    */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
  	/**      
    *
    * Method getStudentLastName.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getStudentLastName() {
		return studentLastName;
	}
	
	/**      
    *
    * Method setStudentLastName.
    * Contains the set parameter for the service
    * 
    * @param String studentLastName
    * 
    */
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	
  	/**      
    *
    * Method getStudentSecondLastName.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getStudentSecondLastName() {
		return studentSecondLastName;
	}
	
	/**      
    *
    * Method setStudentSecondLastName.
    * Contains the set parameter for the service
    * 
    * @param String studentSecondLastName
    * 
    */
	public void setStudentSecondLastName(String studentSecondLastName) {
		this.studentSecondLastName = studentSecondLastName;
	}
	
  	/**      
    *
    * Method getStudentCURP.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getStudentCURP() {
		return studentCURP;
	}
	
	/**      
    *
    * Method setStudentCURP.
    * Contains the set parameter for the service
    * 
    * @param String studentCURP
    * 
    */
	public void setStudentCURP(String studentCURP) {
		this.studentCURP = studentCURP;
	}

	

}
