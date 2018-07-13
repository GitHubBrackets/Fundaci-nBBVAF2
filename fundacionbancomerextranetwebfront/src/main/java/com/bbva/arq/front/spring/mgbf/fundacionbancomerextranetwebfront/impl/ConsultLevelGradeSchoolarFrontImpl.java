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
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.ConsultLevelGradeSchoolarBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ConsultLevelAndGradeScholarInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ConsultLevelGradeSchoolarFront;

/**
 * Class ConsultLevelGradeSchoolarFrontImpl implements the ConsultLevelGradeSchoolarFront interface
 * Contains the implementations of the method getConsultLevelGrade to consume the service MGBFTB04
 * This class contains the controller for service MGBFTB04
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/consult")
@Controller
public class ConsultLevelGradeSchoolarFrontImpl implements ConsultLevelGradeSchoolarFront {
	private static final Logger log = Logger.getLogger(ConsultLevelGradeSchoolarFrontImpl.class);

  	/**      
    *
    * Method alerts.
    * Contains the parameters for get the URL for the service MGBFTB04
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/levelGrade", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public ResponseEntity<?> getConsultLevelGrade(@RequestBody String json,HttpServletRequest request) {log.info("Inside getConsultLevelGrade");
		ResponseEntity<?> response=null;
		ObjectMapper mapper = null;
		ConsultLevelAndGradeScholarInDTO consultLevelAndGradeScholarInDTO = null;
		ConsultLevelGradeSchoolarBackImpl consultLevelGradeSchoolarBackImpl = null;
		ErrorDTO errorDTO = null;	
		ClassPathXmlApplicationContext context = null;
		context=SingletonApplicationContext.getInstance();
		try{
			mapper = (ObjectMapper) context.getBean("objMapper");
			consultLevelGradeSchoolarBackImpl = (ConsultLevelGradeSchoolarBackImpl) context.getBean("consultLevGradSchooBack");
			log.info("After Autoinstance - getConsultLevelGrade");
			consultLevelAndGradeScholarInDTO = mapper.readValue(json, ConsultLevelAndGradeScholarInDTO.class);
			log.info("After Mapper_FRONT-getConsultLevelGrade = ");
			response = consultLevelGradeSchoolarBackImpl.consultLevelGradeSchoolarArmed(consultLevelAndGradeScholarInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			context = null;
			mapper = null;
			consultLevelAndGradeScholarInDTO = null;
			consultLevelGradeSchoolarBackImpl = null;
			errorDTO = null;
		}
		
		return response;
	}

}
