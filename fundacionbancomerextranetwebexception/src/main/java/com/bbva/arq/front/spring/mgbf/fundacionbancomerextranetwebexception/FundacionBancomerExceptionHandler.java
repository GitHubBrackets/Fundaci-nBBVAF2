package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebexception;

/**
 * Class FundacionBancomerExceptionHandler extends the RuntimeException
 * Contains the the methods for catch exceptions generic.
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class FundacionBancomerExceptionHandler extends RuntimeException {
	
	 private static final long serialVersionUID = 1L;

   	/**
     *
     * Method FundacionBancomerExceptionHandler
     * Method without parameters extends of class RuntimeException
     * 
     */
     public FundacionBancomerExceptionHandler() {
         super();
     }
 	/**
     *
     * Method FundacionBancomerExceptionHandler
     * Method with two parameters that catch exception
     *
     * @param String message
     * @param Throwable cause
     * 
     */ 
     public FundacionBancomerExceptionHandler(String message, Throwable cause) {
         super(message, cause);
     }
 	/**
     *
     * Method FundacionBancomerExceptionHandler
     * Method with one parameter catch exception
     *
     * @param String message
     * 
     */     
     public FundacionBancomerExceptionHandler(String message) {
         super(message);
     }
    	/**
     *
     * Method FundacionBancomerExceptionHandler
     * Method with one parameter catch the cause exception
     *
     * @param Throwable cause
     */       
     public FundacionBancomerExceptionHandler(Throwable cause) {
         super(cause);
     }        

}
