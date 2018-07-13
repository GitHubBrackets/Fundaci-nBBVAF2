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
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.DepositQueryBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DepositQueryInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.DepositQueryFront;

/**
 * Class DepositQueryFrontImpl implements the DepositQueryFront interface
 * Contains the implementations of the method getDepositQuery to consume the service MGFBTH01
 * This class contains the controller for service MGFBTH01
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/deposit")
@Controller
public class DepositQueryFrontImpl implements DepositQueryFront {
	private static final Logger log = Logger.getLogger(DepositQueryFrontImpl.class);

  	/**      
    *
    * Method getDepositQuery.
    * Contains the parameters for get the URL for the service MGFBTH01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/query", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public ResponseEntity<?> getDepositQuery(@RequestBody String json, HttpServletRequest request) {log.info("Inside getDepositQuery");
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context=null;
		ObjectMapper mapper = null;
		DepositQueryInDTO depositQueryInDTO = null;
		DepositQueryBackImpl depositQueryBackImpl = null;
		context=SingletonApplicationContext.getInstance();
		ErrorDTO errorDTO = null;
		try{
			log.info("Json Send by index = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			depositQueryBackImpl = (DepositQueryBackImpl) context.getBean("depositQueryBack");
			log.info("After Autoinstance - getDepositQuery");
			depositQueryInDTO = mapper.readValue(json, DepositQueryInDTO.class);
			log.info("After Mapper_FRONT-getDepositQuery = ");
			response = depositQueryBackImpl.depositQueryArmed(depositQueryInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			context = null;
			mapper = null;
			depositQueryInDTO = null;
			depositQueryBackImpl = null;
			errorDTO = null;
		}
		return response;
	}
}
