package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.ConsumerService;

/**
 * Class ConsumerServiceImpl implements the ConsumerService interface
 * Contains the implementations of the methods (GET and POST) to consume the services
 * 
 * @author Diego Espinoza
 * @version 24 november 2017
 */
public class ConsumerServiceImpl implements  ConsumerService{
	private static final Logger log = Logger.getLogger(ConsumerServiceImpl.class);
  	/**      
    *
    * Method restServiceConsume.
    * Contains the implementation to consume the services with the POST method.
    * @return HttpEntity<String> value as parameter, contains the headers and the body service response.
    *
    * @param HttpMethod method
    * @param String urlPath
    * @param Object object
    * @param HttpHeaders headers
    * 
    */

	public ResponseEntity<?> restServiceConsume(HttpMethod method, String urlPath, Object object, HttpHeaders headers) {log.info("Inside of RestServiceConsume POST");
		 ResponseEntity<?> responseout = null;
		 ObjectWriter ow=null;
		 String json=null;
		 RestTemplate restTemplate=null;
		 HttpEntity<?> requestEntity=null;
		 HttpHeaders responseHeaders=null;
		 MessageErrorDTO messageErrorDTO=null;
		 ObjectMapper mapper = null;
		 String responseString=null;
		try{			
			ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			json = ow.writeValueAsString(object);
			log.info("jsonIn-Consumer = "+json);
			log.info("urlPath-Costumer = "+urlPath);			
			restTemplate = new RestTemplate();
			requestEntity = new HttpEntity<Object>(object,headers);
			responseout = restTemplate.exchange(urlPath, method, requestEntity, Object.class);
			responseHeaders=responseout.getHeaders();
			log.info("out-Costumer = "+responseout);
		}catch(HttpClientErrorException httpcexc){log.info("HttpClientErrorException");
			try {
				mapper = new ObjectMapper();
				responseHeaders=httpcexc.getResponseHeaders();
				responseString=(httpcexc.getResponseBodyAsString()!=null && !httpcexc.getResponseBodyAsString().trim().equals("")) ? httpcexc.getResponseBodyAsString().replaceAll("-", "") : ("");
				if(!responseString.trim().equals("")){
					messageErrorDTO = mapper.readValue(responseString, MessageErrorDTO.class);
				}else{
					messageErrorDTO= new MessageErrorDTO();
					messageErrorDTO.setErrorcode(String.valueOf(httpcexc.getStatusCode()));
					messageErrorDTO.setErrormessage("Not Body Response");
					messageErrorDTO.setHttpstatus(String.valueOf(httpcexc.getStatusCode()));
					messageErrorDTO.setSeverity("");
					messageErrorDTO.setSystemerrorcause("");
					messageErrorDTO.setSystemerrorcode("");
					messageErrorDTO.setSystemerrordescription("");
				}
				responseout = new ResponseEntity<MessageErrorDTO>(messageErrorDTO, responseHeaders, httpcexc.getStatusCode());
			}catch (Exception mapexc) {
				throw new FundacionBancomerExceptionHandler(mapexc);
			}						
		}catch(HttpServerErrorException httpcexc){log.info("HttpServerErrorException");
			try {
				mapper = new ObjectMapper();
				responseHeaders=httpcexc.getResponseHeaders();
				responseString=(httpcexc.getResponseBodyAsString()!=null && !httpcexc.getResponseBodyAsString().trim().equals("")) ? httpcexc.getResponseBodyAsString().replaceAll("-", "") : ("");
				if(!responseString.trim().equals("")){
					messageErrorDTO = mapper.readValue(responseString, MessageErrorDTO.class);
				}else{
					messageErrorDTO= new MessageErrorDTO();
					messageErrorDTO.setErrorcode(String.valueOf(httpcexc.getStatusCode()));
					messageErrorDTO.setErrormessage("Not Response from ASO Service");
					messageErrorDTO.setHttpstatus(String.valueOf(httpcexc.getStatusCode()));
					messageErrorDTO.setSeverity("");
					messageErrorDTO.setSystemerrorcause("");
					messageErrorDTO.setSystemerrorcode("");
					messageErrorDTO.setSystemerrordescription("");
				}
				responseout = new ResponseEntity<MessageErrorDTO>(messageErrorDTO, responseHeaders, httpcexc.getStatusCode());
			}catch (Exception mapexc) {
				throw new FundacionBancomerExceptionHandler(mapexc);
			}				
		}catch(ResourceAccessException raec){log.info("Inside ResourceAccessException");
			messageErrorDTO= new MessageErrorDTO();
			messageErrorDTO.setErrorcode("504");
			messageErrorDTO.setErrormessage("Connection timed out");
			messageErrorDTO.setHttpstatus(HttpStatus.REQUEST_TIMEOUT.toString());
			messageErrorDTO.setSeverity("");
			messageErrorDTO.setSystemerrorcause("");
			messageErrorDTO.setSystemerrorcode("");
			messageErrorDTO.setSystemerrordescription("");
			
			responseout = new ResponseEntity<MessageErrorDTO>(messageErrorDTO, responseHeaders, HttpStatus.REQUEST_TIMEOUT);
		}catch(Exception exc){log.info("Exception");
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			responseString=null;
			ow=null;
			json=null;
			restTemplate=null;
			requestEntity=null;
			messageErrorDTO=null;
			responseHeaders=null;
			mapper = null;
		}
		return responseout;
	}
	
	
  	/**      
    *
    * Method restServiceConsume.
    * Contains the implementation to consume the services with the GET method.
    * @return HttpEntity<String> value as parameter, contains the headers and the body service response.
    *
    * @param HttpMethod method
    * @param String urlPath
    * @param HttpHeaders headers
    * @param String valCambChar
    * 
    */
	
	public ResponseEntity<?> restServiceConsume(HttpMethod method, String urlPath,HttpHeaders headers, String valCambChar) {log.info("Inside of RestServiceConsume GET");
		 ResponseEntity<?> responseout = null;
		 RestTemplate restTemplate=null;
		 HttpEntity<?> requestEntity=null;
		 HttpHeaders responseHeaders=null;
		 MessageErrorDTO messageErrorDTO=null;
		 ObjectMapper mapper = null;
		 String responseString=null;
		try{			
			log.info("urlPath-Consumer = "+urlPath);			
			restTemplate = new RestTemplate();
			requestEntity = new HttpEntity<Object>(null,headers);
			responseout = restTemplate.exchange(urlPath, method, requestEntity, Object.class, valCambChar);
			responseHeaders=responseout.getHeaders();
			log.info("out-Costumer = "+responseout);
		}catch(HttpClientErrorException httpcexc){
			try {
				mapper = new ObjectMapper();
				responseHeaders=httpcexc.getResponseHeaders();
				responseString=(httpcexc.getResponseBodyAsString()!=null && !httpcexc.getResponseBodyAsString().trim().equals("")) ? httpcexc.getResponseBodyAsString().replaceAll("-", "") : ("");
				if(!responseString.trim().equals("")){
					messageErrorDTO = mapper.readValue(responseString, MessageErrorDTO.class);
				}else{
					messageErrorDTO= new MessageErrorDTO();
					messageErrorDTO.setErrorcode(String.valueOf(httpcexc.getStatusCode()));
					messageErrorDTO.setErrormessage("Not Body Response");
					messageErrorDTO.setHttpstatus(String.valueOf(httpcexc.getStatusCode()));
					messageErrorDTO.setSeverity("");
					messageErrorDTO.setSystemerrorcause("");
					messageErrorDTO.setSystemerrorcode("");
					messageErrorDTO.setSystemerrordescription("");
				}
				responseout = new ResponseEntity<MessageErrorDTO>(messageErrorDTO, responseHeaders, httpcexc.getStatusCode());
			}catch (Exception mapexc) {
				throw new FundacionBancomerExceptionHandler(mapexc);
			}			
		}catch(HttpServerErrorException httpcexc){
			try {
				mapper = new ObjectMapper();
				responseHeaders=httpcexc.getResponseHeaders();
				responseString=(httpcexc.getResponseBodyAsString()!=null && !httpcexc.getResponseBodyAsString().trim().equals("")) ? httpcexc.getResponseBodyAsString().replaceAll("-", "") : ("");
				if(!responseString.trim().equals("")){
					messageErrorDTO = mapper.readValue(responseString, MessageErrorDTO.class);
				}else{
					messageErrorDTO= new MessageErrorDTO();
					messageErrorDTO.setErrorcode(String.valueOf(httpcexc.getStatusCode()));
					messageErrorDTO.setErrormessage("Not Response from ASO Service");
					messageErrorDTO.setHttpstatus(String.valueOf(httpcexc.getStatusCode()));
					messageErrorDTO.setSeverity("");
					messageErrorDTO.setSystemerrorcause("");
					messageErrorDTO.setSystemerrorcode("");
					messageErrorDTO.setSystemerrordescription("");
				}
				responseout = new ResponseEntity<MessageErrorDTO>(messageErrorDTO, responseHeaders, httpcexc.getStatusCode());
			}catch (Exception mapexc) {
				throw new FundacionBancomerExceptionHandler(mapexc);
			}				
		}catch(Exception exc){
			throw new FundacionBancomerExceptionHandler(exc);
		}finally{
			responseString=null;
			restTemplate=null;
			requestEntity=null;
			messageErrorDTO=null;
			responseHeaders=null;
			mapper = null;
		}
		return responseout;
	}	

}

