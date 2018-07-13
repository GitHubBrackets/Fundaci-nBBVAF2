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
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.ListArchivingDocumentsBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.SendArchDocuUploImageBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.SendArchivingDocumentsBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ListArchivingDocumentsInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.SendArchivingDocumentsInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UploadImageFolioAndSendArchivingInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ArchivingDocumentsFront;

/**
 * Class ArchivingDocumentsFrontImpl implements the ArchivingDocumentsFront interface
 * Contains the implementations of the methods (listArchivingDocuments - sendArchivingDocuments - sendArchivingMultiDocuments), 
 * To consume the services (List Document-Archiving and Send Document-Archiving).  
 * This class contains the controller for the services
 * 
 * @author Diego Espinoza
 * @version 28 november 2017
 */
@RequestMapping("/documents")
@Controller
public class ArchivingDocumentsFrontImpl implements ArchivingDocumentsFront{
	private static final Logger log = Logger.getLogger(ArchivingDocumentsFrontImpl.class);
 
  	/**      
    *
    * Method listArchivingDocuments.
    * Contains the parameters for get the URL for the service (List document-Archiving)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/list", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public ResponseEntity<?> listArchivingDocuments(@RequestBody String json, HttpServletRequest request) {log.info("Inside ArchivingDocumentsFrontImpl");
		ClassPathXmlApplicationContext context=null;
		ResponseEntity<?> response=null;
		ObjectMapper mapper=null;
		ListArchivingDocumentsInDTO listArchivingDocumentsInDTO=null;
		ListArchivingDocumentsBackImpl listArchivingDocumentsBackImpl=null;
		ErrorDTO errorDTO = null;
		context=SingletonApplicationContext.getInstance();
		try{	
			log.info("Json received - Front = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			log.info("After Autoinstance - ArchivingDocumentsFrontImpl = ");
			listArchivingDocumentsBackImpl = (ListArchivingDocumentsBackImpl) context.getBean("listArchDocuBack");
			listArchivingDocumentsInDTO = mapper.readValue(json, ListArchivingDocumentsInDTO.class);
			log.info("Pass Object Mapper = ");
			response = listArchivingDocumentsBackImpl.listArchivingDocumentsArmed(listArchivingDocumentsInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			context = null;
			mapper = null;
			listArchivingDocumentsInDTO = null;
			listArchivingDocumentsBackImpl = null;
			errorDTO = null;
		}
		
		return response;
	}
	
  	/**      
    *
    * Method sendArchivingDocuments.
    * Contains the parameters for get the URL for the service (Send document-Archiving)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping( 
			value = "/send", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public ResponseEntity<?> sendArchivingDocuments(@RequestBody String json, HttpServletRequest request) {log.info("Inside sendArchivingDocuments");
		ResponseEntity<?> response=null;
		ObjectMapper mapper = null;
		UploadImageFolioAndSendArchivingInDTO uploadImageFolioAndSendArchivingInDTO = null;
		SendArchDocuUploImageBackImpl sendArchDocuUploImageBackImpl = null;
		ErrorDTO errorDTO = null;
		ClassPathXmlApplicationContext context=null;
		try{			
			context=SingletonApplicationContext.getInstance();
			log.info("Json received - Front = "+json);
			mapper = (ObjectMapper) context.getBean("objMapper");
			log.info("Pass Object Mapper = ");
			sendArchDocuUploImageBackImpl = (SendArchDocuUploImageBackImpl) context.getBean("sendArchDocuUploImgBack");
			log.info("After Autoinstance - ArchivingDocumentsFrontImpl = ");
			uploadImageFolioAndSendArchivingInDTO = mapper.readValue(json, UploadImageFolioAndSendArchivingInDTO.class);
			response = sendArchDocuUploImageBackImpl.setUploadImageFolioAndSendArchiving(uploadImageFolioAndSendArchivingInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			context = null;
			mapper = null;
			uploadImageFolioAndSendArchivingInDTO = null;
			errorDTO = null;
		}
		
		return response;
	}
			
  	/**      
    *
    * Method sendArchivingMultiDocuments.
    * Contains the parameters for get the URL for the service SendDocument
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
	*
    */
	@RequestMapping(
			value = "/sendmulti", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
	public ResponseEntity<?> sendArchivingMultiDocuments(@RequestBody String json, HttpServletRequest request) {
		ResponseEntity<?> response=null;
		ObjectMapper mapper = null;
		SendArchivingDocumentsInDTO sendArchivingDocumentsInDTO =  null;
		SendArchivingDocumentsBackImpl sendArchivingDocumentsBackImpl = null;
		ErrorDTO errorDTO = null;
		ClassPathXmlApplicationContext context=null;
		try{
			context=SingletonApplicationContext.getInstance();
			mapper = (ObjectMapper) context.getBean("objMapper");
			sendArchivingDocumentsBackImpl = (SendArchivingDocumentsBackImpl) context.getBean("sendArchDocuBack");
			sendArchivingDocumentsInDTO = mapper.readValue(json, SendArchivingDocumentsInDTO.class);
			response = sendArchivingDocumentsBackImpl.sendArchivingDocumentsArmed(sendArchivingDocumentsInDTO, request);
		}catch(Exception e){
			errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
			errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
			errorDTO.setCode(String.valueOf(e.hashCode()));
			errorDTO.setMessage(e.getLocalizedMessage());
			response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			context = null;
			mapper = null;
			sendArchivingDocumentsInDTO = null;
			sendArchivingDocumentsBackImpl = null;
			errorDTO = null;
			
		}
		
		return response;
	}






	
}
