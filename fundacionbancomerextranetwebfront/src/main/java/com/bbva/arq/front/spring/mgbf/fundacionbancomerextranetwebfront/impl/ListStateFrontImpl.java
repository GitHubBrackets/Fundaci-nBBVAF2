package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ListStateFront;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.ListStateBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;

/**
 * Class ListStateFrontImpl implements the ListStateFront interface
 * Contains the implementations of the method getListState to consume the service (list-state)
 * This class contains the controller for service (list-state)
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/list")
@Controller
public class ListStateFrontImpl implements  ListStateFront{
	private static final Logger log = Logger.getLogger(ListStateFrontImpl.class);
	
  	/**      
    *
    * Method getListState.
    * Contains the parameters for get the URL for the service (list-state)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/state", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON})@Override
	public ResponseEntity<?> getListState(HttpServletRequest request) {log.info("Inside getListState");
		ResponseEntity<?> response = null;
		ClassPathXmlApplicationContext context = null;
		ListStateBackImpl listStateBackImpl = null;
		ErrorDTO errorDTO = null;
		context=SingletonApplicationContext.getInstance();
		try{
			listStateBackImpl = (ListStateBackImpl) context.getBean("lisStateBack");			
			log.info("After Autoinstance - getListState");
			response = listStateBackImpl.listArchivingDocumentsArmed(request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{			
			context = null;
			errorDTO = null;
			listStateBackImpl = null;
		}
		
		return response;

	}
}