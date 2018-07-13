package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.consultgenerationin;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class DomicileDTO
 * Contains the input values for the service MGBFTB02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class DomicileDTO {

	private String street;
	private String locality;
	private String numExterior;
	private String numInterior;
	private String codePostal;
	private String cdMunicipality;
	private String municipality;
	private String colony;
	private String cdState;
	private String state;
	private String betweenStreet;
	private String typeOfRoad1;
	private String andTheStreet;
	private String typeOfRoad2;
	private String behindStreet;
	private String typeOfRoad3;
	private String particularReferences;
	
  	/**      
    *
    * Method getStreet.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getStreet() {
		return street;
	}
	
	/**      
    *
    * Method setStreet.
    * Contains the set parameter for the service
    * 
    * @param String street
    * 
    */
	public void setStreet(String street) {
		this.street = street;
	}
	
  	/**      
    *
    * Method getLocality.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getLocality() {
		return locality;
	}
	
	/**      
    *
    * Method setLocality.
    * Contains the set parameter for the service
    * 
    * @param String userScholar
    * 
    */
	public void setLocality(String locality) {
		this.locality = locality;
	}
	
  	/**      
    *
    * Method getNumExterior.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getNumExterior() {
		return numExterior;
	}
	
	/**      
    *
    * Method setNumExterior.
    * Contains the set parameter for the service
    * 
    * @param String numExterior
    * 
    */
	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior;
	}
	
  	/**      
    *
    * Method getNumInterior.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getNumInterior() {
		return numInterior;
	}
	
	/**      
    *
    * Method setNumInterior.
    * Contains the set parameter for the service
    * 
    * @param String numInterior
    * 
    */
	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
	}
	
  	/**      
    *
    * Method getCodePostal.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getCodePostal() {
		return codePostal;
	}
	
	/**      
    *
    * Method setCodePostal.
    * Contains the set parameter for the service
    * 
    * @param String codePostal
    * 
    */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
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
    * Method getColony.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getColony() {
		return colony;
	}
	
	/**      
    *
    * Method setColony.
    * Contains the set parameter for the service
    * 
    * @param String colony
    * 
    */
	public void setColony(String colony) {
		this.colony = colony;
	}
	
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
    * Method getBetweenStreet.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getBetweenStreet() {
		return betweenStreet;
	}
	
	/**      
    *
    * Method setBetweenStreet.
    * Contains the set parameter for the service
    * 
    * @param String betweenStreet
    * 
    */
	public void setBetweenStreet(String betweenStreet) {
		this.betweenStreet = betweenStreet;
	}
	
  	/**      
    *
    * Method getTypeOfRoad1.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getTypeOfRoad1() {
		return typeOfRoad1;
	}
	
	/**      
    *
    * Method setTypeOfRoad1.
    * Contains the set parameter for the service
    * 
    * @param String typeOfRoad1
    * 
    */
	public void setTypeOfRoad1(String typeOfRoad1) {
		this.typeOfRoad1 = typeOfRoad1;
	}
	
  	/**      
    *
    * Method getAndTheStreet.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getAndTheStreet() {
		return andTheStreet;
	}
	
	/**      
    *
    * Method setAndTheStreet.
    * Contains the set parameter for the service
    * 
    * @param String andTheStreet
    * 
    */
	public void setAndTheStreet(String andTheStreet) {
		this.andTheStreet = andTheStreet;
	}
	
  	/**      
    *
    * Method getTypeOfRoad2.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getTypeOfRoad2() {
		return typeOfRoad2;
	}
	
	/**      
    *
    * Method setTypeOfRoad2.
    * Contains the set parameter for the service
    * 
    * @param String typeOfRoad2
    * 
    */
	public void setTypeOfRoad2(String typeOfRoad2) {
		this.typeOfRoad2 = typeOfRoad2;
	}
	
  	/**      
    *
    * Method getBehindStreet.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getBehindStreet() {
		return behindStreet;
	}
	
	/**      
    *
    * Method setBehindStreet.
    * Contains the set parameter for the service
    * 
    * @param String behindStreet
    * 
    */
	public void setBehindStreet(String behindStreet) {
		this.behindStreet = behindStreet;
	}
	
  	/**      
    *
    * Method behindStreet.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String behindStreet() {
		return typeOfRoad3;
	}
	
	public String getTypeOfRoad3() {
		return typeOfRoad3;
	}
	
	/**      
    *
    * Method setTypeOfRoad3.
    * Contains the set parameter for the service
    * 
    * @param String typeOfRoad3
    * 
    */
	public void setTypeOfRoad3(String typeOfRoad3) {
		this.typeOfRoad3 = typeOfRoad3;
	}
	
  	/**      
    *
    * Method getParticularReferences.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getParticularReferences() {
		return particularReferences;
	}
	
	/**      
    *
    * Method setParticularReferences.
    * Contains the set parameter for the service
    * 
    * @param String particularReferences
    * 
    */
	public void setParticularReferences(String particularReferences) {
		this.particularReferences = particularReferences;
	}

}
