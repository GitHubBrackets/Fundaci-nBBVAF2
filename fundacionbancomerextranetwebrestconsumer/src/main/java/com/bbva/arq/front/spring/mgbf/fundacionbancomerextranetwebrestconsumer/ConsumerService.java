package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


/**
 * Interface ConsumerService. 
 * Contains two overloaded methods with different parameters,
 * Interface that contains the methods to consume the services.
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public interface ConsumerService {

  	/**
    *
    * Overloaded restServiceConsume method
    * @return HttpEntity<String> value as parameter contains the headers and the body service response.
    *
    * @param HttpMethod method
    * @param String url
    * @param Object object
    * @param HttpHeaders headers
    * 
    */
	public ResponseEntity<?> restServiceConsume(HttpMethod method, String url, Object object, HttpHeaders headers);
	
	/**
    *
    * Overloaded restServiceConsume method
    * Returns HttpEntity<String> value as parameter, contains the headers and the body service response.
    *
    * @param HttpMethod method
    * @param String url
    * @param HttpHeaders headers
    * @param String calCambChar
    * 
    */
	public ResponseEntity<?> restServiceConsume(HttpMethod method, String url, HttpHeaders headers, String calCambChar);

}
