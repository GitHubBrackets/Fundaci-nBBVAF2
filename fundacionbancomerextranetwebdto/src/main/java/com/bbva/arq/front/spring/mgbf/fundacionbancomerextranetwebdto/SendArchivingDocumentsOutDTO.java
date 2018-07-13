package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.sendArchivingDocumentsOut.MessageErrorDTO;

@JsonIgnoreProperties(ignoreUnknown = true)

/**
 * Class AlertInDTO
 * Contains the input values for the service MGBFTK01
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class SendArchivingDocumentsOutDTO {
	private List<?> listDocuments;
	private MessageErrorDTO messageError;
	private String referenceNumber;
	
  	/**      
    *
    * Method getListDocuments.
    * Contains the get parameter for the service
    * @return List<?> value as parameter.
    *
    */
	public List<?> getListDocuments() {
		return listDocuments;
	}
	
	/**      
    *
    * Method setListDocuments.
    * Contains the set parameter for the service
    * 
    * @param List<?> listDocuments
    * 
    */
	public void setListDocuments(List<?> listDocuments) {
		this.listDocuments = listDocuments;
	}
	
  	/**      
    *
    * Method MessageErrorDTO.
    * Contains the get parameter for the service
    * @return MessageErrorDTO Object as parameter.
    *
    */
	public MessageErrorDTO getMessageError() {
		return messageError;
	}
	
	/**      
    *
    * Method setMessageError.
    * Contains the set parameter for the service
    * 
    * @param MessageErrorDTO messageError
    * 
    */
	public void setMessageError(MessageErrorDTO messageError) {
		this.messageError = messageError;
	}
	
  	/**      
    *
    * Method getReferenceNumber.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getReferenceNumber() {
		return referenceNumber;
	}
	
	/**      
    *
    * Method setReferenceNumber.
    * Contains the set parameter for the service
    * 
    * @param String referenceNumber
    * 
    */
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
}
