package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.ErrorMetaInfoDTO;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class MessageErrorDTO
 * Contains the input values for the message errors
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class MessageErrorDTO {
	
	private int version;
	private String severity;
	private String httpstatus;
	private String errorcode;
	private String errormessage;
	private String consumerrequestid;
	private String systemerrorcode;
	private String systemerrordescription;
	private String systemerrorcause;
	private ErrorMetaInfoDTO errormetainfo;
	
  	/**      
    *
    * Method getVersion.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public int getVersion() {
		return version;
	}
	
	/**      
    *
    * Method setVersion.
    * Contains the set parameter for the service
    * 
    * @param int version
    * 
    */
	public void setVersion(int version) {
		this.version = version;
	}
	
  	/**      
    *
    * Method getSeverity.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getSeverity() {
		return severity;
	}
	
	/**      
    *
    * Method setSeverity.
    * Contains the set parameter for the service
    * 
    * @param String severity
    * 
    */
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
  	/**      
    *
    * Method getHttpstatus.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getHttpstatus() {
		return httpstatus;
	}
	
	/**      
    *
    * Method setHttpstatus.
    * Contains the set parameter for the service
    * 
    * @param String httpstatus
    * 
    */
	public void setHttpstatus(String httpstatus) {
		this.httpstatus = httpstatus;
	}
	
  	/**      
    *
    * Method getErrorcode.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getErrorcode() {
		return errorcode;
	}
	
	/**      
    *
    * Method setErrorcode.
    * Contains the set parameter for the service
    * 
    * @param String errorcode
    * 
    */
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	
  	/**      
    *
    * Method getErrormessage.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getErrormessage() {
		return errormessage;
	}
	
	/**      
    *
    * Method setErrormessage.
    * Contains the set parameter for the service
    * 
    * @param String errormessage
    * 
    */
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	
  	/**      
    *
    * Method getConsumerrequestid.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getConsumerrequestid() {
		return consumerrequestid;
	}
	
	/**      
    *
    * Method setConsumerrequestid.
    * Contains the set parameter for the service
    * 
    * @param String consumerrequestid
    * 
    */
	public void setConsumerrequestid(String consumerrequestid) {
		this.consumerrequestid = consumerrequestid;
	}
	
  	/**      
    *
    * Method getSystemerrorcode.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getSystemerrorcode() {
		return systemerrorcode;
	}
	
	/**      
    *
    * Method setSystemerrorcode.
    * Contains the set parameter for the service
    * 
    * @param String systemerrorcode
    * 
    */
	public void setSystemerrorcode(String systemerrorcode) {
		this.systemerrorcode = systemerrorcode;
	}
	
  	/**      
    *
    * Method getSystemerrordescription.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getSystemerrordescription() {
		return systemerrordescription;
	}
	
	/**      
    *
    * Method setSystemerrordescription.
    * Contains the set parameter for the service
    * 
    * @param String systemerrordescription
    * 
    */
	public void setSystemerrordescription(String systemerrordescription) {
		this.systemerrordescription = systemerrordescription;
	}
	
  	/**      
    *
    * Method getSystemerrorcause.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getSystemerrorcause() {
		return systemerrorcause;
	}
	
	/**      
    *
    * Method setSystemerrorcause.
    * Contains the set parameter for the service
    * 
    * @param String systemerrorcause
    * 
    */
	public void setSystemerrorcause(String systemerrorcause) {
		this.systemerrorcause = systemerrorcause;
	}
	
  	/**      
    *
    * Method ErrorMetaInfoDTO.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public ErrorMetaInfoDTO getErrormetainfo() {
		return errormetainfo;
	}
	
	/**      
    *
    * Method setErrormetainfo.
    * Contains the set parameter for the service
    * 
    * @param ErrorMetaInfoDTO errormetainfo
    * 
    */
	public void setErrormetainfo(ErrorMetaInfoDTO errormetainfo) {
		this.errormetainfo = errormetainfo;
	}

}
