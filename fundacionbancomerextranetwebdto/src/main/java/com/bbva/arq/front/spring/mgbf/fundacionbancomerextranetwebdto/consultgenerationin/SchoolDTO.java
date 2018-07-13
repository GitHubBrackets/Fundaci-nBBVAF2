package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.consultgenerationin;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class SchoolDTO
 * Contains the input values for the service MGBFTB02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class SchoolDTO {
	
	private String cdState;
	private String state;
	private String cdMunicipality;
	private String municipality;
	@JsonProperty("CCT") private String cct;
	private String control;
	private String initials;
	private String type;
	private String name;
	private String domicile;
	
  	/**      
    *
    * Method getCdState.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getCdState() {
		return cdState;
	}
	
	/**      
    *
    * Method setCdState.
    * Contains the set parameter for the service
    * 
    * @param String cdState
    * 
    */
	public void setCdState(String cdState) {
		this.cdState = cdState;
	}
	
  	/**      
    *
    * Method getState.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getState() {
		return state;
	}
	
	/**      
    *
    * Method setState.
    * Contains the set parameter for the service
    * 
    * @param String state
    * 
    */
	public void setState(String state) {
		this.state = state;
	}
	
  	/**      
    *
    * Method getCdMunicipality.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getCdMunicipality() {
		return cdMunicipality;
	}
	
	/**      
    *
    * Method setCdMunicipality.
    * Contains the set parameter for the service
    * 
    * @param String cdMunicipality
    * 
    */
	public void setCdMunicipality(String cdMunicipality) {
		this.cdMunicipality = cdMunicipality;
	}
	
  	/**      
    *
    * Method getMunicipality.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getMunicipality() {
		return municipality;
	}
	
	/**      
    *
    * Method setMunicipality.
    * Contains the set parameter for the service
    * 
    * @param String municipality
    * 
    */
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	
  	/**      
    *
    * Method getCct.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getCct() {
		return cct;
	}
	
	/**      
    *
    * Method setCct.
    * Contains the set parameter for the service
    * 
    * @param String cct
    * 
    */
	public void setCct(String cct) {
		this.cct = cct;
	}
	
  	/**      
    *
    * Method getControl.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getControl() {
		return control;
	}
	
	/**      
    *
    * Method setControl.
    * Contains the set parameter for the service
    * 
    * @param String control
    * 
    */
	public void setControl(String control) {
		this.control = control;
	}
	
  	/**      
    *
    * Method getInitials.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getInitials() {
		return initials;
	}
	
	/**      
    *
    * Method setInitials.
    * Contains the set parameter for the service
    * 
    * @param String initials
    * 
    */
	public void setInitials(String initials) {
		this.initials = initials;
	}
	
  	/**      
    *
    * Method getType.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getType() {
		return type;
	}
	
	/**      
    *
    * Method setType.
    * Contains the set parameter for the service
    * 
    * @param String type
    * 
    */
	public void setType(String type) {
		this.type = type;
	}
	
  	/**      
    *
    * Method getName.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getName() {
		return name;
	}
	
	/**      
    *
    * Method setName.
    * Contains the set parameter for the service
    * 
    * @param String name
    * 
    */
	public void setName(String name) {
		this.name = name;
	}
	
  	/**      
    *
    * Method getDomicile.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getDomicile() {
		return domicile;
	}
	
	/**      
    *
    * Method setDomicile.
    * Contains the set parameter for the service
    * 
    * @param String domicile
    * 
    */
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
	
}
