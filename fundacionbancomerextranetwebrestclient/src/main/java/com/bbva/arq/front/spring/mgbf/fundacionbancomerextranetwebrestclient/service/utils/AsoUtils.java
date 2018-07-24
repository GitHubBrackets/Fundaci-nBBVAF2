package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UrlASOUtilsDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;

/**
 * Class AsoUtils
 * Contains the methods (getUrlsAso).
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public class AsoUtils {
	private static final Logger log = Logger.getLogger(AsoUtils.class);
	
	//GrantingTicket App74
	public static final int  INT_URL_CLIENT_GRANTINGTICKET = 1;	
	//GrantingTicket App75
	public static final int  INT_URL_NOCLIENT_GRANTINGTICKET = 2;	
	//MGBFTL01
	public static final int  INT_URL_VALIDATE_SCHOLAR = 3; 	
	//MGBFTB02
	public static final int  INT_URL_MOD_UPLOAD_SCHOLAR= 4;		
	//MGBFTB04
	public static final int  INT_URL_CONSULT_LEVEL_AND_GRADE_SCHOLAR= 5;
	//MGBFTC01
	public static final int  INT_URL_UPLOAD_QUALIFICATION= 6;
	//MGBFTC02
	public static final int  INT_URL_QUALIFICATION_QUERY= 7;
	//MGBFTC03
	public static final int  INT_URL_AVERAGES_QUERY= 8;		
	//MGBFTB03
	public static final int  INT_URL_DETAIL_SCHOLAR= 9;			
	//MGBFTD01
	public static final int  INT_URL_UPLOAD_IMAGE_FOLIO= 10;		
	//MGFBTH01
	public static final int  INT_URL_DEPOSIT_QUERY= 11;		
	//MGBFTH02
	public static final int  INT_URL_MODIF_DEPOSIT= 12;			
	//[Archiving Lista de documentos]
	public static final int  INT_URL_LIST_ARCHIVING_DOCUMENTS= 13;	
	//[Archiving envio de documentos]
	public static final int  INT_URL_SEND_ARCHIVING_DOCUMENTS= 14; 
	//MGBFTP01
	public static final int  INT_URL_CONSULT_PARAMETERS= 15;    
	//[Obtiene lista de estados]
	public static final int  INT_URL_LIST_STATE= 16; 
	//[Obtiene lista de municipioa]
	public static final int  INT_URL_LIST_MUNICIPALITY= 17;	
	//MGBFTK01
	public static final int  INT_URL_ALERTS= 18;			
	//[LDAP Crea becario con App 75]
	public static final int  URL_LDAP_CREATE_SCHOLAR= 19;	
	//[LDAP obtiene estatus del becario con App 75]        
	public static final int  URL_LDAP_GETSTATUS_SCHOLAR= 20;	
	//[LDAP Reactiva becario con App 75]
	public static final int  URL_LDAP_REACTIVATION_SCHOLAR= 21;	
	//[LDAP Crear Actualiza contrasenia del becario con App 75 y App 74]
	public static final int  URL_LDAP_UPDATEPASSWORD_SCHOLAR= 22;
	//Application Catalogs
	public static final int  INT_URL_APPLICATION_CATALOGS= 23;    
	//Update Biography
	public static final int  INT_URL_UPDATE_BIOGRAPHY= 24;
	
  	/**      
    *
    * Method getUrlsAso.
    * Contains the necessary cases to obtain the URL of each of the services
    * @return String value as parameter, Contains the requested service URL
    *
    * @param int service
	*
    */
	public String getUrlsAso(int service){
		String url = null;		
		ClassPathXmlApplicationContext context =null;
    	UrlASOUtilsDTO urlASOUtils = null;
		try{
			url = null;		
			context=SingletonApplicationContext.getInstance();
	    	urlASOUtils = (UrlASOUtilsDTO) context.getBean("urlASO");
	    	context.close();	    		
		    switch (service) {
				case INT_URL_CLIENT_GRANTINGTICKET:
					url = urlASOUtils.getUrlGrantingTicketClient();
					break;
				case INT_URL_NOCLIENT_GRANTINGTICKET:
					 url = urlASOUtils.getUrlGrantingTicketNoClient();
					break;
				case INT_URL_VALIDATE_SCHOLAR:
					url = urlASOUtils.getUrlValidateScholar();
					break;
				case INT_URL_MOD_UPLOAD_SCHOLAR:
					url = urlASOUtils.getUrlModUploadScholar();
					break;
				case INT_URL_CONSULT_LEVEL_AND_GRADE_SCHOLAR:
					url = urlASOUtils.getUrlConsultLevelAndGradeCholar();
					break;
				case INT_URL_UPLOAD_QUALIFICATION:
					url = urlASOUtils.getUrlUploadQualification();
					break;
				case INT_URL_QUALIFICATION_QUERY:
					url = urlASOUtils.getUrlQualificationQuery();
					break;
				case INT_URL_AVERAGES_QUERY:
					url = urlASOUtils.getUrlAveragesQuery();
					break;
				case INT_URL_DETAIL_SCHOLAR:
					url = urlASOUtils.getUrlDetailScholar();
					break;
				case INT_URL_UPLOAD_IMAGE_FOLIO:
					url = urlASOUtils.getUrlUploadImageFolio();
					break;
				case INT_URL_DEPOSIT_QUERY:
					url = urlASOUtils.getUrlDepositQuery();
					break;
				case INT_URL_MODIF_DEPOSIT:
					url = urlASOUtils.getUrlModifDeposit();
					break;
				case INT_URL_LIST_ARCHIVING_DOCUMENTS:
					url = urlASOUtils.getUrlListArchivingDocuments();
					break;
				case INT_URL_SEND_ARCHIVING_DOCUMENTS:
					url = urlASOUtils.getUrlSendArchivingDocuments();
					break;
				case INT_URL_CONSULT_PARAMETERS:
					url = urlASOUtils.getUrlConsultParameters();
					break;
				case INT_URL_LIST_STATE:
					url = urlASOUtils.getUrlListState();
					break;
				case INT_URL_LIST_MUNICIPALITY:
					url = urlASOUtils.getUrlListMunicipality();
					break;	
				case INT_URL_ALERTS:
					url = urlASOUtils.getUrlAlerts();
					break;
				case URL_LDAP_CREATE_SCHOLAR:
					url = urlASOUtils.getUrlLdapCreateScholar();
					break;
				case URL_LDAP_GETSTATUS_SCHOLAR:
					url = urlASOUtils.getUrlLdapGetStatusScholar();
					break;
				case URL_LDAP_REACTIVATION_SCHOLAR:
					url = urlASOUtils.getUrlLdapReactivationScholar();
					break;
				case URL_LDAP_UPDATEPASSWORD_SCHOLAR:
					url = urlASOUtils.getUrlUpdatePasswordScholar();
					break;
                case INT_URL_APPLICATION_CATALOGS:
                    url = urlASOUtils.getUrlApplicationCatalogs();
                    break;
                case INT_URL_UPDATE_BIOGRAPHY:
                    url = urlASOUtils.getUrlUpdateBiography();
                    break;
				default:
					break;
			}
		    log.info("Url-AsoUtils = "+url);
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
		    context =null;
	    	urlASOUtils = null;
		}		    
		return url;	
	}
	
}

