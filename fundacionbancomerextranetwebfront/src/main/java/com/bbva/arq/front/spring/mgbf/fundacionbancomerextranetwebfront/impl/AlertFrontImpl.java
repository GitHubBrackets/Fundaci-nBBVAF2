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

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.AlertBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.AlertInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.AlertFront;

/**
 * Class AlertFrontImpl implements the AlertFront interface
 * Contains the implementations of the method alerts to consume the service MGBFTK01
 * This class contains the controller for service MGBFTK01
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/aler")
@Controller
public class AlertFrontImpl implements AlertFront {
	private static final Logger log = Logger.getLogger(AlertFrontImpl.class);

  	/**      
    *
    * Method alerts.
    * Contains the parameters for get the URL for the service MGBFTK01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/alerts", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})@Override
	public ResponseEntity<?> alerts(@RequestBody String json,HttpServletRequest request) {log.info("Inside alerts");
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		ObjectMapper mapper=null;
		AlertInDTO alertInDTO=null;
		AlertBackImpl alertBackImpl=null;
		ErrorDTO errorDTO = null;
		context=SingletonApplicationContext.getInstance();
		try{	
			log.info("Json Send by index = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			alertBackImpl = (AlertBackImpl) context.getBean("alertBack");
			log.info("After Autoinstance - alerts");
			alertInDTO = mapper.readValue(json, AlertInDTO.class);
			log.info("After Mapper_FRONT-alerts");
			response = alertBackImpl.alertArmed(alertInDTO, request);
			
			log.info("response FRONTTTT = "+response);
			
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			context = null;
			mapper = null;
			alertInDTO=null;
			alertBackImpl=null;
			errorDTO = null;
		}

		return response;
	}

}
