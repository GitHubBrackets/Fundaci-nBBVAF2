package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.conflict;




import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class PropertyDTO
 * Contains the input values for the errors
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class PropertyDTO {
	
	private String value;
	private String name;
	
	   /**      
    *
    * Method getValue.
    * Contains the get parameter for the service
    * @return List<String> value as parameter.
    *
    */
    public String getValue() {
        return value;
    }
    
    /**      
    *
    * Method setValue.
    * Contains the set parameter for the service
    * 
    * @param List<String> value
    * 
    */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**      
    *
    * Method getName.
    * Contains the get parameter for the service
    * @return List<String> value as parameter.
    *
    */
    public String getName() {
        return name;
    }
    
    /**      
    *
    * Method setName.
    * Contains the set parameter for the service
    * 
    * @param List<String> name
    * 
    */
    public void setName(String name) {
        this.name = name;
    }

	
}
