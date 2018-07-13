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
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.UploadQualificationBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UploadQualificationsInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.UploadQualificationFront;

/**
 * Class UploadQualificationFrontImpl implements the UploadQualificationFront interface
 * Contains the implementations of the method getUploadQualification to consume the service MGBFTC01
 * This class contains the controller for service MGBFTC01
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/update")
@Controller
public class UploadQualificationFrontImpl implements UploadQualificationFront {
	private static final Logger log = Logger.getLogger(UploadQualificationFrontImpl.class);
	

  	/**      
    *
    * Method getUploadQualification.
    * Contains the parameters for get the URL for the service MGBFTC01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/qualification", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public ResponseEntity<?> getUploadQualification(@RequestBody String json, HttpServletRequest request) {log.info("Inside getUploadQualification");
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		ObjectMapper mapper = null;
		UploadQualificationsInDTO uploadQualificationsInDTO = null;
		UploadQualificationBackImpl uploadQualificationBackImpl = null;
		ErrorDTO errorDTO = null;
		context=SingletonApplicationContext.getInstance();
		try{
			log.info("Json Send by index = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			uploadQualificationBackImpl = (UploadQualificationBackImpl) context.getBean("uploadQualifBack");
			log.info("After Autoinstance - getUploadQualification");
			uploadQualificationsInDTO = mapper.readValue(json, UploadQualificationsInDTO.class);
			log.info("After Mapper_FRONT-getUploadQualification = ");
			response = uploadQualificationBackImpl.uploadQualificationArmed(uploadQualificationsInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			context=null;
			mapper = null;
			uploadQualificationsInDTO = null;
			uploadQualificationBackImpl = null;
			errorDTO = null;
		}
		return response;
	}

}
