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
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.ConsultParametersBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ConsultParametersInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ConsultParametersFront;

/**
 * Class ConsultParametersFrontImpl implements the ConsultParametersFront interface
 * Contains the implementations of the method listArchivingDocuments to consume the service MGBFTP01
 * This class contains the controller for service MGBFTP01
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/consult")
@Controller
public class ConsultParametersFrontImpl implements ConsultParametersFront {
	private static final Logger log = Logger.getLogger(ConsultParametersFrontImpl.class);

  	/**      
    *
    * Method listArchivingDocuments.
    * Contains the parameters for get the URL for the service MGBFTP01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/parameters", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public ResponseEntity<?> listArchivingDocuments(@RequestBody String json, HttpServletRequest request) {log.info("Inside listArchivingDocuments");
	log.info("TSEC = "+request.getSession().getAttribute("tsec"));
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context=null;
		ObjectMapper mapper=null;
		ConsultParametersInDTO consultParametersInDTO=null;
		ConsultParametersBackImpl consultParametersBackImpl=null;
		ErrorDTO errorDTO = null;
		context=SingletonApplicationContext.getInstance();
		try{
			log.info("Json Send by index = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			consultParametersBackImpl = (ConsultParametersBackImpl) context.getBean("consultParametersBack");
			log.info("After Autoinstance - listArchivingDocuments");
			consultParametersInDTO = mapper.readValue(json, ConsultParametersInDTO.class);
			log.info("After Mapper_FRONT-listArchivingDocuments = ");
			response = consultParametersBackImpl.consultParametersArmed(consultParametersInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			context = null;
			mapper = null;
			consultParametersInDTO = null;
			consultParametersBackImpl=null;
			errorDTO = null;
		}
		
		return response;
	}

}
