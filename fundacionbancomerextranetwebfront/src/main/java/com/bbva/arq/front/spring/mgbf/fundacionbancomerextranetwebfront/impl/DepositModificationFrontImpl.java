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
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.DepositModificationBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DepositModificationInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.DepositModificationFront;

/**
 * Class DepositModificationFrontImpl implements the DepositModificationFront interface
 * Contains the implementations of the method getDepositModification to consume the service MGBFTH02
 * This class contains the controller for service MGBFTH02
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/deposit")
@Controller
public class DepositModificationFrontImpl implements DepositModificationFront {
	private static final Logger log = Logger.getLogger(DepositModificationFrontImpl.class);
	
  	/**      
    *
    * Method getDepositModification.
    * Contains the parameters for get the URL for the service MGBFTH02
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/modification", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public ResponseEntity<?> getDepositModification(@RequestBody String json, HttpServletRequest request) {log.info("Inside getDepositModification");
	log.info("TSEC = "+request.getSession().getAttribute("tsec"));
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context=null;
		ObjectMapper mapper = null;
		DepositModificationInDTO depositModificationInDTO = null;
		DepositModificationBackImpl depositModificationBackImpl = null;
		ErrorDTO errorDTO = null;
		context=SingletonApplicationContext.getInstance();
		try{
			log.info("Json Send by index = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			depositModificationBackImpl = (DepositModificationBackImpl) context.getBean("DepostModifBack");
			log.info("After Autoinstance - getDepositModification");
			depositModificationInDTO = mapper.readValue(json, DepositModificationInDTO.class);
			log.info("After Mapper_FRONT-getDepositModification = ");
			response = depositModificationBackImpl.depositModificationArmed(depositModificationInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			context = null;
			mapper = null;
			depositModificationInDTO = null;
			depositModificationBackImpl = null;
			errorDTO = null;
		}
		return response;
	}
}
