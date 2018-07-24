package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class UrlASOUtilsDTO
 * Contains the URLs of all services
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class UrlASOUtilsDTO {
	
	private String urlGrantingTicketClient;
	private String urlGrantingTicketNoClient;
	private String urlValidateScholar;
	private String urlModUploadScholar;
	private String urlConsultLevelAndGradeCholar;
	private String urlUploadQualification;
	private String urlQualificationQuery;
	private String urlAveragesQuery;
	private String urlDetailScholar;
	private String urlUploadImageFolio;
	private String urlDepositQuery;
	private String urlModifDeposit;
	private String urlListArchivingDocuments;
	private String urlSendArchivingDocuments;
	private String urlConsultParameters;
	private String urlListState;
	private String urlListMunicipality;
	private String urlAlerts;
	private String urlLdapCreateScholar;
	private String urlLdapGetStatusScholar;
	private String urlLdapReactivationScholar;
	private String urlUpdatePasswordScholar;
	private String urlApplicationCatalogs;
	private String urlUpdateBiography;
	
  	/**      
    *
    * Method getUrlGrantingTicketNoClient.
    * Get URL for the service GrantingTiket App75
    * @return String value as parameter.
    *
    */
	public String getUrlGrantingTicketNoClient() {
		return urlGrantingTicketNoClient;
	}
	
	/**      
    *
    * Method setUserScholar.
    * Set the URL for the service GrantingTicket App75
    * 
    * @param String urlGrantingTicketNoClient
    * 
    */
	public void setUrlGrantingTicketNoClient(String urlGrantingTicketNoClient) {
		this.urlGrantingTicketNoClient = urlGrantingTicketNoClient;
	}
	
  	/**      
    *
    * Method getUrlValidateScholar.
    * Get the URL for the service MGBFTL01
    * @return String value as parameter.
    *
    */
	public String getUrlValidateScholar() {
		return urlValidateScholar;
	}
	
	/**      
    *
    * Method setUrlValidateScholar.
    * Set the URL for the service MGBFTL01
    * 
    * @param String urlValidateScholar
    * 
    */
	public void setUrlValidateScholar(String urlValidateScholar) {
		this.urlValidateScholar = urlValidateScholar;
	}
	
  	/**      
    *
    * Method getUrlGrantingTicketClient.
    * Get the URL for the service GrantingTicket App74
    * @return String value as parameter.
    *
    */
	public String getUrlGrantingTicketClient() {
		return urlGrantingTicketClient;
	}
	
	/**      
    *
    * Method setUrlGrantingTicketClient.
    * Set the URL for the service GrantingTicket App74
    * 
    * @param String urlGrantingTicketClient
    * 
    */
	public void setUrlGrantingTicketClient(String urlGrantingTicketClient) {
		this.urlGrantingTicketClient = urlGrantingTicketClient;
	}
	
  	/**      
    *
    * Method getUrlModUploadScholar.
    * Get the URL for the service MGBFTB02
    * @return String value as parameter.
    *
    */
	public String getUrlModUploadScholar() {
		return urlModUploadScholar;
	}
	
	/**      
    *
    * Method setUrlModUploadScholar.
    * Set the URL for the service MGBFTB02
    * 
    * @param String urlModUploadScholar
    * 
    */
	public void setUrlModUploadScholar(String urlModUploadScholar) {
		this.urlModUploadScholar = urlModUploadScholar;
	}
	
  	/**      
    *
    * Method getUrlConsultLevelAndGradeCholar.
    * Get the URL for the service MGBFTB04
    * @return String value as parameter.
    *
    */
	public String getUrlConsultLevelAndGradeCholar() {
		return urlConsultLevelAndGradeCholar;
	}
	
	/**      
    *
    * Method setUrlConsultLevelAndGradeCholar.
    * Set the URL for the service MGBFTB04
    * 
    * @param String urlConsultLevelAndGradeCholar
    * 
    */
	public void setUrlConsultLevelAndGradeCholar(
			String urlConsultLevelAndGradeCholar) {
		this.urlConsultLevelAndGradeCholar = urlConsultLevelAndGradeCholar;
	}
	
  	/**      
    *
    * Method getUrlUploadQualification.
    * Get the URL for the service MGBFTC01
    * @return String value as parameter.
    *
    */
	public String getUrlUploadQualification() {
		return urlUploadQualification;
	}
	
	/**      
    *
    * Method setUrlUploadQualification.
    * Set the URL for the service MGBFTC01
    * 
    * @param String urlUploadQualification
    * 
    */
	public void setUrlUploadQualification(String urlUploadQualification) {
		this.urlUploadQualification = urlUploadQualification;
	}
	
  	/**      
    *
    * Method getUrlQualificationQuery.
    * Get the URL for the service MGBFTC02
    * @return String value as parameter.
    *
    */
	public String getUrlQualificationQuery() {
		return urlQualificationQuery;
	}
	
	/**      
    *
    * Method setUrlQualificationQuery.
    * Set the URL for the service MGBFTC02
    * 
    * @param String urlQualificationQuery
    * 
    */
	public void setUrlQualificationQuery(String urlQualificationQuery) {
		this.urlQualificationQuery = urlQualificationQuery;
	}
	
  	/**      
    *
    * Method getUrlAveragesQuery.
    * Get the URL for the service MGBFTC03
    * @return String value as parameter.
    *
    */
	public String getUrlAveragesQuery() {
		return urlAveragesQuery;
	}
	
	/**      
    *
    * Method setUrlAveragesQuery.
    * Set the URL for the service MGBFTC03
    * 
    * @param String urlAveragesQuery
    * 
    */
	public void setUrlAveragesQuery(String urlAveragesQuery) {
		this.urlAveragesQuery = urlAveragesQuery;
	}
	
  	/**      
    *
    * Method getUrlDetailScholar.
    * Get the URL for the service MGBFTB03
    * @return String value as parameter.
    *
    */
	public String getUrlDetailScholar() {
		return urlDetailScholar;
	}
	
	/**      
    *
    * Method setUrlDetailScholar.
    * Set the URL for the service MGBFTB03
    * 
    * @param String urlDetailScholar
    * 
    */
	public void setUrlDetailScholar(String urlDetailScholar) {
		this.urlDetailScholar = urlDetailScholar;
	}
	
  	/**      
    *
    * Method getUrlUploadImageFolio.
    * Get the URL for the service MGBFTD01
    * @return String value as parameter.
    *
    */
	public String getUrlUploadImageFolio() {
		return urlUploadImageFolio;
	}
	
	/**      
    *
    * Method setUrlUploadImageFolio.
    * Get the URL for the service MGBFTD01
    * 
    * @param String urlUploadImageFolio
    * 
    */
	public void setUrlUploadImageFolio(String urlUploadImageFolio) {
		this.urlUploadImageFolio = urlUploadImageFolio;
	}
	
  	/**      
    *
    * Method getUrlDepositQuery.
    * Get the URL for the service MGFBTH01
    * @return String value as parameter.
    *
    */
	public String getUrlDepositQuery() {
		return urlDepositQuery;
	}
	
	/**      
    *
    * Method setUrlDepositQuery.
    * Set the URL for the service MGFBTH01
    * 
    * @param String urlDepositQuery
    * 
    */
	public void setUrlDepositQuery(String urlDepositQuery) {
		this.urlDepositQuery = urlDepositQuery;
	}
	
  	/**      
    *
    * Method getUrlModifDeposit.
    * Get the URL for the service MGBFTH02
    * @return String value as parameter.
    *
    */
	public String getUrlModifDeposit() {
		return urlModifDeposit;
	}
	
	/**      
    *
    * Method setUrlModifDeposit.
    * Set the URL for the service MGBFTH02
    * 
    * @param String urlModifDeposit
    * 
    */
	public void setUrlModifDeposit(String urlModifDeposit) {
		this.urlModifDeposit = urlModifDeposit;
	}
	
  	/**      
    *
    * Method getUrlListArchivingDocuments.
    * Get the URL for the service (List Document-Archiving)
    * @return String value as parameter.
    *
    */
	public String getUrlListArchivingDocuments() {
		return urlListArchivingDocuments;
	}
	
	/**      
    *
    * Method setUrlListArchivingDocuments.
    * Set the URL for the service (List Document-Archiving)
    * 
    * @param String urlListArchivingDocuments
    * 
    */
	public void setUrlListArchivingDocuments(String urlListArchivingDocuments) {
		this.urlListArchivingDocuments = urlListArchivingDocuments;
	}
	
  	/**      
    *
    * Method getUrlSendArchivingDocuments.
    * Get the Url for the service (Send Document-Archiving)
    * @return String value as parameter.
    *
    */
	public String getUrlSendArchivingDocuments() {
		return urlSendArchivingDocuments;
	}
	
	/**      
    *
    * Method setUrlSendArchivingDocuments.
    * Set the URL for the service (Send Document-Archiving)
    * 
    * @param String urlSendArchivingDocuments
    * 
    */
	public void setUrlSendArchivingDocuments(String urlSendArchivingDocuments) {
		this.urlSendArchivingDocuments = urlSendArchivingDocuments;
	}
	
  	/**      
    *
    * Method getUrlConsultParameters.
    * Get the URL for the service MGBFTP01
    * @return String value as parameter.
    *
    */
	public String getUrlConsultParameters() {
		return urlConsultParameters;
	}
	
	/**      
    *
    * Method setUrlConsultParameters.
    * Set the URL for the service MGBFTP01
    * 
    * @param String urlConsultParameters
    * 
    */
	public void setUrlConsultParameters(String urlConsultParameters) {
		this.urlConsultParameters = urlConsultParameters;
	}
	
  	/**      
    *
    * Method getUrlListState.
    * Get the URL for the service (List state)
    * @return String value as parameter.
    *
    */
	public String getUrlListState() {
		return urlListState;
	}
	
	/**      
    *
    * Method setUrlListState.
    * Set the URL for the service (List state)
    * 
    * @param String urlListState
    * 
    */
	public void setUrlListState(String urlListState) {
		this.urlListState = urlListState;
	}
	
  	/**      
    *
    * Method getUrlListMunicipality.
    * Get the URL for the service (List Municipality)
    * @return String value as parameter.
    *
    */
	public String getUrlListMunicipality() {
		return urlListMunicipality;
	}
	
	/**      
    *
    * Method setUrlListMunicipality.
    * Set the URL for the service (List Municipality)
    * 
    * @param String urlListMunicipality
    * 
    */
	public void setUrlListMunicipality(String urlListMunicipality) {
		this.urlListMunicipality = urlListMunicipality;
	}
	
  	/**      
    *
    * Method getUrlAlerts.
    * Get the URL for the service MGBFTK01
    * @return String value as parameter.
    *
    */
	public String getUrlAlerts() {
		return urlAlerts;
	}
	
	/**      
    *
    * Method setUrlAlerts.
    * Set the URL for the service MGBFTK01
    * 
    * @param String urlAlertas
    * 
    */
	public void setUrlAlerts(String urlAlerts) {
		this.urlAlerts = urlAlerts;
	}
	
  	/**      
    *
    * Method getUrlLdapCreateScholar.
    * Get the URL for the service (Create Scholar-ldap)
    * @return String value as parameter.
    *
    */
	public String getUrlLdapCreateScholar() {
		return urlLdapCreateScholar;
	}
	
	/**      
    *
    * Method setUrlLdapCreateScholar.
    * Set the URL for the service (Create Scholar-ldap)
    * 
    * @param String urlLdapCreateScholar
    * 
    */
	public void setUrlLdapCreateScholar(String urlLdapCreateScholar) {
		this.urlLdapCreateScholar = urlLdapCreateScholar;
	}
	
  	/**      
    *
    * Method getUrlLdapGetStatusScholar.
    * Get the URL for the service (Get Status Scholar-ldap)
    * @return String value as parameter.
    *
    */
	public String getUrlLdapGetStatusScholar() {
		return urlLdapGetStatusScholar;
	}
	
	/**      
    *
    * Method setUrlLdapGetStatusScholar.
    * Set the URL for the service (Get Status Scholar-ldap)
    * 
    * @param String urlLdapGetStatusScholar
    * 
    */
	public void setUrlLdapGetStatusScholar(String urlLdapGetStatusScholar) {
		this.urlLdapGetStatusScholar = urlLdapGetStatusScholar;
	}
	
  	/**      
    *
    * Method getUrlLdapReactivationScholar.
    * Get the URL for the service (Reactivationa Scholar-ldap)
    * @return String value as parameter.
    *
    */
	public String getUrlLdapReactivationScholar() {
		return urlLdapReactivationScholar;
	}
	
	/**      
    *
    * Method setUrlLdapReactivationScholar.
    * Set the URL for the service (Reactivationa Scholar-ldap)
    * 
    * @param String urlLdapReactivationScholar
    * 
    */
	public void setUrlLdapReactivationScholar(String urlLdapReactivationScholar) {
		this.urlLdapReactivationScholar = urlLdapReactivationScholar;
	}
	
  	/**      
    *
    * Method getUrlUpdatePasswordScholar.
    * Get the URL for the service (Update Password Scholar-ldap)
    * @return String value as parameter.
    *
    */
	public String getUrlUpdatePasswordScholar() {
		return urlUpdatePasswordScholar;
	}
	
	/**      
    *
    * Method setUrlUpdatePasswordScholar.
    * Set the URL for the service (Update Password Scholar-ldap)
    * 
    * @param String urlUpdatePasswordScholar
    * 
    */
	public void setUrlUpdatePasswordScholar(String urlUpdatePasswordScholar) {
		this.urlUpdatePasswordScholar = urlUpdatePasswordScholar;
	}

	/**      
    *
    * Method getUrlApplicationCatalogos.
    * Get the URL for the service (Application Catalogos)
    * @return String value as parameter.
    *
    */
    public String getUrlApplicationCatalogs() {
        return urlApplicationCatalogs;
    }

    /**      
    *
    * Method setUrlApplicationCatalogos.
    * Set the URL for the service (Application Catalogos)
    * 
    * @param String urlApplicationCatalogos
    * 
    */
    public void setUrlApplicationCatalogs(String urlApplicationCatalogs) {
        this.urlApplicationCatalogs = urlApplicationCatalogs;
    }

    /**      
    *
    * Method getUrlUpdateBiography.
    * Get the URL for the service (Update Biography)
    * @return String value as parameter.
    *
    */
    public String getUrlUpdateBiography() {
        return urlUpdateBiography;
    }

    /**      
    *
    * Method setUrlUpdateBiography.
    * Set the URL for the service (Update Biography)
    * 
    * @param String urlUpdateBiography
    * 
    */
    public void setUrlUpdateBiography(String urlUpdateBiography) {
        this.urlUpdateBiography = urlUpdateBiography;
    }	
	
	
	
	
	
	
}