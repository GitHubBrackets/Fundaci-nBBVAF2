package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetutils;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



public class SingletonApplicationContext{
	private static final Logger log = Logger.getLogger(SingletonApplicationContext.class);
    private static final String CONFILE= "classpath*:/META-INF/spring/applicationContext.xml";

    public static ClassPathXmlApplicationContext getInstance(){
    	ClassPathXmlApplicationContext context=null;
    	ServletRequestAttributes request = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    	try{
	    	log.info("Into SingletonApplicationContextImpl.getInstance()");
	        if(request.getRequest().getSession().getAttribute("applicationcontext")==null){
	        	log.info("new SingletonApplicationContextImpl.getInstance()");
	        	context =new ClassPathXmlApplicationContext(CONFILE);
	            request.getRequest().getSession().setAttribute("applicationcontext", context);
	        }
	      
    	}catch(Exception exc){
    		request.getRequest().getSession().setAttribute("applicationcontext", null);
    	}finally{
    		context=null;
    	}
    	return (ClassPathXmlApplicationContext) request.getRequest().getSession().getAttribute("applicationcontext");
    }

	public static void closeContext(ClassPathXmlApplicationContext classPathXmlApplicationContext) {
    	try{
    		classPathXmlApplicationContext.close();
    	}catch(Exception exc){    		
    	}

		
	}
	
}
