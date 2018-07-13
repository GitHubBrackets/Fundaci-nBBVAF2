package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ldap.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.impl.LdapCreateScholarBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.impl.LdapGetStatusScholarBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.impl.LdapReactivationScholarBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.impl.LdapUpdatePasswordScholarBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.CreateScholarshipUserInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.GetStatusScholarshipUserInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.RequestReactivationaScholarshipUserInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UpdatePasswordScholarshipUserInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ldap.LdapScholarShipFront;

/**
 * Class IdapScholarFrontShipImpl implements the IdapScholarShip interface
 * Contains the implementations of the method createScholar to consume the service (Create scholar-ldap)
 * This class contains the controller for service (Create scholar-ldap)
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/ldapScholar")
@Controller
public class LdapScholarFrontShipImpl implements LdapScholarShipFront {
	private static final Logger log = Logger.getLogger(LdapScholarFrontShipImpl.class);

  	/**      
    *
    * Method createScholar.
    * Contains the parameters for get the URL for the service (Create scholar-ldap)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/create", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})@Override
	public ResponseEntity<?> createScholar(@RequestBody String json,HttpServletRequest request) {
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		ObjectMapper mapper=null;
		CreateScholarshipUserInDTO CreateScholarshipUserInDTO=null;
		LdapCreateScholarBackImpl ldapCreateScholarBackImpl=null;
		ErrorDTO errorDTO = null;
		context=SingletonApplicationContext.getInstance();
		try{	
			request.getSession().setAttribute("tsec", null);
			log.info("Json received - Front = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			log.info("After Autoinstance - ArchivingDocumentsFrontImpl = ");
			ldapCreateScholarBackImpl = (LdapCreateScholarBackImpl) context.getBean("ldapCreaSchoBack");
			CreateScholarshipUserInDTO = mapper.readValue(json, CreateScholarshipUserInDTO.class);
			log.info("Pass Object Mapper = ");
			response = ldapCreateScholarBackImpl.ldapCreateArmed(CreateScholarshipUserInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.toString());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			request.getSession().setAttribute("tsec", null);
			context.close();
			context = null;
			mapper = null;
			CreateScholarshipUserInDTO = null;
			ldapCreateScholarBackImpl = null;
			errorDTO = null;
		}
		return response;
	}

	
	@RequestMapping( 
			value = "/getstatus", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})@Override
	public ResponseEntity<?> getStatusScholar(@RequestBody String json,HttpServletRequest request) {
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		ObjectMapper mapper=null;
		GetStatusScholarshipUserInDTO getStatusScholarshipUserInDTO=null;
		LdapGetStatusScholarBackImpl ldapGetStatusScholarBackImpl=null;
		ErrorDTO errorDTO = null;
		try{	
			context=SingletonApplicationContext.getInstance();
			request.getSession().setAttribute("tsec", null);			
			log.info("Json received - Front = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			log.info("After Autoinstance - ArchivingDocumentsFrontImpl = ");
			ldapGetStatusScholarBackImpl = (LdapGetStatusScholarBackImpl) context.getBean("ldapGetStatSchoBack");
			getStatusScholarshipUserInDTO = mapper.readValue(json, GetStatusScholarshipUserInDTO.class);
			log.info("Pass Object Mapper = ");
			response = ldapGetStatusScholarBackImpl.ldapGetStatusArmed(getStatusScholarshipUserInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.toString());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			request.getSession().setAttribute("tsec", null);
			context = null;
			mapper = null;
			getStatusScholarshipUserInDTO = null;
			ldapGetStatusScholarBackImpl = null;
			errorDTO = null;
		}
		return response;
	}

	
	@RequestMapping( 
			value = "/reactivation", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})@Override
	public ResponseEntity<?> reactivationScholar(@RequestBody String json,HttpServletRequest request) {
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		ObjectMapper mapper=null;
		RequestReactivationaScholarshipUserInDTO requestReactivationaScholarshipUserInDTO=null;
		LdapReactivationScholarBackImpl ldapReactivationScholarBackImpl=null;
		ErrorDTO errorDTO = null;
		try{	
			context=SingletonApplicationContext.getInstance();
			request.getSession().setAttribute("tsec", null);
			log.info("Json received - Front = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			log.info("After Autoinstance - ArchivingDocumentsFrontImpl = ");
			ldapReactivationScholarBackImpl = (LdapReactivationScholarBackImpl) context.getBean("ldapReactivaSchoBack");
			requestReactivationaScholarshipUserInDTO = mapper.readValue(json, RequestReactivationaScholarshipUserInDTO.class);
			log.info("Pass Object Mapper = ");
			response = ldapReactivationScholarBackImpl.ldapReactivationArmed(requestReactivationaScholarshipUserInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.toString());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			request.getSession().setAttribute("tsec", null);
			context = null;
			mapper = null;
			requestReactivationaScholarshipUserInDTO = null;
			ldapReactivationScholarBackImpl = null;
			errorDTO = null;
		}
		return response;
	}

	
	@RequestMapping( 
			value = "/updatepassword", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})@Override
	public ResponseEntity<?> updatePasswordScholar(@RequestBody String json,HttpServletRequest request) {		
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		ObjectMapper mapper=null;
		UpdatePasswordScholarshipUserInDTO updatePasswordScholarshipUserInDTO=null;
		LdapUpdatePasswordScholarBackImpl ldapUpdatePasswordScholarBackImpl=null;
		ErrorDTO errorDTO = null;
		try{	
			context=SingletonApplicationContext.getInstance();
			request.getSession().setAttribute("tsec", null);
			log.info("Json received - Front = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			log.info("After Autoinstance - ArchivingDocumentsFrontImpl  ");
			ldapUpdatePasswordScholarBackImpl = (LdapUpdatePasswordScholarBackImpl) context.getBean("ldapUpdatePassSchoBack");
			updatePasswordScholarshipUserInDTO = mapper.readValue(json, UpdatePasswordScholarshipUserInDTO.class);
			log.info("Pass Object Mapper  ");
			response = ldapUpdatePasswordScholarBackImpl.ldapUpdateArmed(updatePasswordScholarshipUserInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.toString());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			request.getSession().setAttribute("tsec", null);
			context = null;
			mapper = null;
			updatePasswordScholarshipUserInDTO = null;
			ldapUpdatePasswordScholarBackImpl = null;
			errorDTO = null;
		}
		return response;
	}



}
