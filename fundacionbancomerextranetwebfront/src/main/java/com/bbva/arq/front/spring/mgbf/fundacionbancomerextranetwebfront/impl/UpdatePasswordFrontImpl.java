package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.impl;

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
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.UpdatePasswordScholarBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UpdatePasswordScholarshipUserInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.UpdatePasswordFront;

/**
 * Class UpdatePasswordFrontImpl implements the UpdatePassword interface
 * Contains the implementations of the method getUploadImage to consume the service (Update Password-ldap)
 * This class contains the controller for service (Update Password-ldap)
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/scholar")
@Controller
public class UpdatePasswordFrontImpl implements UpdatePasswordFront {
	private static final Logger log = Logger.getLogger(UpdatePasswordFrontImpl.class);
	

  	/**      
    *
    * Method getUploadImage.
    * Contains the parameters for get the URL for the service (Update Password-ldap)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/updatepassword", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})@Override
	public ResponseEntity<?> updatePassword(@RequestBody String json,HttpServletRequest request) {
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		ObjectMapper mapper=null;
		UpdatePasswordScholarshipUserInDTO updatePasswordScholarshipUserInDTO=null;
		UpdatePasswordScholarBackImpl updatePasswordScholarBackImpl=null;
		ErrorDTO errorDTO = null;
		context=SingletonApplicationContext.getInstance();
		try{	
			request.getSession().setAttribute("tsec", null);
			log.info("Json received - Front = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			log.info("After Autoinstance - UpdatePasswordFrontImpl  ");
			updatePasswordScholarBackImpl = (UpdatePasswordScholarBackImpl) context.getBean("UpdatePassSchoBack"); 
			updatePasswordScholarshipUserInDTO = mapper.readValue(json, UpdatePasswordScholarshipUserInDTO.class);
			log.info("Pass Object Mapper  ");
			response = updatePasswordScholarBackImpl.updateArmed(updatePasswordScholarshipUserInDTO, request);
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
			updatePasswordScholarBackImpl = null;
			errorDTO = null;
		}
		return response;
	}

}
