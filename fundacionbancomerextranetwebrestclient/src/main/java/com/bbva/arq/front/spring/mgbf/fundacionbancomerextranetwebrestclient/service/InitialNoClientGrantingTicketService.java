package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service;

import org.springframework.http.ResponseEntity;

/**
 * Interface InitialNoClientGrantingTicketService. 
 * Contains consultGrantingTicketNoClient method.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface InitialNoClientGrantingTicketService {
	
 	/**
    *
    * Method consultGrantingTicketNoClient
    * @return one HttpEntity<?> value as parameter.
	*
    */
	public ResponseEntity<?> consultGrantingTicketNoClient();

}
