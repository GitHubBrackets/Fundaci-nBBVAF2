package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto;

import java.util.List;

import com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.updatebiography.PersonalInterestsDTO;

/**
 * Class UpdateBiographyDTO
 * Contains the input values for the service Update Biography
 * 
 * @author Diego Espinoza
 * @version 23 july 2018
 */
public class UpdateBiographyInDTO {
    
    private String aboutMe;
    private List<PersonalInterestsDTO> personalInterests;
    
    
    /**      
    *
    * Method getAboutMe.
    * Contains the get parameter for the service
    * @return int value as parameter.
    *
    */
    public String getAboutMe() {
        return aboutMe;
    }
    
    /**      
    *
    * Method setId.
    * Contains the set parameter for the service
    * 
    * @param String setAboutMe
    * 
    */
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
    
    /**      
    *
    * Method getPersonalInterests.
    * Contains the get parameter for the service
    * @return List<PersonalInterestsDTO> value as parameter.
    *
    */
    public List<PersonalInterestsDTO> getPersonalInterests() {
        return personalInterests;
    }
    
    /**      
    *
    * Method setPersonalInterests.
    * Contains the set parameter for the service
    * 
    * @param List<PersonalInterestsDTO> personalInterests
    * 
    */
    public void setPersonalInterests(List<PersonalInterestsDTO> personalInterests) {
        this.personalInterests = personalInterests;
    }
   

}
