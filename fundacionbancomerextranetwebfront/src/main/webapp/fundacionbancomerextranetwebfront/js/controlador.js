//****************************************Dojo's settings.**************************************//
dojoConfig = {
    isDebug: true,
    parseOnLoad: false
};
//***************************Dojo's functions.************************//
//Enable templates.
dojo.require("dijit._Templated");
//Enable wipe functions.
dojo.require("dojo.fx");

//Enviroment configuration to enable logs.
var app_conf = {
		writeLog : false
}
var servOrigin = window.location.origin;
if(servOrigin.indexOf("localhost")!=-1||
	servOrigin.indexOf("150.250.238.172")!=-1||
	servOrigin.indexOf("150.250.238.173")!=-1){
		app_conf.writeLog = true;
}
/**
 * writeLog allows to write console logs only on local, develop and test server, this can be changed by the object app_conf.writeLog value.
 */
var writeLog = function(){
	try{
		if(app_conf.writeLog){
			console.log.apply(this,writeLog.arguments);
		}
	}catch(err){}
}
 /*
 *This function load a template in specific id/element of html, after that execute onload function(defined within plantillas.conf.js).
 * @param {string} idDOM        Id of the element where the template is inserted.
 * @param {object} templateData JSON of the template to insert from templates.conf.js.
 * @param {object} data         JSON that contains a dinamic data to show on templete.
 */
function loadTemplate(idDOM, templateData, data) {
    if(!templateData){console.error("loadTemplate: templateData is undefined ["+idDOM+"]");return;}
    strTemplate = dojo.cache(templateData.workspace, templateData.html);
    if(data){
        varsTemplate = strTemplate.match(/\u0024\u007B[a-zA-Z0-9_]*\u007D/g);
        if(varsTemplate){
        	for (it = 0; it < varsTemplate.length; it++) {
                varsTemplate[it].substring(2, varsTemplate[it].length - 1)
                tempData = varsTemplate[it];
                nameData = tempData.substring(2, tempData.length - 1);
                if(typeof data[nameData] != "undefined"){strTemplate = strTemplate.replace(tempData, data[nameData]);}
                else{console.warn("loadTemplate: "+nameData+" is null ["+templateData.html+"]");}
            }
        }
    }else{console.warn("loadTemplate: data is null ["+templateData.html+"]");}
    node = dojo.byId(idDOM);
    if(!node){console.error("loadTemplate: Node "+idDOM+" doesn't exist ["+templateData.html+"]");return;}
    node.innerHTML = strTemplate;
    templateData.onload();
}

/**
 * Get root path of page.
 * @returns {string} URL.
 */
function getRootPath() {
    _url = window.location.href;
    if (_url.charAt(_url.length - 1) === "#") {
        _url=_url.substring(0,_url.length-1);
    }
    if (_url.charAt(_url.length - 1) === "/") {
        return _url;
    }
    return _url.substring(0, _url.lastIndexOf("/"));
}

/**
 * Function to show modals.
 * @param {string} asunto  Principal text.
 * @param {string} mensaje Reason/message.
 * @param {string} modalId Id of modal that you want to show.
 */
function showModals (asunto, mensaje, modalId) {
	$(".modal.show").each(function(index) {
		if(($(this).data('bs.modal') || {})._isShown)	$(this).modal('hide');
	});
    $("#"+modalId).find("h2").text(asunto);
    $("#"+modalId).find("p").text(mensaje);
    $("#"+modalId).modal('show');
}

/**
 * Function to load the header with scholar's personal information.
 */
function loadScholarHeader(){
	loadTemplate("scholarheader", templates.scholarheader, {
        scholarName : scholar.personalData.name,
        schoolGrade : scholar.statusQualifications.schoolGrade,
        program : scholar.scholarship.programName,
        actLevel : scholar.statusQualifications.schoolLevels[scholar.statusQualifications.schoolLevels.length-1].scholarLevel
    });
}

/**
 * Function to load principal page(Index).
 */
function loadIndex(){
    loadTemplate("templateInicio", templates.principal,{});
}

/**
 * It contains all functions that are executed when load the page finished.
 * @param {function} function (Group of functions to execute when page is loading).
 */
dojo.addOnLoad(function () {
	var l_rootPath = getRootPath();
    dojo.registerModulePath("vistas", l_rootPath + "fundacionbancomerextranetwebfront/vistas");
    dojo.registerModulePath("home", l_rootPath + "fundacionbancomerextranetwebfront/vistas/home");
    dojo.registerModulePath("beca", l_rootPath + "fundacionbancomerextranetwebfront/vistas/mibeca");
    dojo.registerModulePath("calificaciones", l_rootPath + "fundacionbancomerextranetwebfront/vistas/miscalificaciones");
    dojo.registerModulePath("datos", l_rootPath + "fundacionbancomerextranetwebfront/vistas/misdatos");
    /**
     * Function to shutdown session.
     */
    var logout = function(){
        showModals("Cerrando sesi\u00F3n","Espera un momento",SCONFIG.getMessage('wait').idModal);
        setTimeout(function () {
        	restExec({
    			service:'TERMINATE_SESSION',
    			async: false,
    			data: {
    			},
    			success: function(resp){
    				writeLog("se cerró sesión en back end");
    			},
    			error: function(error){
    				writeLog("no se cerró sesión en back end");
    			}
    		});
        	$.ajax({
    			type : 'GET',
    			dataType : 'html',
    			contentType : "application/json; charset=utf-8",
    			url : window.location.origin+"/pkmslogout.form",
    			async: true,
    			success : function(data) {
    				$(".index").css({display: "none"});
    				$("#templateInicio").css({display: "none"});
    				showModals("Tu sesi\u00F3n ha terminado","","savedFile");
    				$("#savedFile").find("button.btn-primary").click(function (){
    					location.reload();
    				})
    			},
    			error : function(error) {
    				writeLog("error",data);
    				$("#savedFile").modal("hide");
    			}
    		});
	    }, 400);
    }
    
    _modal = SCONFIG.getMessage('wait');
    var hasErrorIndex=false;
    var contListServicesRest = 0;
    var listServicesRest = [
        /**
        * Function that contains the data to execute the service: MGBFTB03-Detail of scholar.
        * @returns {object} Returns an object with the name of service to execute, the data to be sent, and what it does when executed correctly or failed.
        */
		function(){return {
			service:'DETAILS_SCHOLAR',
			data: {
				userScholar : ivUser
			},
			success: rest_fnDetailsScholar,
			finallyError: function(error){
				hasErrorIndex = true;
				$("#"+_modal.idModal).removeAttr("style");
			}
		}},
		/**
		 * Function that contains the data to execute the service: MGBFTH01-Deposit query.
		 * @returns {object} Returns an object with the name of service to execute, the data to be sent, and what it does when executed correctly or failed.
		 */
		function(){return {
			service:'DEPOSIT_QUERY',
			data: {
				userCurrent : scholar.studentID,
			    studentID : scholar.studentID,
			    programType : scholar.scholarship.programType,
			    statusScholarshipReceived : ""
			},
			success: rest_fnDepositQuery,
			finallyError: function(error){
				hasErrorIndex = true;
				$("#"+_modal.idModal).removeAttr("style");
			}
		}},
		/**
		 * Function that contains the data to execute the service: MGBFTB04-Level and school grade query.
		 * @returns {object} Returns an object with the name of service to execute, the data to be sent, and what it does when executed correctly or failed.
		 */
		function(){return {
			service:'CONSULT_LEVELGRADE',
			data: {
				studentID: scholar.studentID,
				scholarLevel:""
			},
			success: rest_fnConsultLevelGrade,
			finallySuccess: function(res_){
				writeLog("CONSULT_LEVELGRADE",res_);
			},
			finallyError: function(error){
				hasErrorIndex = true;
				$("#"+_modal.idModal).removeAttr("style");
			}
		}},
		/**
		 * Function that contains the data to execute the service: MGBFTC03-Average query.
		 * @returns {object} Returns an object with the name of service to execute, the data to be sent, and what it does when executed correctly or failed.
		 */
		function(){return {
			"service":'AVERAGE_QUERY',
			data: {
				studentID: scholar.studentID,
				scholarLevel:"",
				schoolGrade:""
			},
			success: rest_fnAverageQuery,
			finallySuccess: function(res_){
				writeLog("AVERAGE_QUERY",res_);
			},
			finallyError: function(error){
				hasErrorIndex = true;
				$("#"+_modal.idModal).removeAttr("style");
			}
		}},
		/**
		 * Function that contains the data to execute the service: MGBFTP01-Parameters query.
		 * @returns {object} Returns an object with the name of service to execute, the data to be sent, and what it does when executed correctly or failed.
		 */
		function(){return {
			service:'CONSULT_PARAMETERS',
			data: {
				parameterType: "CDRB"
			},
			success: rest_fnConsultParameters,
			finallyError: function(error){
				hasErrorIndex = true;
				$("#"+_modal.idModal).removeAttr("style");
			}
		}},
		/**
		 * Function that contains the data to execute the service: MGBFTK01-Get alerts.
		 * @returns {object} Returns an object with the name of service to execute, the data to be sent, and what it does when executed correctly or failed.
		 */
		function(){return {
			service:'GET_ALERTS',
			data: {
				"userScholar": scholar.personalData.username
			},
			error: function(err_a){console.error("GET_ALERTS",err_a)},
			success: rest_fnAlerts
		}},
		/**
		 * Function that contains the data to execute the service: MGBFTC02-Qualifications query.
		 * @returns {object} Returns an object with the name of service to execute, the data to be sent, and what it does when executed correctly or failed.
		 */
		function(){return {
			service:'QUALIFICATION_QUERY',
			data: {
				studentID: scholar.studentID,
			    scholarLevel: "",
			    schoolGrade : "",
			    schoolPeriod : ""
			},
			success: rest_fnQualificationQuery,
			finallyError: function(error){
				hasError = true;
				$("#"+_modal.idModal).removeAttr("style");
			},
			finallySuccess: function(res_){
				if(scholar.personalData.profilePicture.trim()){
					rest_fnUploadedPhoto({
						folio: scholar.personalData.profilePicture
					},true);
				}
				writeLog("QUALIFICATION_QUERY",res_);
				loadScholarHeader();
				$(".index").removeAttr("style");
				$("#"+_modal.idModal).removeAttr("style");
			}
		}}
    ]
    do {
    	restExec(listServicesRest[contListServicesRest]());
    	contListServicesRest++;
    }while(!hasErrorIndex && contListServicesRest<listServicesRest.length);
    $("#secLoading").remove();
    if(hasErrorIndex){$("#"+SCONFIG.getMessage('error').idModal).find("button").on("click",logout);}
    $(".exitarea > a").click(function (event) {
    	event.preventDefault();
    	logout();
	});
    
  //********************************Home   ********************************//

    $("#btnHome").click(function (event) {
    	event.preventDefault();
        $("#btnMisCalificaciones, #btnMisDatos, #btnMisTutores, #btnMiBeca").removeClass("active");
        loadIndex();
	});

    //********************************Mi Beca ********************************//

    $("#btnMiBeca").click(function (event) {
    	event.preventDefault();
        $("#btnMiBeca").addClass("active");
        $("#btnMisCalificaciones, #btnMisDatos, #btnMisTutores").removeClass("active");
        loadTemplate("templateInicio", templates.miBeca, {
            name : scholar.personalData.name ,
            schoolGrade : scholar.statusQualifications.schoolGrade,
            program : scholar.scholarship.programName,
            actLevel : scholar.statusQualifications.schoolLevels[scholar.statusQualifications.schoolLevels.length-1].scholarLevel,
            status : scholar.scholarship.statusDispersion,
            programStatus: scholar.program[0].status,
            program: scholar.scholarship.programName,
            modality: scholar.scholarship.modalityParticipation,
            state: scholar.personalData.originState,
            municipality: scholar.personalData.originMunicipality,
            region: scholar.personalData.originRegion
        });
    });


    //********************************Mis Calificaciones ********************************//

    $("#btnMisCalificaciones").click(function (event) {
    	event.preventDefault();
        $("#btnMisCalificaciones").addClass("active");
        $("#btnMiBeca, #btnMisDatos, #btnMisTutores").removeClass("active");
        loadTemplate("templateInicio", templates.misCalificaciones, {
            name : scholar.personalData.name ,
            schoolGrade : scholar.statusQualifications.schoolGrade,
            program : scholar.scholarship.programName,
            actLevel : scholar.statusQualifications.schoolLevels[scholar.statusQualifications.schoolLevels.length-1].scholarLevel
        });
    });

    //*************************************Mis Datos ***********************************//

    $("#btnMisDatos").click(function (event) {
    	event.preventDefault();
    	var hasErrorQ=false;
	    var cont = 0;
	    var listCombos = [
            /**
             * Function that contains the data to execute the service: MGBFTP01-Parameters query(gender).
             * @returns {object} Returns an object with the name of service to execute, the data to be sent, and what it does when executed correctly or failed.
             */
				function(){return {
					service:'CONSULT_PARAMETERS',
					data: {
						parameterType: "SX"
					},
					success: rest_fnConsultParameters,
					finallyError: function(error){
						hasErrorQ = true;
					}
				}},
			/**
			 * Function that contains the data to execute the service: MGBFTP01-Parameters query(kindship).
			 * @returns {object} Returns an object with the name of service to execute, the data to be sent, and what it does when executed correctly or failed.
			 */
				function(){return {
					service:'CONSULT_PARAMETERS',
					data: {
						parameterType: "PAREN"
					},
					success: rest_fnConsultParameters,
					finallyError: function(error){
						hasErrorQ = true;
					}
				}},
			/**
			 * Function that contains the data to execute the service: MGBFTP01-Parameters query(type of viality).
			 * @returns {object} Returns an object with the name of service to execute, the data to be sent, and what it does when executed correctly or failed.
			 */
				function(){return {
					service:'CONSULT_PARAMETERS',
					data: {
						parameterType: "TPVIA"
					},
					success: rest_fnConsultParameters,
					finallyError: function(error){
						hasErrorQ = true;
					}
				}},
			/**
			 * Function that contains the data to execute the service: listState.
			 * @returns {object} Returns an object with the name of service to execute, the data to be sent, and what it does when executed correctly or failed.
			 */
				function(){return {
					service:'GET_STATES',
					data: {},
					success: rest_fnStates,
					finallyError: function(error){
						hasErrorQ = true;
					},
					finallySuccess: function(){
						$("#waitModal").modal("hide");
						}
					}}
				 ];
	    if(combos.gender == "" || combos.typeOfViality == "" || combos.kindship == "" || !statesTransactions.length){
	    	showModals("Cargando tu información","Espera un momento",SCONFIG.getMessage('wait').idModal);
	    	setTimeout(function () {
	        	 do {
	        	    	restExec(listCombos[cont]());
	        	    	cont++;
	        	    } while(!hasErrorQ && cont<listCombos.length);
	        	 loadMisDatos();
	        	 fn_afterMisDatos();
	        	 fn_afterMisDatos = fn_nothing;
	        },400);
    	}else {
    		loadMisDatos();
    		fn_afterMisDatos();
    		fn_afterMisDatos = fn_nothing;
    	}
	});
});
