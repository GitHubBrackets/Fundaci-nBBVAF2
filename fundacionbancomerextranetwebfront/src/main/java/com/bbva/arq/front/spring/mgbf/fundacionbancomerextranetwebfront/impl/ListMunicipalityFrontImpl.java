package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.impl;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;

import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.ListMunicipalityBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ListMunicipalityFront;

/**
 * Class ListMunicipalityFrontImpl implements the ListMunicipalityFront interface
 * Contains the implementations of the method getListMunicipality to consume the service (list municipality)
 * This class contains the controller for service (list municipality)
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/list")
@Controller
public class ListMunicipalityFrontImpl implements ListMunicipalityFront {
	private static final Logger log = Logger.getLogger(ListMunicipalityFrontImpl.class);

  	/**      
    *
    * Method alerts.
    * Contains the parameters for get the URL for the service (list municipality)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/municipality", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})@Override
	public ResponseEntity<?> getListMunicipality(@RequestBody String json, HttpServletRequest request) {log.info("Inside getListMunicipality");
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		String state = null;
		ErrorDTO errorDTO = null;
		JSONObject jsonObj = null;
		ListMunicipalityBackImpl listMunicipalyBackImpl = null;
		
		jsonObj = new JSONObject(json.toString());
		state = jsonObj.getString("state").toString();
		context=SingletonApplicationContext.getInstance();
		try{
			log.info("Json Send by index = "+json);
			listMunicipalyBackImpl = (ListMunicipalityBackImpl) context.getBean("listMunicipalBack");
			log.info("After Autoinstance - getListMunicipality");
			response = listMunicipalyBackImpl.listMunicipalityArmed(Integer.parseInt(state), request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			context = null;
			state = null;
			errorDTO = null;
			jsonObj = null;
		}
		
		return response;
	}

}
