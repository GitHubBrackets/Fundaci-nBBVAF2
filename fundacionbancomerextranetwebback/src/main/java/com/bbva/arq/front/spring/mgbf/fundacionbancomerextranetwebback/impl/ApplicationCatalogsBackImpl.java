package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.ApplicationCatalogsBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialApplicationCatalogsServiceImpl;

/**
 * Class ApplicationCataogsBackImpl implements the ApplicationCatalogsBack interface
 * Contains the implementations of the method catalogsArmed to consume the service (Application Catalogs)
 * 
 * @author Diego Espinoza
 * @version 12 July 2018
 */
public class ApplicationCatalogsBackImpl implements ApplicationCatalogsBack {
    private static final Logger LOG = Logger.getLogger(ListStateBackImpl.class);
    private boolean gtCad = false;
    
    /**      
    *
    * Method catalogsArmed.
    * Contains the parameters for get the URL for the service (Application Catalogs)
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param HttpServletRequest request
    *
    */
    @Override
    public ResponseEntity<?> catalogsArmed(HttpServletRequest request) {
        LOG.info("Inside catalogsArmed");
        
        ResponseEntity<?> response=null;
        ClassPathXmlApplicationContext context=null;
        HttpHeaders headers=null;
        ErrorDTO errorDTO=null;
        InitialApplicationCatalogsServiceImpl initialApplicationCatalogsServiceImpl =null;
        MessageErrorDTO messageErrorDTO=null;
        try{
            context=SingletonApplicationContext.getInstance();
            headers = (HttpHeaders) context.getBean("httpHeaders");
            initialApplicationCatalogsServiceImpl = (InitialApplicationCatalogsServiceImpl) context.getBean("AppliCatalogsServiceCli");
            LOG.info("After Autoinstance - catalogsArmed");
            headers.setContentType(MediaType.APPLICATION_JSON);     
            headers.set("tsec", request.getSession().getAttribute("tsec").toString());
            LOG.info("headers-catalogsArmed = "+headers);
            response = initialApplicationCatalogsServiceImpl.catalogs(headers);
            if(response.getStatusCode().value() != 200){
                LOG.info("Error consult - catalogsArmed ");
                messageErrorDTO =(MessageErrorDTO)response.getBody();

                if(messageErrorDTO.getErrorcode().equals("68")){LOG.info("TSEC is timed out");
                    request.getSession().setAttribute("tsec", null);
                    response = this.catalogsArmed(request);
                    gtCad = true;
                }
                if(!gtCad){
                    errorDTO = (ErrorDTO) context.getBean("ErrorDTO");
                    errorDTO.setHttpStatusCode(String.valueOf(response.getStatusCode().value()));
                    errorDTO.setCode(messageErrorDTO.getErrorcode());
                    errorDTO.setMessage(messageErrorDTO.getErrormessage());
                    response = new ResponseEntity<ErrorDTO>(errorDTO, response.getStatusCode());
                }
            }
        }catch(Exception exc){
            throw new FundacionBancomerExceptionHandler(exc);
        }finally{
            context = null;
            headers = null;
            errorDTO = null;
            messageErrorDTO = null;
        }   
        return response;
    }
    
}
