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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.UpdateBiographtyBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UpdateBiographyInDTO;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.UpdateBiographyFront;

/**
 * Class UpdateBiographyFrontImpl implements the UpdateBiographyFront interface
 * Contains the implementations of the method alerts to consume the service Update Bography
 * This class contains the controller for service Update Bography
 * 
 * @author Diego Espinoza
 * @version 23 july 2018
 */
@RequestMapping("/update")
@Controller
public class UpdateBiographyFrontImpl implements UpdateBiographyFront {
    private static final Logger LOG = Logger.getLogger(UpdateBiographyFrontImpl.class);

    /**      
    *
    * Method alerts.
    * Contains the parameters for get the URL for the service MGBFTK01
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
    *
    */
    @RequestMapping( 
            value = "/biography", method=RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON}, produces = {MediaType.APPLICATION_JSON})
    @Override
    public ResponseEntity<?> updateBiography(@RequestBody String json, @RequestHeader String scholarID, HttpServletRequest request) {
        LOG.info("Inside updateBiography");
        ClassPathXmlApplicationContext context=null;
        ResponseEntity<?> response=null;
        ObjectMapper mapper=null;
        UpdateBiographyInDTO updateBiographyInDTO=null;
        UpdateBiographtyBackImpl updateBiographtyBackImpl = null;
        ErrorDTO errorDTO = null;
        context=SingletonApplicationContext.getInstance();
        try{   
            LOG.info("scholarID = "+scholarID);
            scholarID = scholarID.trim();
            LOG.info("Json - updateBiography");
            mapper = (ObjectMapper) context.getBean("objMapper");
            updateBiographtyBackImpl = (UpdateBiographtyBackImpl) context.getBean("UpdateBiographyBack");
            LOG.info("After Autoinstance - updateBiography");
            updateBiographyInDTO = mapper.readValue(json, UpdateBiographyInDTO.class);
            LOG.info("After Mapper_FRONT-updateBiography");
            response = updateBiographtyBackImpl.updateBiographyArmed(updateBiographyInDTO, scholarID, request);
            
            LOG.info("response FRONTTTT = "+response);
            
        }catch(Exception e){
            errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
            errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            errorDTO.setCode(String.valueOf(e.hashCode()));
            errorDTO.setMessage(e.getLocalizedMessage());
            response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally{
            context = null;
            mapper = null;
            updateBiographyInDTO=null;
            updateBiographtyBackImpl = null;
            errorDTO = null;
        }
        
        return response;

    }

}
