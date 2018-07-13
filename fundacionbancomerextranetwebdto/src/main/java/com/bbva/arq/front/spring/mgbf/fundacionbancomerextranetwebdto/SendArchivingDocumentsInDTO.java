package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import java.util.List;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.sendArchivingDocumentsIn.*;

/**
 * Class SendArchivingDocumentsInDTO
 * Contains the input values for the service (send document-Archiving)
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class SendArchivingDocumentsInDTO {
	private String aplicationName;
	private List <FeatureDTO> features;
	private DocumentDTO document;
	
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
	
  	/**      
    *
    * Method DocumentDTO.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public DocumentDTO getDocument() {
		return document;
	}
	
	/**      
    *
    * Method setDocument.
    * Contains the set parameter for the service
    * 
    * @param DocumentDTO document
    * 
    */
	public void setDocument(DocumentDTO document) {
		this.document = document;
	}
	
}
