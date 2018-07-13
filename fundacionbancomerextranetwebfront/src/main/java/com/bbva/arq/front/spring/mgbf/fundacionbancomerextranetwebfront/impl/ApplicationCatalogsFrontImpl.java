package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;

import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl.ApplicationCatalogsBackImpl;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebfront.ApplicationCatalogsFront;


/**
 * Class ApplicationCatalogosImpl implements the ApplicationCatalogos interface
 * Contains the implementations of the method getApCatalogos to consume the service (Application-Catalogos)
 * This class contains the controller for service (Application-Catalogos)
 * 
 * @author Diego Espinoza
 * @version 12 July 2018
 */
@RequestMapping("/application")
@Controller
public class ApplicationCatalogsFrontImpl implements ApplicationCatalogsFront {
    private static final Logger log = Logger.getLogger(ApplicationCatalogsFrontImpl.class);
    
    /**      
    *
    * Method getApCatalogos.
    * Contains the parameters for get the URL for the service (Application-Catalogos)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param String json
    * @param HttpServletRequest request
    *
    */
    @RequestMapping( 
            value = "/catalogs", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON})
    @Override
    public ResponseEntity<?> getApCatalogos(HttpServletRequest request) {
        log.info("Inside getApCatalogos");
        ResponseEntity<?> response = null;
        ClassPathXmlApplicationContext context = null;
        ApplicationCatalogsBackImpl applicationCatalogsBackImpl = null;
        ErrorDTO errorDTO = null;
        context=SingletonApplicationContext.getInstance();
        try{
            applicationCatalogsBackImpl = (ApplicationCatalogsBackImpl) context.getBean("AppliCatalogsServiceBack");            
            log.info("After Autoinstance - getApCatalogos");
            response = applicationCatalogsBackImpl.catalogsArmed(request);
        }catch(Exception e){
            errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
            errorDTO.setHttpStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            errorDTO.setCode(String.valueOf(e.hashCode()));
            errorDTO.setMessage(e.getLocalizedMessage());
            response = new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }finally{           
            context = null;
            errorDTO = null;
            applicationCatalogsBackImpl = null;
        }
        
        return response;
    }

}
