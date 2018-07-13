package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.GrantingTicketNoClientInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialNoClientGrantingTicketService;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.GrantingTicketUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;

/**
 * Class InitialNoClientGrantingTicketServiceImpl implements the InitialNoClientGrantingTicketService interface
 * Contains the implementations of method consultGrantingTicketNoClient to consume the service GrantingTicket for App75
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class InitialNoClientGrantingTicketServiceImpl implements InitialNoClientGrantingTicketService {
	private static final Logger log = Logger.getLogger(InitialNoClientGrantingTicketServiceImpl.class);


  	/**      
    *
    * Method consultGrantingTicketNoClient.
    * Contains the parameters for get the URL for the service GrantingTicket for App75, also get the Object for the request service.
    * @return HttpEntity<?> value as parameter, contains the headers and the body service response.
	*
    */
	@Override
	public ResponseEntity<?> consultGrantingTicketNoClient() {log.info("Inside consultGrantingTicketNoClient");
		ClassPathXmlApplicationContext context=null;
		GrantingTicketUtils grantingTicketUtils=null;
		GrantingTicketNoClientInDTO grantingTicketNoClientInDTO=null;
		ConsumerServiceImpl consumerServiceImpl=null;
		AsoUtils asoUtils=null;
		String urlGrantingTicket=null;
		ResponseEntity<?>response=null;
		try{
			context=SingletonApplicationContext.getInstance();
			grantingTicketUtils = (GrantingTicketUtils) context.getBean("gTUtils");
			grantingTicketNoClientInDTO = (GrantingTicketNoClientInDTO) context.getBean("gTNoCliInDTO");
			consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
			asoUtils = (AsoUtils) context.getBean("asoUtils");
			log.info("After Autoinstance - consultGrantingTicketNoClient");
			urlGrantingTicket = asoUtils.getUrlsAso(AsoUtils.INT_URL_NOCLIENT_GRANTINGTICKET);
			log.info("EndUrl-consultGrantingTicketNoClient = "+urlGrantingTicket);
			grantingTicketNoClientInDTO = grantingTicketUtils.getGrantingTicketNoClient();			
			response = consumerServiceImpl.restServiceConsume(HttpMethod.POST, urlGrantingTicket, grantingTicketNoClientInDTO, null);
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			context=null;
			grantingTicketUtils=null;
			grantingTicketNoClientInDTO=null;
			consumerServiceImpl=null;
			asoUtils=null;
			urlGrantingTicket=null;
		}
		return response;
		
	}

}
