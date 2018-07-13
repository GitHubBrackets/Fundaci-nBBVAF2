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
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.ModUploadSchoolarBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ModUploadDataScholarInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ModUploadSchoolarFront;

/**
 * Class ModUploadSchoolarFrontImpl implements the ModUploadSchoolarFront interface
 * Contains the implementations of the method getModUploadSchoolar to consume the service MGBFTB02
 * This class contains the controller for service MGBFTB02
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/modif")
@Controller
public class ModUploadSchoolarFrontImpl implements ModUploadSchoolarFront{
	private static final Logger log = Logger.getLogger(ModUploadSchoolarFrontImpl.class);

  	/**      
    *
    * Method getModUploadSchoolar.
    * Contains the parameters for get the URL for the service MGBFTB02
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/uploadSchoolar", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public ResponseEntity<?> getModUploadSchoolar(@RequestBody String json, HttpServletRequest request) {log.info("Inside getModUploadSchoolar");
		ClassPathXmlApplicationContext context = null;
		ResponseEntity<?> response = null;
		ObjectMapper mapper = null;
		ModUploadDataScholarInDTO modUploadDataScholarInDTO = null;
		ModUploadSchoolarBackImpl modUploadSchoolarBackImpl = null;
		ErrorDTO errorDTO = null;
		context=SingletonApplicationContext.getInstance();
		try{
			log.info("Json Send by index = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			modUploadSchoolarBackImpl = (ModUploadSchoolarBackImpl) context.getBean("ModUplSchoBack");
			log.info("After Autoinstance - getModUploadSchoolar");
			modUploadDataScholarInDTO = mapper.readValue(json, ModUploadDataScholarInDTO.class);
			log.info("After Mapper_FRONT-getModUploadSchoolar = ");
			response = modUploadSchoolarBackImpl.modUploadSchoolarArmed(modUploadDataScholarInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			mapper = null;
			modUploadDataScholarInDTO = null;
			modUploadSchoolarBackImpl = null;
			errorDTO = null;
			context = null;
		}
		return response;	
	}

}
