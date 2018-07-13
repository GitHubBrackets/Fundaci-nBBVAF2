package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.consultgenerationin;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class ProgramDTO
 * Contains the input values for the service MGBFTB02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class ProgramDTO {
	
	private String status;
	private String modalityParticipation;
	private String generation;
	private String originResources;
	private String projectSEPNumber;
	private String numberNMDP;
	private String schoolGrade;
	private String resultImpactEvaluation;
	
  	/**      
    *
    * Method getStatus.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getStatus() {
		return status;
	}
	
	/**      
    *
    * Method setStatus.
    * Contains the set parameter for the service
    * 
    * @param String status
    * 
    */
	public void setStatus(String status) {
		this.status = status;
	}
	
  	/**      
    *
    * Method getModalityParticipation.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getModalityParticipation() {
		return modalityParticipation;
	}
	
	/**      
    *
    * Method setModalityParticipation.
    * Contains the set parameter for the service
    * 
    * @param String modalityParticipation
    * 
    */
	public void setModalityParticipation(String modalityParticipation) {
		this.modalityParticipation = modalityParticipation;
	}
	
  	/**      
    *
    * Method getGeneration.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getGeneration() {
		return generation;
	}
	
	/**      
    *
    * Method setGeneration.
    * Contains the set parameter for the service
    * 
    * @param String generation
    * 
    */
	public void setGeneration(String generation) {
		this.generation = generation;
	}
	
  	/**      
    *
    * Method getOriginResources.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getOriginResources() {
		return originResources;
	}
	
	/**      
    *
    * Method setOriginResources.
    * Contains the set parameter for the service
    * 
    * @param String originResources
    * 
    */
	public void setOriginResources(String originResources) {
		this.originResources = originResources;
	}
	
  	/**      
    *
    * Method getProjectSEPNumber.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getProjectSEPNumber() {
		return projectSEPNumber;
	}
	
	/**      
    *
    * Method setProjectSEPNumber.
    * Contains the set parameter for the service
    * 
    * @param String projectSEPNumber
    * 
    */
	public void setProjectSEPNumber(String projectSEPNumber) {
		this.projectSEPNumber = projectSEPNumber;
	}
	
  	/**      
    *
    * Method getNumberNMDP.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getNumberNMDP() {
		return numberNMDP;
	}
	
	/**      
    *
    * Method setNumberNMDP.
    * Contains the set parameter for the service
    * 
    * @param String numberNMDP
    * 
    */
	public void setNumberNMDP(String numberNMDP) {
		this.numberNMDP = numberNMDP;
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
    * Method getResultImpactEvaluation.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getResultImpactEvaluation() {
		return resultImpactEvaluation;
	}
	
	/**      
    *
    * Method setResultImpactEvaluation.
    * Contains the set parameter for the service
    * 
    * @param String resultImpactEvaluation
    * 
    */
	public void setResultImpactEvaluation(String resultImpactEvaluation) {
		this.resultImpactEvaluation = resultImpactEvaluation;
	}

	

}
