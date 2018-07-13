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
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.UploadImageFolioBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UploadImageFolioInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.UploadImageFolioFront;

/**
 * Class UploadImageFolioFrontImpl implements the UploadImageFolioFront interface
 * Contains the implementations of the method getUploadImage to consume the service MGBFTD01
 * This class contains the controller for service MGBFTD01
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/upload")
@Controller
public class UploadImageFolioFrontImpl implements UploadImageFolioFront {
	private static final Logger log = Logger.getLogger(UploadImageFolioFrontImpl.class);
	

  	/**      
    *
    * Method getUploadImage.
    * Contains the parameters for get the URL for the service MGBFTD01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/image", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public ResponseEntity<?> getUploadImage(@RequestBody String json, HttpServletRequest request) {log.info("Inside getUploadImage");
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		ObjectMapper mapper =null;
		UploadImageFolioInDTO uploadImageFolioInDTO =null;
		UploadImageFolioBackImpl uploadImageFolioBackImpl = null;
		ErrorDTO errorDTO = null;
		context=SingletonApplicationContext.getInstance();
		try{
			log.info("Json Send by index = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			uploadImageFolioBackImpl = (UploadImageFolioBackImpl) context.getBean("uploadImgFolBack");
			log.info("After Autoinstance - getUploadImage");
			uploadImageFolioInDTO = mapper.readValue(json, UploadImageFolioInDTO.class);
			log.info("After Mapper_FRONT-getUploadImage = ");
			response = uploadImageFolioBackImpl.uploadImageFolioArmed(uploadImageFolioInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			mapper = null;
			uploadImageFolioInDTO = null;
			uploadImageFolioBackImpl = null;
			errorDTO = null;
			context=null;
		}
		return response;
		
	}

}
