package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebback.UpdateBiographtyBack;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.ErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UpdateBiographyInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict.MessageErrorDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl.InitialUpdateBiographyServiceImpl;


/**
 * Class UpdateBiographtyBackImpl implements the UpdateBiographtyBack interface
 * Contains the implementations of the method updateBiographyArmed to consume the service Update Biography
 * 
 * @author Diego Espinoza
 * @version 23 july 2018
 */
public class UpdateBiographtyBackImpl implements UpdateBiographtyBack {
    private static final Logger LOG = Logger.getLogger(AlertBackImpl.class);
    private boolean gtCad = false;

    /**      
    *
    * Method updateBiographyArmed.
    * Contains the parameters for get the URL for the service Update Biography
    * @return ResponseEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param UpdateBiographyInDTO beanupdateBiographyInDTO
    * @param String scholarID
    * @param HttpServletRequest request
    *
    */
    @Override
    public ResponseEntity<?> updateBiographyArmed(
            UpdateBiographyInDTO beanUpdateBiographyIn, String scholarID,
            HttpServletRequest request) {
        LOG.info("Inside updateBiographyArmed");
        ClassPathXmlApplicationContext context=null;
        ResponseEntity<?> response=null;
        InitialUpdateBiographyServiceImpl initialUpdateBiographyServiceImpl = null;
        HttpHeaders headers = null;
        ErrorDTO errorDTO=null;
        MessageErrorDTO messageErrorDTO=null;
            try{
                context=SingletonApplicationContext.getInstance();
                initialUpdateBiographyServiceImpl = (InitialUpdateBiographyServiceImpl) context.getBean("UpdateBiographyServiceCli");
                headers = (HttpHeaders) context.getBean("httpHeaders"); 
                LOG.info("After Autoinstance - updateBiographyArmed");    
                headers.setContentType(MediaType.APPLICATION_JSON);     
                headers.set("tsec", request.getSession().getAttribute("tsec").toString());
                LOG.info("headers-updateBiographyArmed "+headers);
                response = initialUpdateBiographyServiceImpl.updateBiography(beanUpdateBiographyIn, scholarID, headers);
                if(response.getStatusCode().value() != 200){
                    LOG.info("Error consult - updateBiographyArmed ");
                    messageErrorDTO =(MessageErrorDTO)response.getBody();
                    
                    if(messageErrorDTO.getErrorcode().equals("68")){LOG.info("TSEC  is timed out");
                        request.getSession().setAttribute("tsec", null);
                        response = this.updateBiographyArmed(beanUpdateBiographyIn, scholarID, request);
                        gtCad=true;
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
                LOG.info("Entra en El Exception");
                throw new FundacionBancomerExceptionHandler(exc);
            }finally{
                context = null;
                headers=null;
                initialUpdateBiographyServiceImpl = null;
                errorDTO = null;
                messageErrorDTO = null;
            }

        return response;
    }

}
