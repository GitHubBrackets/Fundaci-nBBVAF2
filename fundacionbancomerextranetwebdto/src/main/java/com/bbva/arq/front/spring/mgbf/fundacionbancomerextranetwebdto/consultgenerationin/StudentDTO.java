package com.bbva.arq.front.spring.mgbf.fundacionbancomerextranetwebdto.consultgenerationin;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) // Permite que Jackson ignore un objeto Vacio

/**
 * Class StudentDTO
 * Contains the input values for the service MGBFTB02
 * 
 * @author Diego Espinoza
 * @version 27 november 2017
 */
public class StudentDTO {
	
	private String studentId;
	private String programType;
	private String statusDispersion;
	private String cdOriginState;
	private String originState;
	private String cdOriginMunicipality;
	private String originMunicipality;
	private String originRegion;
	private String schoolCycle;
	private String cdAssignedCR;
	private String assignedCR;
	private String scholarNumber;
	private String accountNumber;
	private String folioPhoto;
	private String name;
	private String firstName;
	private String lastName;
	@JsonProperty("CURP") private String curp;
	private String scholarBirthdate;
	private String gender;
    private List<SchoolDataDTO> schoolData;
    private List<DomicileDTO> domicile;
    private List<ContactInfDTO> contactInf;
    private List<TutorDataDTO> tutorData;
    private List<ProgramDTO> program;
    
  	/**      
    *
    * Method getStudentId.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getStudentId() {
		return studentId;
	}
	
	/**      
    *
    * Method setStudentId.
    * Contains the set parameter for the service
    * 
    * @param String studentId
    * 
    */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
  	/**      
    *
    * Method getProgramType.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getProgramType() {
		return programType;
	}
	
	/**      
    *
    * Method setProgramType.
    * Contains the set parameter for the service
    * 
    * @param String programType
    * 
    */
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	
  	/**      
    *
    * Method getStatusDispersion.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getStatusDispersion() {
		return statusDispersion;
	}
	
	/**      
    *
    * Method setStatusDispersion.
    * Contains the set parameter for the service
    * 
    * @param String statusDispersion
    * 
    */
	public void setStatusDispersion(String statusDispersion) {
		this.statusDispersion = statusDispersion;
	}
	
  	/**      
    *
    * Method getCdOriginState.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getCdOriginState() {
		return cdOriginState;
	}
	
	/**      
    *
    * Method setCdOriginState.
    * Contains the set parameter for the service
    * 
    * @param String cdOriginState
    * 
    */
	public void setCdOriginState(String cdOriginState) {
		this.cdOriginState = cdOriginState;
	}
	
  	/**      
    *
    * Method getOriginState.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getOriginState() {
		return originState;
	}
	
	/**      
    *
    * Method setOriginState.
    * Contains the set parameter for the service
    * 
    * @param String originState
    * 
    */
	public void setOriginState(String originState) {
		this.originState = originState;
	}
	
  	/**      
    *
    * Method getCdOriginMunicipality.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getCdOriginMunicipality() {
		return cdOriginMunicipality;
	}
	
	/**      
    *
    * Method setCdOriginMunicipality.
    * Contains the set parameter for the service
    * 
    * @param String cdOriginMunicipality
    * 
    */
	public void setCdOriginMunicipality(String cdOriginMunicipality) {
		this.cdOriginMunicipality = cdOriginMunicipality;
	}
	
  	/**      
    *
    * Method getOriginMunicipality.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getOriginMunicipality() {
		return originMunicipality;
	}
	
	/**      
    *
    * Method setOriginMunicipality.
    * Contains the set parameter for the service
    * 
    * @param String originMunicipality
    * 
    */
	public void setOriginMunicipality(String originMunicipality) {
		this.originMunicipality = originMunicipality;
	}
	
  	/**      
    *
    * Method getOriginRegion.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getOriginRegion() {
		return originRegion;
	}
	
	/**      
    *
    * Method setOriginRegion.
    * Contains the set parameter for the service
    * 
    * @param String originRegion
    * 
    */
	public void setOriginRegion(String originRegion) {
		this.originRegion = originRegion;
	}
	
  	/**      
    *
    * Method getSchoolCycle.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getSchoolCycle() {
		return schoolCycle;
	}
	
	/**      
    *
    * Method setSchoolCycle.
    * Contains the set parameter for the service
    * 
    * @param String schoolCycle
    * 
    */
	public void setSchoolCycle(String schoolCycle) {
		this.schoolCycle = schoolCycle;
	}
	
  	/**      
    *
    * Method getCdAssignedCR.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getCdAssignedCR() {
		return cdAssignedCR;
	}
	
	/**      
    *
    * Method setCdAssignedCR.
    * Contains the set parameter for the service
    * 
    * @param String cdAssignedCR
    * 
    */
	public void setCdAssignedCR(String cdAssignedCR) {
		this.cdAssignedCR = cdAssignedCR;
	}
	
  	/**      
    *
    * Method getAssignedCR.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getAssignedCR() {
		return assignedCR;
	}
	
	/**      
    *
    * Method setAssignedCR.
    * Contains the set parameter for the service
    * 
    * @param String assignedCR
    * 
    */
	public void setAssignedCR(String assignedCR) {
		this.assignedCR = assignedCR;
	}
	
  	/**      
    *
    * Method getScholarNumber.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getScholarNumber() {
		return scholarNumber;
	}
	
	/**      
    *
    * Method setScholarNumber.
    * Contains the set parameter for the service
    * 
    * @param String scholarNumber
    * 
    */
	public void setScholarNumber(String scholarNumber) {
		this.scholarNumber = scholarNumber;
	}
	
  	/**      
    *
    * Method getAccountNumber.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**      
    *
    * Method setAccountNumber.
    * Contains the set parameter for the service
    * 
    * @param String accountNumber
    * 
    */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
  	/**      
    *
    * Method getFolioPhoto.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getFolioPhoto() {
		return folioPhoto;
	}
	
	/**      
    *
    * Method setFolioPhoto.
    * Contains the set parameter for the service
    * 
    * @param String folioPhoto
    * 
    */
	public void setFolioPhoto(String folioPhoto) {
		this.folioPhoto = folioPhoto;
	}
	
  	/**      
    *
    * Method getName.
    * Contains the get parameter for the service
    * @return String value as parameter.
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
    * @param String name
    * 
    */
	public void setName(String name) {
		this.name = name;
	}
	
  	/**      
    *
    * Method getFirstName.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getFirstName() {
		return firstName;
	}
	
	/**      
    *
    * Method setFirstName.
    * Contains the set parameter for the service
    * 
    * @param String firstName
    * 
    */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
  	/**      
    *
    * Method getLastName.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getLastName() {
		return lastName;
	}
	
	/**      
    *
    * Method setLastName.
    * Contains the set parameter for the service
    * 
    * @param String lastName
    * 
    */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
  	/**      
    *
    * Method getCurp.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */

	public String getCurp() {
		return curp;
	}
	
	/**      
    *
    * Method setCurp.
    * Contains the set parameter for the service
    * 
    * @param String curp
    * 
    */
	public void setCurp(String curp) {
		this.curp = curp;
	}
	
  	/**      
    *
    * Method getScholarBirthdate.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getScholarBirthdate() {
		return scholarBirthdate;
	}
	
	/**      
    *
    * Method setScholarBirthdate.
    * Contains the set parameter for the service
    * 
    * @param String scholarBirthdate
    * 
    */
	public void setScholarBirthdate(String scholarBirthdate) {
		this.scholarBirthdate = scholarBirthdate;
	}
	
  	/**      
    *
    * Method getGender.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public String getGender() {
		return gender;
	}
	
	/**      
    *
    * Method setGender.
    * Contains the set parameter for the service
    * 
    * @param String gender
    * 
    */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
  	/**      
    *
    * Method getSchoolData.
    * Contains the get parameter for the service
    * @return  List<SchoolDataDTO> value as parameter.
    *
    */
	public List<SchoolDataDTO> getSchoolData() {
		return schoolData;
	}
	
	/**      
    *
    * Method setSchoolData.
    * Contains the set parameter for the service
    * 
    * @param List<SchoolDataDTO> schoolData
    * 
    */
	public void setSchoolData(List<SchoolDataDTO> schoolData) {
		this.schoolData = schoolData;
	}
	
  	/**      
    *
    * Method getDomicile.
    * Contains the get parameter for the service
    * @return List<DomicileDTO> value as parameter.
    *
    */
	public List<DomicileDTO> getDomicile() {
		return domicile;
	}
	
	/**      
    *
    * Method setDomicile.
    * Contains the set parameter for the service
    * 
    * @param List<DomicileDTO> domicile
    * 
    */
	public void setDomicile(List<DomicileDTO> domicile) {
		this.domicile = domicile;
	}
	
  	/**      
    *
    * Method getContactInf.
    * Contains the get parameter for the service
    * @return String value as parameter.
    *
    */
	public List<ContactInfDTO> getContactInf() {
		return contactInf;
	}
	
	/**      
    *
    * Method setContactInf.
    * Contains the set parameter for the service
    * 
    * @param List<ContactInfDTO> contactInf
    * 
    */
	public void setContactInf(List<ContactInfDTO> contactInf) {
		this.contactInf = contactInf;
	}
	
  	/**      
    *
    * Method getTutorData.
    * Contains the get parameter for the service
    * @return List<TutorDataDTO> value as parameter.
    *
    */
	public List<TutorDataDTO> getTutorData() {
		return tutorData;
	}
	
	/**      
    *
    * Method setTutorData.
    * Contains the set parameter for the service
    * 
    * @param List<TutorDataDTO> tutorData
    * 
    */
	public void setTutorData(List<TutorDataDTO> tutorData) {
		this.tutorData = tutorData;
	}
	
  	/**      
    *
    * Method getProgram.
    * Contains the get parameter for the service
    * @return List<ProgramDTO> value as parameter.
    *
    */
	public List<ProgramDTO> getProgram() {
		return program;
	}
	
	/**      
    *
    * Method setProgram.
    * Contains the set parameter for the service
    * 
    * @param List<ProgramDTO> program
    * 
    */
	public void setProgram(List<ProgramDTO> program) {
		this.program = program;
	}
	
  	
}
