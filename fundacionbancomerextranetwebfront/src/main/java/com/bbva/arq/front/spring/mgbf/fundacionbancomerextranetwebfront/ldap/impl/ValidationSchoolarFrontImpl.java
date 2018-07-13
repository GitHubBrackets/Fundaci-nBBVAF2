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
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ldap.impl.ValidationScholarBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ValidationscholarInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ldap.ValidationSchoolarFront;

/**
 * Class ValidationSchoolarFrontImpl implements the ValidationSchoolarFront interface
 * Contains the implementations of the method getValidationScholar to consume the service MGBFTL01
 * This class contains the controller for service MGBFTL01
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/validation")
@Controller
public class ValidationSchoolarFrontImpl implements ValidationSchoolarFront {
	private static final Logger log = Logger.getLogger(ValidationSchoolarFrontImpl.class);
	
  	/**      
    *
    * Method getValidationScholar.
    * Contains the parameters for get the URL for the service MGBFTL01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
	value = "/scholar", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public @ResponseBody ResponseEntity<?> getValidationScholar(@RequestBody String json, HttpServletRequest request) {log.info("Inside getValidationScholar");
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		ObjectMapper mapper = null;
		ValidationscholarInDTO validationscholarInDTO = null;
		ValidationScholarBackImpl validationScholarBackImlp = null;
		ErrorDTO errorDTO = null;
		try{
			context=SingletonApplicationContext.getInstance();
			log.info("Json Send by index = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");	
			validationscholarInDTO = (ValidationscholarInDTO) context.getBean("validSchoInDTO");
			validationScholarBackImlp = (ValidationScholarBackImpl) context.getBean("ValidSchoBack");
			log.info("After Autoinstance - getValidationScholar");
			validationscholarInDTO = mapper.readValue(json, ValidationscholarInDTO.class);
			log.info("After Mapper_FRONT-getValidationScholar ");
			response = validationScholarBackImlp.validationScholarArmed(validationscholarInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.toString());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			request.getSession().setAttribute("tsec", null);
			mapper = null;
			validationscholarInDTO = null;
			validationScholarBackImlp = null;
			errorDTO = null;
			context=null;
		}
		return response;
	}

}
