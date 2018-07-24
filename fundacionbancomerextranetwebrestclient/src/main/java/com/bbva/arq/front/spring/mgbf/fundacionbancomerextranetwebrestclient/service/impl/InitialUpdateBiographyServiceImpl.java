package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils.SingletonApplicationContext;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.UpdateBiographyInDTO;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception.FundacionBancomerExceptionHandler;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.InitialUpdateBiographyService;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestclient.service.utils.AsoUtils;
import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebrestconsumer.impl.ConsumerServiceImpl;

/**
 * Class InitialUpdateBiographyServiceImpl implements the InitialUpdateBiographyService interface
 * Contains the implementations of the method alertClient to consume the service Update Biography
 * 
 * @author Diego Espinoza
 * @version 23 july 2018
 */
public class InitialUpdateBiographyServiceImpl implements InitialUpdateBiographyService {
    private static final Logger LOG = Logger.getLogger(InitialAlertServiceImpl.class);
 
    @Override
    public ResponseEntity<?> updateBiography(UpdateBiographyInDTO beanUpdateBiographyDTO, String scholarID,
            HttpHeaders headers) {
        LOG.info("Inside updateBiography");
        ResponseEntity<?> response=null;
        ClassPathXmlApplicationContext context=null;
        //String url=null;
        String finalUrl=null;
        AsoUtils asoUtils=null;
        ConsumerServiceImpl consumerServiceImpl=null;
        
        try{
            context=SingletonApplicationContext.getInstance();
            LOG.info("headers-updateBiography = "+headers);
            asoUtils = (AsoUtils) context.getBean("asoUtils");
            consumerServiceImpl = (ConsumerServiceImpl) context.getBean("ConsumerService");
            LOG.info("After autoinstance - updateBiography");
            finalUrl = asoUtils.getUrlsAso(AsoUtils.INT_URL_UPDATE_BIOGRAPHY ).replace("{id}", scholarID);
            //finalUrl = new StringBuffer(url);
            //finalUrl.append(scholarID).append("/biography");
            //finalUrl = url+scholarID+"/biography";
            LOG.info("EndUrl-updateBiography = "+finalUrl);
            response = consumerServiceImpl.restServiceConsume(HttpMethod.PUT, finalUrl, beanUpdateBiographyDTO, headers);
        }catch(Exception exc){
            throw new FundacionBancomerExceptionHandler(exc);
        }finally{
            context = null;
            //url=null;
            finalUrl=null;
            asoUtils=null;
            consumerServiceImpl=null;
            scholarID = null;
        }
        return response;
    }

}
