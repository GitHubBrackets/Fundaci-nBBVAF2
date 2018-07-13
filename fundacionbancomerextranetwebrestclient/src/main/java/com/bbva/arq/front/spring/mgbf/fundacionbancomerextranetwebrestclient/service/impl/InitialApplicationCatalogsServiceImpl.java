package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialApplicationCatalogsService;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;


/**
 * Class InitialApplicationCatalogsServiceImpl implements the InitialApplicationCatalogs interface
 * Contains the implementations of method catalogs to consume the service (Application Catalogs)
 * 
 * @author Diego Espinoza
 * @version 12 July 2018
 */
public class InitialApplicationCatalogsServiceImpl implements InitialApplicationCatalogsService {
    private static final Logger LOG = Logger.getLogger(InitialApplicationCatalogsServiceImpl.class);
    
    /**      
    *
    * Method catalogs.
    * Contains the parameters for get the URL for the service (Application Catalogs),
    * In this Method add value speials for build URL.
    * @return HttpEntity<?> value as parameter, contains the headers and the body service response.
    *
    * @param HttpHeaders headers
    *
    */
    @Override
    public ResponseEntity<?> catalogs(HttpHeaders headers) {
        String finalUrl=null;
        ClassPathXmlApplicationContext context=null;
        ResponseEntity<?> response=null;
        AsoUtils asoUtils=null;
        ConsumerServiceImpl consumerServiceImpl=null;
        try{
            context=SingletonApplicationContext.getInstance();
            LOG.info("headers-catalogs = "+headers);   
            asoUtils = (AsoUtils) context.getBean("asoUtils");
            consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
            LOG.info("After Autoinstancia - catalogs");
            finalUrl = asoUtils.getUrlsAso(AsoUtils.INT_URL_APPLICATION_CATALOGS);            
            LOG.info("EndUrl-catalogs = "+finalUrl);
            response = consumerServiceImpl.restServiceConsume(HttpMethod.GET, finalUrl, headers,"");
        }catch(Exception exc){
            throw new FundacionBancomerExceptionHandler(exc);
        }finally{
            context=null;
            finalUrl=null;
            asoUtils=null;
            consumerServiceImpl=null;
        }   

            return response;
    }

}
