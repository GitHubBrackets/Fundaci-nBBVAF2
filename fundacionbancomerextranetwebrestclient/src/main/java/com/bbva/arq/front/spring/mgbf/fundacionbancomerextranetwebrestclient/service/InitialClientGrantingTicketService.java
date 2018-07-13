package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.ResponseEntity;

/**
 * Interface InitialClientGrantingTicketService. 
 * Contains consultGrantingTicketClient method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialClientGrantingTicketService {

 	/**
    *
    * Method consultGrantingTicketClient
    * @return one HttpEntity<?> value as parameter.
	*
    */
	public ResponseEntity<?> consultGrantingTicketClient();
	
}
