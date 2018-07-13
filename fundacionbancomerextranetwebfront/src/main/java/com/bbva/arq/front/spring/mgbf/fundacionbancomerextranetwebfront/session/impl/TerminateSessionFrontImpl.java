package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.session.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.sendArchivingDocumentsIn.DocumentDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.session.TerminateSessionFront;

/**
 * Class TerminateSessionImpl implements the TerminateSession interface
 * Contains the implementations of the method caducaSession) 
 * This class contains the controller for service invalidate session
 * 
 * @author Diego Espinoza
 * @version 05 december 2017
 */

@Controller
@RequestMapping("/terminate")
public class TerminateSessionFrontImpl implements TerminateSessionFront {
	private static final Logger log = Logger.getLogger(TerminateSessionFrontImpl.class);
	
  	/**      
    *
    * Method expireSession.
    * This method terminate the session.
    * @return ResponseEntity<?> value as parameter.
    *
    * @param HttpServletRequest request
	*
    */
	@RequestMapping(value = "/session", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON})@Override
	public ResponseEntity<?> expireSession(HttpServletRequest request) {
		log.info("Inside of expireSession");	
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		DocumentDTO docDTO=null;
		
		context=SingletonApplicationContext.getInstance();
		docDTO = (DocumentDTO) context.getBean("DocDTO");
		docDTO.setData("ok");
				
		request.getSession().invalidate();
		SingletonApplicationContext.closeContext((ClassPathXmlApplicationContext) context);
		
		response = new ResponseEntity<DocumentDTO>(docDTO, HttpStatus.OK);

		return response;
	}

}
