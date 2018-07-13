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
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.AverageQueryBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.AveragesQueryInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.AverageQueryFront;

/**
 * Class AverageQueryFrontImpl implements the AverageQueryFront interface
 * Contains the implementations of the method getAverageQuery to consume the service MGBFTC03
 * This class contains the controller for service MGBFTC03
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/average")
@Controller
public class AverageQueryFrontImpl implements AverageQueryFront {
	private static final Logger log = Logger.getLogger(AverageQueryFrontImpl.class);
	
  	/**      
    *
    * Method getAverageQuery.
    * Contains the parameters for get the URL for the service MGBFTC03
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/query", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public ResponseEntity<?> getAverageQuery(@RequestBody String json,HttpServletRequest request) {log.info("Inside getAverageQuery");
		ResponseEntity<?> response=null;
		ClassPathXmlApplicationContext context = null;
		ObjectMapper mapper = null;
		AveragesQueryInDTO averagesQueryInDTO = null;
		ErrorDTO errorDTO = null;
		AverageQueryBackImpl averageQueryBackImpl= null;
		context=SingletonApplicationContext.getInstance();
		try{	
			log.info("Json Send by index = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			averageQueryBackImpl = (AverageQueryBackImpl) context.getBean("averageQueryBack");
			log.info("After Autoinstance - getAverageQuery");
			averagesQueryInDTO = mapper.readValue(json, AveragesQueryInDTO.class);
			log.info("After Mapper_FRONT-getAverageQuery = ");
			response = averageQueryBackImpl.averageQueryArmed(averagesQueryInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			context = null;
			mapper = null;
			averagesQueryInDTO = null;
			averageQueryBackImpl = null;
			errorDTO = null;
		}
		
		return response;
	}

}
