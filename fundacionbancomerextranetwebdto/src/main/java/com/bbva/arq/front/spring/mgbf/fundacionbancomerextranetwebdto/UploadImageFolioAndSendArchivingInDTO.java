package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

/**
 * Class UploadImageFolioAndSendArchivingInDTO
 * Contains the input values for the services (send-Archiving and MGBFTD01)
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class UploadImageFolioAndSendArchivingInDTO {
	
	private UploadImageFolioInDTO imagen;
	private SendArchivingDocumentsInDTO archiving;
	
  	/**      
    *
    * Method UploadImageFolioInDTO.
    * Contains the get parameter for the service
    * @return UploadImageFolioInDTO object as parameter.
    *
    */
	public UploadImageFolioInDTO getImagen() {
		return imagen;
	}
	
	/**      
    *
    * Method setImagen.
    * Contains the set parameter for the service
    * 
    * @param UploadImageFolioInDTO imagen
    * 
    */
	public void setImagen(UploadImageFolioInDTO imagen) {
		this.imagen = imagen;
	}
	
  	/**      
    *
    * Method getArchiving.
    * Contains the get parameter for the service
    * @return SendArchivingDocumentsInDTO object as parameter.
    *
    */
	public SendArchivingDocumentsInDTO getArchiving() {
		return archiving;
	}
	
	/**      
    *
    * Method setArchiving.
    * Contains the set parameter for the service
    * 
    * @param SendArchivingDocumentsInDTO archiving
    * 
    */
	public void setArchiving(SendArchivingDocumentsInDTO archiving) {
		this.archiving = archiving;
	}
	
}
