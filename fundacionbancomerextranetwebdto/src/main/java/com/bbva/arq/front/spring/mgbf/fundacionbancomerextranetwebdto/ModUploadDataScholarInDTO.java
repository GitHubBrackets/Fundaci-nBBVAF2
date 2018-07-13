package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.consultgenerationin.StudentDTO;
@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class ModUploadDataScholarInDTO
 * Contains the input values for the service MGBFTB02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class ModUploadDataScholarInDTO {
	
	private String userCurrent;
	private List<StudentDTO> student;
	
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
	
  	/**      
    *
    * Method getStudent.
    * Contains the get parameter for the service
    * @return List<StudentDTO> value as parameter.
    *
    */
	public List<StudentDTO> getStudent() {
		return student;
	}
	
	/**      
    *
    * Method setStudent.
    * Contains the set parameter for the service
    * 
    * @param List<StudentDTO> student
    * 
    */
	public void setStudent(List<StudentDTO> student) {
		this.student = student;
	}
	
	

}
