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
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.QualificationQueryBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.QualificationsQueryInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.QualificationQueryFront;

/**
 * Class QualificationQueryFrontImpl implements the QualificationQueryFront interface
 * Contains the implementations of the method getQualificationQuery to consume the service MGBFTC02
 * This class contains the controller for service MGBFTC02
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/qualification")
@Controller
public class QualificationQueryFrontImpl implements QualificationQueryFront {
	private static final Logger log = Logger.getLogger(QualificationQueryFrontImpl.class);

  	/**      
    *
    * Method getQualificationQuery.
    * Contains the parameters for get the URL for the service MGBFTC02
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/query", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})@Override
	public ResponseEntity<?> getQualificationQuery(@RequestBody String json, HttpServletRequest request) {log.info("Inside getQualificationQuery");
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		ObjectMapper mapper = null;
		QualificationsQueryInDTO qualificationsQueryInDTO = null;
		QualificationQueryBackImpl qualificationQueryBackImpl = null;
		ErrorDTO errorDTO = null;
		context=SingletonApplicationContext.getInstance();
		try{
			log.info("Json Send by index = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			qualificationQueryBackImpl = (QualificationQueryBackImpl) context.getBean("qualifQueryBack");
			log.info("After Autoinstance - getQualificationQuery");
			qualificationsQueryInDTO = mapper.readValue(json, QualificationsQueryInDTO.class);
			log.info("After Mapper_FRONT-getQualificationQuery = ");
			response = qualificationQueryBackImpl.qualificationsQueryInDTOArmed(qualificationsQueryInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			mapper = null;
			qualificationsQueryInDTO = null;
			qualificationQueryBackImpl = null;
			errorDTO = null;
			context=null;
		}
		return response;
	}

}
