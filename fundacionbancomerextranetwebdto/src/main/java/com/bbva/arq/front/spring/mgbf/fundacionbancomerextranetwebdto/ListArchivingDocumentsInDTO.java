package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import java.util.List;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.sendArchivingDocumentsIn.FeatureDTO;

/**
 * Class ListArchivingDocumentsInDTO
 * Contains the input values for the service (List Document-Archiving)
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class ListArchivingDocumentsInDTO {
	private String aplicationName;
	private List<String> listReferenceNumber;
	private List<FeatureDTO> features;
	
  	/**      
    *
    * Method getAplicationName.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getAplicationName() {
		return aplicationName;
	}
	
	/**      
    *
    * Method setAplicationName.
    * Contains the set parameter for the service
    * 
    * @param String aplicationName
    * 
    */
	public void setAplicationName(String aplicationName) {
		this.aplicationName = aplicationName;
	}
	
  	/**      
    *
    * Method getListReferenceNumber.
    * Contains the get parameter for the service
    * @return List<String> value as parameter.
    *
    */
	public List<String> getListReferenceNumber() {
		return listReferenceNumber;
	}
	
	/**      
    *
    * Method setListReferenceNumber.
    * Contains the set parameter for the service
    * 
    * @param List<String> listReferenceNumber
    * 
    */
	public void setListReferenceNumber(List<String> listReferenceNumber) {
		this.listReferenceNumber = listReferenceNumber;
	}
	
  	/**      
    *
    * Method getFeatures.
    * Contains the get parameter for the service
    * @return List<FeatureDTO> value as parameter.
    *
    */
	public List<FeatureDTO> getFeatures() {
		return features;
	}
	
	/**      
    *
    * Method setFeatures.
    * Contains the set parameter for the service
    * 
    * @param List<FeatureDTO> features
    * 
    */
	public void setFeatures(List<FeatureDTO> features) {
		this.features = features;
	}
	
}
