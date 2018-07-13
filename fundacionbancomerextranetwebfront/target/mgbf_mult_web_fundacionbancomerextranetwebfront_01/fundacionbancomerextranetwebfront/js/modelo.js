/*Execution of services*/
/**
 * Function to execute services with post method.
 * @param {object} restToExe Object that contains the service's name to be executed, data to be sent, asyncronusly(it's false byr default),and what it does when finally correctly or with error(show modal), and if you want to show a wait modal.
 */
function restExec(restToExe){
	var secRestToExe = {
		"service": restToExe.service,
		"data": restToExe.data || {},
		"async": restToExe.async || false,
		"success": restToExe.success || rest_fnNothig,
		"error": restToExe.error || rest_fnShowError,
		"showWait": restToExe.showWait || false,
		"finallySuccess": restToExe.finallySuccess || rest_fnNothig,
		"finallyError": restToExe.finallyError || rest_fnNothig
	};
	var modal = secRestToExe.showWait?SCONFIG.getMessage('wait'):undefined;
	writeLog("datos a enviar: ",secRestToExe.data);
	writeLog("string ",JSON.stringify(secRestToExe.data));
    /**
     * Function to execute AJAX service with POST method.
     */
	rest_execute = function(){
		$.ajax({
			type : 'POST',
			dataType : 'json',
			contentType : "application/json; charset=utf-8",
			url : SCONFIG.get(secRestToExe.service),
			data : JSON.stringify(secRestToExe.data),
			async: secRestToExe.async,
			cache: false,
			success : function(data) {
				writeLog("RESPUESTA "+secRestToExe.service, data);
				if(secRestToExe.showWait){$("#"+SCONFIG.getMessage('wait').idModal).modal('hide');}
				secRestToExe.success(data);
				secRestToExe.finallySuccess(data);
			},
			error : function(error) {
				writeLog("ERROR EN SERVICIO "+secRestToExe.service, error);
				if(typeof error.responseText != "undefined" && error.responseText.indexOf("<title>Login</title>")!=-1){
					location.reload();
					return;
				}
				if(secRestToExe.showWait){$("#"+SCONFIG.getMessage('wait').idModal).modal('hide');}
				secRestToExe.error(error);
				secRestToExe.finallyError(error);
			}
		});
	}
	if(secRestToExe.showWait){

		$('#'+modal.idModal).modal();
		if(restToExe.customWait){
			rest_fnShowWait({
				idModal: modal.idModal,
				title: restToExe.customWait.title,
				message: restToExe.customWait.message
			});
		}else{
			rest_fnShowWait(modal);
		}
		setTimeout(function () {
	        rest_execute();
	    }, 400);
	}else{
		writeLog("else");
		rest_execute();
	}
	
}

/*General functions*/

/**
 * Function doesn't do anything.
 * @param {object} obj Return nothing.
 */
var rest_fnNothig = function(obj){writeLog("nothing");return};

/**
 * Function to show error modal.
 * @param {object} error Data of the error.
 */
var rest_fnShowError = function(error){
	modal = SCONFIG.getMessage('error');
	showModals(modal.title,modal.message,modal.idModal);
	if(typeof error.responseJSON == "undefined"){
		error["responseJSON"]={"message":"SIN DETALLE DEL ERROR"};
	}
	spn = $('<small></small>').text(error.responseJSON.message);
	pAlert = $("#"+modal.idModal).find("p.alert-danger");
	if(pAlert.length==0){
		$("#"+modal.idModal)
			.find("p")
				.after($("<p></p>")
						.addClass("alert alert-danger")
						.append(spn)
						);
	}else{pAlert.html(spn);}
	if(error.responseJSON.message=="No tienes privilegios para accesar"){
		$("#"+SCONFIG.getMessage('error').idModal).find("button").on("click",function(){
			location.reload();
		});
	}
	return;
}

/**
 * Function to show wait modal.
 * @param {object} modal Parameters like title, message and id.
 */
var rest_fnShowWait = function(modal){
	showModals(modal.title,modal.message,modal.idModal);
}

/**
 * Function that is executed when the service MGBFTC03-Average query response correctly(status code=200).
 * @param {object} resp Response of service MGBFTC03-Average query.
 */
var rest_fnAverageQuery = function(resp){
	writeLog("Average Query");
	writeLog(resp);
	scholar.statusQualifications.averagesSchoolGrade = resp.averagesScholarLevel;
	scholar.statusQualifications.constancyNextGrade = resp.constancyNextGrade;
	scholar.statusQualifications.indicatorMissingConstancy = resp.indicatorMissingConstancy;
}

/**
 * Function that is executed when the service MGBFTB04-Level and school grade query response correctly(status code=200).
 * @param {object} resp Response of service MGBFTB04-Level and school grade query.
 */
var rest_fnConsultLevelGrade = function(resp){
	writeLog("Consult Level & Grade");
	scholar.statusQualifications.schoolLevels=resp.schoolLevels;
}

/**
 * Function that is executed when the service MGBFTH02-Deposit modification response correctly(status code=200).
 * @param {object} resp Response of service MGBFTH02-Deposit modification.
 */
var rest_fnDepositModification = function(resp){
	writeLog("Deposit Modification");
    writeLog(resp);
}

/**
 * Function that is executed when the service MGBFTH01-Deposit query response correctly(status code=200).
 * @param {object} resp Response of service MGBFTH01-Deposit query.
 */
var rest_fnDepositQuery = function(resp){
	writeLog("Deposit Query");
	writeLog(resp);
	for(var i in resp.student[0].confirmDisp){
		if(resp.student[0].confirmDisp[i].statusScholarshipReceived == "Pendiente"){
			scholar.confirm.push({
				idMonth: resp.student[0].confirmDisp[i].monthConfirm+""+resp.student[0].confirmDisp[i].yearConfirm,
	            month: resp.student[0].confirmDisp[i].monthConfirm,
	            year: resp.student[0].confirmDisp[i].yearConfirm
			});
		} else {
			scholar.scholarship.confirmDispersion.push(resp.student[0].confirmDisp[i]);
		} 
	}
}

/**
 * Function that is executed when the service MGBFTB03-Detail scholar response correctly(status code=200).
 * @param {object} resp Response of service MGBFTB03-Detail scholar.
 */
var rest_fnDetailsScholar = function(resp){
	writeLog("Detail Scholar");
	writeLog(resp);
	scholar.studentID = resp.student[0].studentID;
	scholar.personalData.username = resp.userScholar;
	scholar.personalData.name = resp.student[0].name;
	scholar.personalData.lastName = resp.student[0].firstName;
	scholar.personalData.secondLastName = resp.student[0].lastName;
	scholar.personalData.originRegion = resp.student[0].originRegion;
	scholar.personalData.originState = resp.student[0].originState;
	scholar.personalData.cdOriginState = resp.student[0].cdOriginState;
	scholar.personalData.originMunicipality = resp.student[0].originMunicipality;
	scholar.personalData.cdOriginMunicipality = resp.student[0].cdOriginMunicipality;
	scholar.personalData.curp = resp.student[0].CURP;
	scholar.personalData.birthdate = resp.student[0].scholarBirthdate;
	scholar.personalData.age = resp.student[0].age;
	scholar.personalData.gender = resp.student[0].gender;
	scholar.personalData.assignedCR = resp.student[0].assignedCR;
	scholar.personalData.cdAssignedCR = resp.student[0].cdAssignedCR;
	scholar.personalData.scholarNumber = resp.student[0].scholarNumber;
	scholar.personalData.accountNumber = resp.student[0].accountNumber;
	scholar.personalData.profilePicture = resp.student[0].folioPhoto;
	
	scholar.scholarship.statusDispersion = resp.student[0].statusDispersion;
	scholar.scholarship.programName = resp.student[0].programName;
	scholar.scholarship.programType = resp.student[0].programKey;
	scholar.scholarship.modalityParticipation = resp.student[0].programScholar[0].modalityParticipation;
	
	scholar.schoolData.name = resp.student[0].schoolData[0].school[0].name;
	scholar.schoolData.domicile = resp.student[0].schoolData[0].school[0].domicile;
	scholar.schoolData.type = resp.student[0].schoolData[0].school[0].type;
	scholar.schoolData.initials = resp.student[0].schoolData[0].school[0].initials;
	scholar.schoolData.control = resp.student[0].schoolData[0].school[0].control;
	scholar.schoolData.cct = resp.student[0].schoolData[0].school[0].CCT;
	scholar.schoolData.state = resp.student[0].schoolData[0].school[0].state;
	scholar.schoolData.cdState = resp.student[0].schoolData[0].school[0].cdState;
	scholar.schoolData.municipality = resp.student[0].schoolData[0].school[0].municipality.trim();
	scholar.schoolData.cdMunicipality = resp.student[0].schoolData[0].school[0].cdMunicipality;
	scholar.schoolData.typeCareer = resp.student[0].schoolData[0].typeCareer;
	scholar.schoolData.nameCareer = resp.student[0].schoolData[0].nameCareer;
	scholar.schoolData.area = resp.student[0].schoolData[0].area;
	scholar.schoolData.turn = resp.student[0].schoolData[0].turn;
	scholar.schoolData.duration = resp.student[0].schoolData[0].duration;
	
	scholar.domicile = resp.student[0].domicile[0];
	
	scholar.contactData = resp.student[0].contactInf[0];
	
	scholar.statusQualifications.schoolGrade = resp.student[0].programScholar[0].schoolGrade;
	scholar.statusQualifications.schoolCycle = resp.student[0].schoolCycle;
	
	scholar.tutorData.name = resp.student[0].tutorData[0].tutorName;
	scholar.tutorData.lastName = resp.student[0].tutorData[0].firstNameTutor;
	scholar.tutorData.secondLastName = resp.student[0].tutorData[0].lastaNameTutor;
	scholar.tutorData.kinship = resp.student[0].tutorData[0].kinship;
	scholar.tutorData.kinshipType = resp.student[0].tutorData[0].kinshipType;
	scholar.program = resp.student[0].programScholar;
}

/**
 * Function that is executed when the service MGBFTB02-Upload/Modification scholar response correctly(status code=200).
 * @param {object} resp Response of service MGBFTB02-Upload/Modification scholar.
 */
var rest_fnModifUploadScholar = function(resp){
	writeLog("Modif & Upload Scholar");
	restExec({
		service:'DETAILS_SCHOLAR',
		data: {
			userScholar : scholar.personalData.username
		},
		success: rest_fnDetailsScholar
	});
}

/**
 * Function that is executed when the service MGBFTC02-Qualifications query response correctly(status code=200).
 * @param {object} resp Response of service MGBFTC02-Qualifications query.
 */
var rest_fnQualificationQuery = function(resp){
	writeLog("Qualification Query",resp);
	scholar.statusQualifications.averagesScholarLevel = [];
	scholar.statusQualifications.schoolLevels.forEach(function(_schoolLevel){
		_schoolLevel.scholarGrades.forEach(function(_actscholarGrade){
			for(i=0;i<20;i++){
				if(resp.qualifications){
					resp.qualifications.forEach(function(_qualification){
						if(_qualification.scholarLevel==_schoolLevel.scholarLevel&&_actscholarGrade.scholarGrade == _qualification.schoolGrade &&_qualification.schoolPeriod.substring(0,i.toString().length)== i.toString()){
							_qualification["isMissing"]=false;
							scholar.statusQualifications.averagesScholarLevel.push(_qualification);
						}
					});
				}
				if(resp.missingQualifications){
					resp.missingQualifications.forEach(function(_missingQualification){
						if(_missingQualification.scholarLevel==_schoolLevel.scholarLevel&&_actscholarGrade.scholarGrade == _missingQualification.schoolGrade &&  _missingQualification.schoolPeriod.substring(0,i.toString().length) == i.toString()){
							_missingQualification["isMissing"]=true;
							_missingQualification["folio"]="";
							scholar.statusQualifications.averagesScholarLevel.push(_missingQualification);
						}
					});
				}
			}
		});
	});
}

/**
 * Function that is executed when the service MGBFTC01-Upload qualifications response correctly(status code=200).
 * @param {object} resp Response of service MGBFTC01-Upload qualifications.
 */
var rest_fnUpdateQualification = function(resp){
	writeLog("Update Qualification");
	writeLog(resp);
	scholar.statusQualifications.averageSchoolGrade=resp.qualification;
}

/**
 * Function that is executed when the service MGBFTL01-Validate scholar qualifications response correctly(status code=200).
 * @param {object} resp Response of service MGBFTL01-Validate scholar.
 */
var rest_fnValidationScholar = function(resp){
	writeLog("Validation Scholar");
	writeLog(resp);
}

/**
 * Function that is executed when the service MGBFTP01-Parameters query response correctly(status code=200).
 * @param {object} resp resp Response of service MGBFTP01-Parameters query.
 */
var rest_fnConsultParameters = function(resp){
	writeLog("rest_fnConsultParameters",resp.parameters[0].parameterType);
	switch(resp.parameters[0].parameterType){
		case "SX":
			for(var i in resp.parameters){
				combos.gender[i]=resp.parameters[i].parameterDescription;
			}
			break;
		case "PAREN":
			for(var i in resp.parameters){
				combos.kindship[i]=resp.parameters[i].parameterDescription;
			}
			break;
		case "TPVIA":
			for(var i in resp.parameters){
				combos.typeOfViality[i]=resp.parameters[i].parameterDescription;
			}
			break;
		case "CDRB":
			writeLog("Entra a CDRB");
			for(var i in resp.parameters){
				combos.cdRB[i]=resp.parameters[i].parameterDescription;
				writeLog(resp.parameters[i].parameterDescription);
			}
			break;
	}
}

/**
 * Funtion to query base64 of the profile picture.
 * @param {object}   resp_photo Folio of profile picture.
 * @param {boolean} _isInit Variable to know if scholar have a profile picture or not.
 */
var rest_fnUploadedPhoto = function(resp_photo, _isInit){
	writeLog("rest_fnUploadedPhoto",resp_photo);//folio
	restExec({
		"service":'GET_DOCUMENT',
		"async": !_isInit,
		"data": {
			 "aplicationName": "BECAS",
			 "listReferenceNumber": [
             	resp_photo.folio
			 ],
			 "features": [
				{"id":"opcion",
		         "name":"base64"
				}
			 ]
		 },
		"error": function(error_ph){
			console.error("Error al consultar foto ", error_ph);
		},
		"success": function(resp_up_){
			if((typeof resp_up_.listDocuments[0] != "undefined") && (typeof resp_up_.listDocuments[0].document != "undefined") && (typeof resp_up_.listDocuments[0].document.data != "undefined")){
				writeLog("GET_DOCUMENT",resp_up_);
				scholar.personalData.base64ProfilePicture = "data:image/jpeg;base64,"+resp_up_.listDocuments[0].document.data;
				if(!_isInit){fn_loadProfilePicture();}
			}
		}
	});
}

/**
 * Function to upload profile picture.
 * @param {object} _data Data of picture to be sent.
 */
var pre_fnSendDocument = function(_data){
	tDoc = _data.typeDocument.split("|");
	restExec({
		"service":'SEND_DOCUMENT',
		"showWait": true,
		"customWait": {
			"title": "Guardando tu foto de perfil",
			"message": "Espera un momento por favor"
		},
		"data": {
			"imagen": {
				"moduleIndicator": _data.moduleIndicator,
				"studentID": scholar.studentID,
				"programType": scholar.scholarship.programType,
				"typeDocument": _data.typeDocument,
				"schoolGrade": scholar.statusQualifications.schoolGrade,
				"schoolCycle": scholar.statusQualifications.schoolCycle,
				"schoolPeriod": "",
				"userCurrent": scholar.studentID
			},
			"archiving": {
				"aplicationName": "becas",
				"features": [
					{"id": "numeroCliente","name": scholar.personalData.scholarNumber},
					{"id": "numeroCuenta","name": scholar.personalData.accountNumber+""},
					{"id": "cr","name": scholar.personalData.cdAssignedCR+""},
					{"id": "nombreBeca","name": scholar.scholarship.programType},
					{"id": "nombreDoc","name": tDoc[1]},
					{"id": "cveDoc","name": tDoc[0]},
					{"id": "ciclo","name": scholar.statusQualifications.schoolCycle},
					{"id": "extension","name": _data.ext},
					{"id": "nombreArchivo","name": _data.filename},
					{"id": "usuario","name": scholar.studentID+""},
					{"id": "primera","name": "true"},
					{"id": "ultima","name": "true"}
				],
				"document": {
					"data": _data.base64
				}
			}
		},
		"success": function(r_photo){
			rest_fnUploadedPhoto(r_photo, false);
		},
		"finallyError": function (error){
			writeLog("error ",error);
		},
		"finallySuccess": function(){
			showModals("Tu foto se ha cargado satisfacotiamente","Gracias por la espera","savedFile");
		}
	});
}

/**
 * Function to upload constancy of next grade or report card.
 * @param {object} _data Information of document(s).
 */
var pre_fnSendMultiDocument = function(_data){
	tDoc = _data.typeDocument.split("|");
	restExec({
		"service":'SEND_MULT_DOCUMENT',
		"data": {
			"aplicationName": "becas",
			"features": [
				{"id": "numeroCliente","name": scholar.personalData.scholarNumber},
				{"id": "numeroCuenta","name": scholar.personalData.accountNumber+""},
				{"id": "cr","name": scholar.personalData.cdAssignedCR},
				{"id": "nombreBeca","name": scholar.scholarship.programType},
				{"id": "nombreDoc","name": tDoc[1]},
				{"id": "cveDoc","name": tDoc[0]},
				{"id": "ciclo","name": scholar.statusQualifications.schoolCycle},
				{"id": "extension","name": _data.ext},
				{"id": "nombreArchivo","name": _data.filename},
				{"id": "usuario","name": scholar.studentID+""},
				{"id": "primera","name": _data.first},
				{"id": "ultima","name": _data.last}
			],
			"document": {
				"data": _data.base64
			}
		},
		"success": _data.success,
		"error": _data.error
	});
}

/**
 * Function to get URL of the constancy or report card and you can see it on iframe with IMAX visor.
 * @param {string} folio Folio of document to show.
 */
var pre_fnloadFile = function(folio){
	$('#show_file').attr('src',SCONFIG.getVisor(folio));
	$("#consultFiles").modal('show');
}

/**
 * Function to execute the service MGBFTC02-Qualifications query.
 */
var rest_reloadQualifications = function(){
	restExec({
		service:'QUALIFICATION_QUERY',
		async: false,
		data: {
			studentID: scholar.studentID,
		    scholarLevel: "",
		    schoolGrade : "",
		    schoolPeriod : ""
		},
		success: rest_fnQualificationQuery,
		error: rest_fnNothig
	});
}

/**
 * Function to execute the services MGBFTC03-Average query.
 */
var rest_averageQuery = function(){
	restExec({
		service:'AVERAGE_QUERY',
		async: false,
		data: {
			studentID: scholar.studentID,
			scholarLevel:"",
			schoolGrade:""
		},
		success: rest_fnAverageQuery
	});
}

/**
 * Function that save alerts on scholar object.
 * @param {object} resp_alerts Response of service MGBFTK01-Alerts.
 */
var rest_fnAlerts = function(resp_alerts){
	scholar.alerts=resp_alerts.alertMessages;
	writeLog("guarda alertas: ",resp_alerts.alertMessages);
}

/**
 * Functiom to save states on statesTransactions object.
 * @param {object} r_States Response of service listState.
 */
var rest_fnStates = function(r_States){
	statesTransactions = r_States.stateTransactions;
}

/**
 * Function to execute the service listMunicipality.
 * @param {number} state_to_get Number of state that you want to know its municipalities.
 */
var rest_getMunicipality = function(state_to_get){
	restExec({
		service:'GET_MUNICIPALITY',
		showWait: true,
		customWait: {
			title: "Consultando datos",
			message: "Por favor espera"
		},
		data: {
			state : state_to_get
		},
		success: fn_listMunicipality
	});
}

/**
 * Function that is executed when the service updatePasswordScholarshipUser response correctly(status code=200).
 * @param {object} resp Response of service updatePasswordScholarshipUser.
 */
var rest_fnUpdatePassword = function(resp){
	writeLog("rest_fnUpdatePassword");
	writeLog(resp);
		var errorM={
				responseJSON:{
					message:resp.statusDescription+"."
				},
				serviceName:resp.statusCode
			};
		if(resp.statusCode == "MDO_000"){
			showModals("Tu contrase\u00F1a se ha actualizado correctamente","","savedFile");
			$("#btnCancelsChangePassword").click();
		}else if(resp.statusCode == "MDO_003" ||
				 resp.statusCode == "MDO_008" ||
				 resp.statusCode == "MDO_013" ||
				 resp.statusCode == "MDO_015" ||
				 resp.statusCode == "MDO_017" ||
				 resp.statusCode == "MDO_020" ||
				 resp.statusCode == "MDO_021")rest_fnShowError(errorM);
		else rest_fnShowError("Ocurri\u00f3 un problema, por favor intentalo m\u00e1s tarde");
}
