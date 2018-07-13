package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.GrantingTicketClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.GrantingTicketNoClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinclient.GrantingTicketAuthenticationClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinclient.GrantingTicketAuthenticationDataClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinclient.GrantingTicketAuxClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinclient.GrantingTicketBackendUserRequestClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinnoclient.GrantingTicketAuthenticationNoClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinnoclient.GrantingTicketAuthenticatonDataNoClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinnoclient.GrantingTicketAuxNoClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.grantingticketinnoclient.GrantingTicketBackendUserRequestNoClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;

/**
 * Class GrantingTicketUtils
 * Contains the methods (getGrantingTicketClient and getGrantingTicketNoClient).
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public class GrantingTicketUtils {
	private static final Logger log = Logger.getLogger(GrantingTicketUtils.class);
	
  	/**      
    *
    * Method getGrantingTicketClient.
    * contains the necessary values for the service GrantingTicket for (App74)
    * @return GrantingTicketClientInDTO object. 
    *
    */
	public GrantingTicketClientInDTO getGrantingTicketClient(){log.info("Inside getGrantingTicketClient");
		ServletRequestAttributes request = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
				
		ClassPathXmlApplicationContext context=null;
		GrantingTicketAuxClientInDTO grantingTicketAuxClientInDTO=null;
		GrantingTicketClientInDTO grantingTicketClientDTO=null;
		GrantingTicketAuthenticationClientInDTO grantingTicketAuthenticationClientInDTO=null;
		GrantingTicketAuthenticationDataClientInDTO grantingTicketAuthenticationDataClientInDTO =null;
		GrantingTicketBackendUserRequestClientInDTO grantingTicketBackendUserRequestClientInDTO=null;
		List<String> audata=null;
		List<GrantingTicketAuthenticationDataClientInDTO> gtaudata=null;
		try{
			context=SingletonApplicationContext.getInstance();
			context.refresh();
		    grantingTicketAuxClientInDTO = (GrantingTicketAuxClientInDTO) context.getBean("valoresGrantingTicketClient");
	    	grantingTicketClientDTO = (GrantingTicketClientInDTO) context.getBean("gTClientDTO");
			grantingTicketAuthenticationClientInDTO = (GrantingTicketAuthenticationClientInDTO) context.getBean("gTAuthenCliInDTO");
			grantingTicketAuthenticationDataClientInDTO = (GrantingTicketAuthenticationDataClientInDTO) context.getBean("gTAuthenDataCliInDTO");
			grantingTicketBackendUserRequestClientInDTO = (GrantingTicketBackendUserRequestClientInDTO) context.getBean("gTUserReqCliInDTO");	    	
			grantingTicketAuthenticationDataClientInDTO.setIdAuthenticationData(grantingTicketAuxClientInDTO.getIdAuthenticationData());
			audata = new ArrayList<String>();
			audata.add(request.getRequest().getSession().getAttribute("iv-ticketservice").toString());
			grantingTicketAuthenticationDataClientInDTO.setAuthenticationData(audata);
			grantingTicketAuthenticationClientInDTO.setUserID(request.getRequest().getSession().getAttribute("iv-user").toString());
			grantingTicketAuthenticationClientInDTO.setConsumerID(grantingTicketAuxClientInDTO.getConsumerID());
			grantingTicketAuthenticationClientInDTO.setAuthenticationType(grantingTicketAuxClientInDTO.getAuthenticationType());
			gtaudata = new ArrayList<GrantingTicketAuthenticationDataClientInDTO>();  
			gtaudata.add(grantingTicketAuthenticationDataClientInDTO);
			grantingTicketAuthenticationClientInDTO.setAuthenticationData(gtaudata);
			grantingTicketBackendUserRequestClientInDTO.setUserId(grantingTicketAuxClientInDTO.getUserId());
			grantingTicketBackendUserRequestClientInDTO.setAccessCode(grantingTicketAuxClientInDTO.getAccessCode());
			grantingTicketBackendUserRequestClientInDTO.setDialogId(grantingTicketAuxClientInDTO.getDialogId());
			grantingTicketClientDTO.setAuthentication(grantingTicketAuthenticationClientInDTO);
			grantingTicketClientDTO.setBackendUserRequest(grantingTicketBackendUserRequestClientInDTO);
			log.info("grantingTicketClientDTO formed");
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context=null;
			grantingTicketAuxClientInDTO=null;
			grantingTicketAuthenticationClientInDTO=null;
			grantingTicketAuthenticationDataClientInDTO =null;
			grantingTicketBackendUserRequestClientInDTO=null;
			audata=null;
			gtaudata=null;
		}
    	return grantingTicketClientDTO;
	}
	
  	/**      
    *
    * Method getGrantingTicketClient.
    * contains the necessary values for the service getGrantingTicketNoClient for (App75)
    * @return grantingTicketNoClientDTO object. 
    *
    */
	public GrantingTicketNoClientInDTO getGrantingTicketNoClient(){log.info("Inside getGrantingTicketNoClient");
		ClassPathXmlApplicationContext context=null;
		GrantingTicketAuxNoClientInDTO grantingTicketAuxNoClientInDTO=null;
		GrantingTicketNoClientInDTO grantingTicketNoClientDTO=null;
		GrantingTicketAuthenticationNoClientInDTO grantingTicketAuthenticationInDTO=null;
		GrantingTicketAuthenticatonDataNoClientInDTO grantingTicketAuthenticatonDataInDTO =null;
		GrantingTicketBackendUserRequestNoClientInDTO grantingTicketBackendUserRequestInDTO=null;
		List<String> audata=null;
		List<GrantingTicketAuthenticatonDataNoClientInDTO> gtaudata=null;
		try{
			context=SingletonApplicationContext.getInstance();
			context.refresh();
		    grantingTicketAuxNoClientInDTO = (GrantingTicketAuxNoClientInDTO) context.getBean("valuesGrantingTicketNoClient");
		    grantingTicketNoClientDTO =  (GrantingTicketNoClientInDTO) context.getBean("gTNoCliInDTO");
		    grantingTicketAuthenticationInDTO =  (GrantingTicketAuthenticationNoClientInDTO) context.getBean("gTAuthenNoCliInDTO");
		    grantingTicketAuthenticatonDataInDTO =  (GrantingTicketAuthenticatonDataNoClientInDTO) context.getBean("gTAuthenDataNoCliInDTO");
		    grantingTicketBackendUserRequestInDTO =  (GrantingTicketBackendUserRequestNoClientInDTO) context.getBean("gTUserReqNoCliInDTO");
	    			    
	    	grantingTicketAuthenticatonDataInDTO.setIdAuthenticationData(grantingTicketAuxNoClientInDTO.getIdAuthenticationData());
	    	audata = new ArrayList<String>();     		
	    	audata.add(grantingTicketAuxNoClientInDTO.getAuthenticationData().toString());
			grantingTicketAuthenticatonDataInDTO.setAuthenticationData(audata);
			grantingTicketAuthenticationInDTO.setUserID(grantingTicketAuxNoClientInDTO.getUserID());
			grantingTicketAuthenticationInDTO.setConsumerID(grantingTicketAuxNoClientInDTO.getConsumerID());
			grantingTicketAuthenticationInDTO.setAuthenticationType(grantingTicketAuxNoClientInDTO.getAuthenticationType());
			gtaudata = new ArrayList<GrantingTicketAuthenticatonDataNoClientInDTO>(); 
			gtaudata.add(grantingTicketAuthenticatonDataInDTO);
			grantingTicketAuthenticationInDTO.setAuthenticationData(gtaudata);
			grantingTicketBackendUserRequestInDTO.setUserId(grantingTicketAuxNoClientInDTO.getUserId());
			grantingTicketBackendUserRequestInDTO.setAccessCode(grantingTicketAuxNoClientInDTO.getAccessCode());
			grantingTicketBackendUserRequestInDTO.setDialogId(grantingTicketAuxNoClientInDTO.getDialogId());
			grantingTicketNoClientDTO.setAuthentication(grantingTicketAuthenticationInDTO);
			grantingTicketNoClientDTO.setBackendUserRequest(grantingTicketBackendUserRequestInDTO);
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context=null;
			grantingTicketAuxNoClientInDTO=null;
			grantingTicketAuthenticationInDTO=null;
			grantingTicketAuthenticatonDataInDTO =null;
			grantingTicketBackendUserRequestInDTO=null;
			audata=null;
			gtaudata=null;
		}
		return grantingTicketNoClientDTO;
	}
	

}
