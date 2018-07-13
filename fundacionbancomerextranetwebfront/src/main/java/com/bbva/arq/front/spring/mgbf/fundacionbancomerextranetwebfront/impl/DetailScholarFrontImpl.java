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
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.DetailScholarBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.DetailScholarInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.DetailScholarFront;


/**
 * Class DetailScholarFrontImpl implements the DetailScholarFront interface
 * Contains the implementations of the method getDetailScholar to consume the service MGBFTB03
 * This class contains the controller for service MGBFTB03
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/details")
@Controller
public class DetailScholarFrontImpl implements DetailScholarFront{
	private static final Logger log = Logger.getLogger(DetailScholarFrontImpl.class);

  	/**      
    *
    * Method getDetailScholar.
    * Contains the parameters for get the URL for the service MGBFTB03
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/scholar", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public ResponseEntity<?> getDetailScholar(@RequestBody String json, HttpServletRequest request) {log.info("Inside getDetailScholar");
		ClassPathXmlApplicationContext context = null;
		ResponseEntity<?> response = null;
		ObjectMapper mapper = null;
		DetailScholarInDTO detailScholarInDTO = null;
		DetailScholarBackImpl detailScholarBackImpl = null;
		ErrorDTO errorDTO = null;	
		context=SingletonApplicationContext.getInstance();
		try{	
			log.info("Json Send by index = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			detailScholarInDTO = (DetailScholarInDTO) context.getBean("detailScholarInDTO");
			detailScholarBackImpl = (DetailScholarBackImpl) context.getBean("detailScholarBack");
			log.info("After Autoinstance - getDetailScholar");
			detailScholarInDTO = mapper.readValue(json, DetailScholarInDTO.class);
			log.info("After Mapper_FRONT-getDetailScholar = ");
			response = detailScholarBackImpl.detailScholarArmed(detailScholarInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			log.info("Cause = "+e.getCause());
			errorDTO.setMessage(e.getMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			context = null;
			mapper = null;
			detailScholarInDTO = null;
			detailScholarBackImpl = null;
			errorDTO = null;
		}		
		return response;
	}

}
