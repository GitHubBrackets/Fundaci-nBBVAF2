package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ldap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

/**
 * Interface IdapScholarShip. 
 * Contains the methods (createScholar - getStatusScholar - reactivationScholar - updatePasswordScholar)
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
public interface LdapScholarShipFront {
	
 	/**
    *
    * Method createScholar
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> createScholar(String json,  HttpServletRequest request);
	
 	/**
    *
    * Method getStatusScholar
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> getStatusScholar(String json,  HttpServletRequest request);
	
 	/**
    *
    * Method reactivationScholar
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> reactivationScholar(String json,  HttpServletRequest request);
	
 	/**
    *
    * Method updatePasswordScholar
    * @return ResponseEntity<?> value as parameter.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	public ResponseEntity<?> updatePasswordScholar(String json,  HttpServletRequest request);

}
