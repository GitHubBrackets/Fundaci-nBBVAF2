//***************************************Regular expression******************************************//
//CURP
    const expRegCurp = /^[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[HM]{1}(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]{1}[0-9]{1}$/;
//Email
    const expRegEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
//Qualification with 2 decimals
    const expRegCalif=/10$|^\d(\.\d\d?)?$/;
//Numbers in ascending order.
    const expRegAscNum = /01|12|23|34|45|56|67|78|89/;
//Numbers in descending order.
    const expRegDesNum = /98|87|76|65|54|43|32|21|10/;
//Doesn't allow repeat numbers o letters more than 2 times.
    const expRegRepeat= /((.+)?)((.)\4\4)((.+)?)/;
    const expRegHasNumber= /\d/;
    const expRegHasLetter= /[a-zA-Z]/;


/**
 * Variable doesn't do anything.
 */
var fn_nothing = function () {
    return;
};

/**
 * Function that provides checkbox's funcionality to confirm deposit.
 */
var fn_confirmacion = function () {
    checkBoxConfirm();
};

/**
 * This function get the combo of status received pay.
 */
var fn_comboConfirmacionDepo = function (){
	for(var optionD in combos.cdRB){
    	$("select[name='status']").append("<option value="+combos.cdRB[optionD]+">"+combos.cdRB[optionD]+"</option>");
    }
};

/**
 * Function of files selection.
 */
var fn_selectArchivos = function () {
    requerido();
    $('[data-toggle="tooltip"]').tooltip({placement: "top"});
    var fileIdCont = 0;
    var errorFileTimer;
    var allFiles = {};

    $('#uploadFiles').on('hidden.bs.modal', function (e) {
        /*var token = $(this).find('[name="token"]').val();
        $('#slot_' + becaId + '_' + fileId).val(token);*/
        myDropzone.removeAllFiles(true);
        $('#upload-files').parent().removeClass('col-sm-6');
        $(".template-preview-wrapper").removeAttr('style');
    });
    $('#consultFiles').on('hidden.bs.modal', function(e) {
		$(this).find('#show_file').attr("src","");
	});

    Dropzone.autoDiscover = false;

    myDropzone = new Dropzone("#upload-files", {
            acceptedFiles: 'application/pdf,image/jpeg',
            dictFileTooBig: "El archivo supera el tama\u00F1o permitido de {{maxFilesize}} MiB",
            dictMaxFilesExceeded: "N\u00FAmero m\u00E1ximo de archivos alcanzado",
            dictInvalidFileType: "S\u00F3lo se permiten archivos JPG y PDF",
            autoProcessQueue: false,
            dictDefaultMessage: '',
            maxFiles: 2,
            maxFilesize: 10,
            clickable: '#uplddFiles',
            previewTemplate: (document.getElementById('template-preview'))
                ? document.getElementById('template-preview').innerHTML : '',
            previewsContainer: "#template-preview",
            url: "/",
            init: function () {
                this.on("addedfile", function (file) {
                });
                this.on("drop", function () {
                });
            },
            accept: function (file, done) {
                this.element.classList.remove('hover');
                this.element.parentElement.classList.add('col-sm-6');
                document.querySelector('.template-preview-wrapper')
                        .style.display = "block";
                file["idFile"] = fileIdCont;
                var button = file.previewTemplate.querySelector('.btn-delete-file');
                var myFile = file;
                button.addEventListener('click', function(){ this.removeFile(myFile) });
                allFiles[fileIdCont]={
                    "active": true,
                    "base64": ""
                };
                fileIdCont++;
                done();
            },
            removedfile: function(file){
                file.previewTemplate.remove();
                if(this.getAcceptedFiles().length==0){
                    $('#upload-files').parent().removeClass('col-sm-6');
                    $(".template-preview-wrapper").removeAttr('style');
                }
            },
            dragleave: function (event) {
              this.element.classList.remove('hover');
            },
            dragover: function (event) {
              if (!this.element.classList.contains('hover')) {
                this.element.classList.add('hover');
              }
            },
            error: function (file, errorMEssage) {
                if (!file.accepted) {
                    this.removeFile(file);
                    this.element.classList.remove('hover');
                    if(errorFileTimer){clearTimeout(errorFileTimer);}
                    $("#mssgErrorFile").children("span").text(errorMEssage);
                    $("#mssgErrorFile").slideDown();
                    errorFileTimer=setTimeout(function(){
                        $("#mssgErrorFile").slideUp();
                    },3000);
                }
            },
        });

    Dropzone.options.myDropzone = false;
    $('#saveallFiles').on('click',function(event){
        event.preventDefault();
        var _allFiles = myDropzone.getAcceptedFiles();
        var _fileData = $("#uploadFiles");
        var _typeDocument = _fileData.attr("data-document");
        var _moduleIndicator = "SE";
        showModals("Guardando tu(s) documento(s)","Espera un momento",SCONFIG.getMessage('wait').idModal);
        var _folioArchiving = "";
        function readIndexFile(_i){
        	if(_i==_allFiles.length){return;}
        	currentFile = _allFiles[_i];
        	var reader = new FileReader();
            reader.onload = function(e) {
            	if(_i==_allFiles.length){return;}
                var base64URL = e.target.result;
                fext = currentFile.name.split(".");
                fext = fext[fext.length-1];
                writeLog("Enviando archivo.. "+currentFile.name);
                var _end_fn = function(resp){
                	writeLog("resp",resp);
                }
                if(_i==_allFiles.length-1){//cuando es el &uacute;ltimo archivo
                	_end_fn = function(data){//guarda el folio con el servicio alta de imagenes
                		writeLog("_end_fn",data);
                		restExec({
                			service:'UPLOAD_IMAGE',
                			data: {
                				moduleIndicator: _moduleIndicator,
                				studentID: scholar.studentID+"",
                				programType: scholar.scholarship.programType,
                				typeDocument: _typeDocument,
                				schoolGrade: _fileData.attr("data-grade"),
                				schoolCycle: scholar.statusQualifications.schoolCycle,
                				schoolPeriod: _fileData.attr("data-period"),
                				folio: data.referenceNumber,
                				userCurrent: scholar.studentID+""
                			},
                			success: function(data_resp){
                				if(_typeDocument=="1|Boleta"){
                					writeLog("--- subió boleta");
                					rest_reloadQualifications();
                				}else{
                					writeLog("--- subió constancia");
                					rest_averageQuery();
                				}
                				writeLog("success servicio",data_resp);
                				$("#"+SCONFIG.getMessage('wait').idModal).modal('hide');
                	            showModals("Tu documento se ha guardado satisfactoriamente","Gracias por la espera","savedFile");
                	            $("#savedFile").find("button").on("click",function(){
                	            	fn_loadStatusQualifications();
                	            	$($(this)).prop('onclick',null).off('click');
                	            });
                			}
                		});
                	}
            	}
                pre_fnSendMultiDocument({
                	ext: fext,
                	filename: currentFile.name,
                	typeDocument: _typeDocument,
                	first: (_i==0)+"",
                	last: (_i==_allFiles.length-1)+"",
                	base64: (base64URL.split(";base64,"))[1],
                	success: _end_fn
                });
                readIndexFile(_i+1);
            };
            reader.readAsDataURL(currentFile);
        }
        readIndexFile(0);
    });
    fn_qualificationValidate();
    loadShowUpdateFile();
};

/**
 * Function to select/upload profile picture.
 */
var fn_selectProfilePicture = function () {
    requerido();
    $('[data-toggle="tooltip"]').tooltip({placement: "top"});
    var errorPictureTimer;
    var successPictureTimer;
    $('#uploadScholarImage').on('hidden.bs.modal', function (e) {
        myPicture.removeAllFiles(true);
    });

    Dropzone.autoDiscover = false;
    var myPicture = new Dropzone("#upload-scholarImage", {
        acceptedFiles: 'image/jpeg',
        dictFileTooBig: "El archivo supera el tama\u00F1o permitido de {{maxFilesize}} MiB",
        dictMaxFilesExceeded: "S\u00F3lo puedes elegir una foto de perfil",
        dictInvalidFileType: "Tu foto debe ser en formato JPG",
        autoProcessQueue: false,
        dictDefaultMessage: '',
        maxFiles: 1,
        maxFilesize: 5,
        previewTemplate : '<div style="display:none"></div>',
        clickable: '#uploadImage',
        url: "/",
        init: function () {
            this.on("addedfile", function (file) {
            });
            this.on("drop", function () {
            });
        },
        accept: function (file, done) {
            this.element.classList.remove('hover');
            var reader = new FileReader();
            reader.onload = function(e) {
                var base64URL = e.target.result;
                if(base64URL !== "" ){
                    $("#uploadScholarImage").modal('hide');
                    fext = file.name.split(".");
                    fext = fext[fext.length-1];
                    pre_fnSendDocument({
                    	typeDocument: "10|Foto",
                    	moduleIndicator: "FB",
                    	ext: fext,
                    	filename: file.name,
                    	base64: (base64URL.split(";base64,"))[1],
                    });
                }
            };
            reader.readAsDataURL(file);
            done();
        },
        dragleave: function (event) {
          this.element.classList.remove('hover');
        },
        dragover: function (event) {
          if (!this.element.classList.contains('hover')){
            this.element.classList.add('hover');
          }
        },
        error: function (file, errorMEssage) {
            if (!file.accepted) {
                this.removeFile(file);
                this.element.classList.remove('hover');
                if(errorPictureTimer){clearTimeout(errorPictureTimer);}
                $("#mssgError").children("span").text(errorMEssage);
                $("#mssgError").slideDown();
                errorFileTimer=setTimeout(function(){
                    $("#mssgError").slideUp();
                },3000);
            }
        },
    });
};

/**
 * Function to load qualifications of the scholar.
 */
var fn_loadStatusQualifications = function(){
	writeLog("fn_loadStatusQualifications");
	var selectedScholarLevel = $("select[name='cursando'] option:selected").val();
	var selectedScholarGrade = $("select[name='grado'] option:selected").val();
	var i_locationAverage = -1,
	    j_locationAverage = -1;
	
	for(i = 0; i<scholar.statusQualifications.averagesSchoolGrade.length; i++){
    	if(scholar.statusQualifications.averagesSchoolGrade[i].scholarLevel == selectedScholarLevel){
    		for(var j in scholar.statusQualifications.averagesSchoolGrade[i].averagesSchoolGrade){
    			if (scholar.statusQualifications.averagesSchoolGrade[i].averagesSchoolGrade[j].schoolGrade == selectedScholarGrade){
    				i_locationAverage = i;
    				j_locationAverage = j;
    				loadTemplate("calificacionesBecario", templates.calificacion , {
    					actLevel: selectedScholarLevel,
    					average: scholar.statusQualifications.averagesSchoolGrade[i].averagesSchoolGrade[j].averageSchoolGrade
    			    });
    				break;
    			}
    		}
    		break;
    	}
    };
	
	scholar.statusQualifications.averagesScholarLevel.forEach(function(curr_averageScholarLevel, ind){
		if(curr_averageScholarLevel.scholarLevel==selectedScholarLevel&&curr_averageScholarLevel.schoolGrade==selectedScholarGrade){
	        var div1 = document.createElement("div");
	        var att = document.createAttribute("id");
	        att.value = "calif" + ind;
	        div1.setAttributeNode(att);
	        document.getElementById("calificacionA").appendChild(div1);
	        Tempstyle='style="display:none;"';
	        if(curr_averageScholarLevel.folio!=""||curr_averageScholarLevel.qualification!=0){Tempstyle='';}
	        loadTemplate("calif"+ind, templates.areaCalificacion , {
	        	periodEval : curr_averageScholarLevel.schoolPeriod,
	        	average : curr_averageScholarLevel.qualification,
	        	schoolGrade: curr_averageScholarLevel.schoolGrade,
	        	showboleta:Tempstyle,
	            index : ind
	        });
	        tempTemplate = (curr_averageScholarLevel.folio==""||curr_averageScholarLevel.isMissing)?templates.emptyBoleta:templates.boleta;
	        
	        
	        loadTemplate("boleta-area-"+ind, tempTemplate , {
	        	schoolGrade: curr_averageScholarLevel.schoolGrade,
	        	schoolPeriod: curr_averageScholarLevel.schoolPeriod,
	            index: ind,
	            folio: curr_averageScholarLevel.folio
	        });
		}
	});
	
	if(i_locationAverage != -1 && j_locationAverage != -1){
		constancy = scholar.statusQualifications.averagesSchoolGrade[i_locationAverage].averagesSchoolGrade[j_locationAverage].folio.split("|");
		if(constancy.length == 2){
			var div1 = document.createElement("div");
	        div1.setAttribute("id","missingConstancy");
	        var tempTemplate = templates.constancia;
			if(constancy[1]==""){
				tempTemplate = templates.emptyConstancia;
			}
			document.getElementById("calificacionA").appendChild(div1);
	        loadTemplate("missingConstancy", tempTemplate , {
	        	schoolGrade: constancy[0],
	        	schoolPeriod: "",
	        	folio: constancy[1]
	        });
		}
	}
	fn_selectArchivos();
	loadShowUpdateFile();
}

/**
 * Function that is executed when loading the header is finished, executes the functions of:
 * Load profile picture, files selection, show alerts and load the principal page.
 */
var fn_scholarheader = function(){
	fn_loadProfilePicture();
	fn_selectProfilePicture();
	fn_showAlerts();
	loadIndex();
}

/**
 * Function that executes when principal page is loaded.
 */
var fn_home = function () {
	writeLog("fn_home");
	fn_opcCursandoGrado();
	loadCardsConfirmHome();
};

/**
 * Load the months to be confirmed in the index.
 */
function loadCardsConfirmHome() {
	 loadTemplate("cardConfirm", templates.cardConfirmIntership, {
	        title: "¿Recibiste tu beca?",
	        message: "Meses pendientes de confirmar:"
	    });
	    if(scholar.confirm.length == 0 &&  $("#pendingCard > .card").length == 0) {
	    	if(scholar.scholarship.confirmDispersion.length != 0){
	    		loadTemplate("messageThanks",templates.confirmAll,{
	    	           thanks: "Gracias",
	    	           message: "Por confirmar tus dep\u00f3sitos"
	    	    })
	    	}else {
	    		loadTemplate("messageThanks",templates.confirmAll,{
	 	           thanks: "¡Bienvenido!",
	 	           message: "Aqu\u00ed aparecer\u00e1n tus dep\u00f3sitos por confirmar"
	    		});
	    	}
	    	 $("#btnSendConfirm").hide();
		     $("p[name='pending']").hide();
	    }
	    if(scholar.confirm.length == 0 &&  $("#pendingCard > .card").length == 1) $("#cardConfirm").hide();
	    loadPendingCards();
	    fn_comboConfirmacionDepo();
}

//********************************My Qualifications ********************************//

/**
 * Execute the combos of "Cursando" and "Grado" of scholar and qualifications query.
 */
var fn_misCalificaciones = function () {
	fn_opcCursandoGrado();
};

/**
 * Dynamically filled combos of "Cursando" and "Grado".
 */
var fn_opcCursandoGrado = function () {
	isSelec_ = "";
	for(i=0;i<scholar.statusQualifications.schoolLevels.length; i++){
		if (!$("select[name='cursando']>option[value="+scholar.statusQualifications.schoolLevels[i].scholarLevel+"]").length){
			if(i==scholar.statusQualifications.schoolLevels.length-1)isSelec_="selected";
			$("select[name='cursando']").append('<option '+isSelec_+' value="'+scholar.statusQualifications.schoolLevels[i].scholarLevel+'">'+scholar.statusQualifications.schoolLevels[i].scholarLevel+'</option>');
		}
	}
	for(var i in scholar.statusQualifications.schoolLevels){
		if (scholar.statusQualifications.schoolLevels[i].scholarLevel==$("select[name='cursando'] option:selected").text()){
			for (var j in scholar.statusQualifications.schoolLevels[i].scholarGrades){
				$("select[name='grado']").append('<option value="'+scholar.statusQualifications.schoolLevels[i].scholarGrades[j].scholarGrade+'">'+scholar.statusQualifications.schoolLevels[i].scholarGrades[j].scholarGrade+'</option>');
			}
		}
	}
	$("select[name='grado'] option:last").attr("selected", "selected");
	fn_consultaCalificacionesAnteriores();
};

/**
 * Function to review previous qualifications.
 */
var fn_consultaCalificacionesAnteriores = function () {
    $("select[name='cursando']").change(function () {
        $("select[name='grado']").text("");
        scholar.statusQualifications.schoolLevels.forEach(function(schoolLevels){
        	if (schoolLevels.scholarLevel == $("select[name='cursando'] option:selected").text()){
        		for (j=0;j<schoolLevels.scholarGrades.length; j++){
            		$("select[name='grado']").append('<option value="'+schoolLevels.scholarGrades[j].scholarGrade+'">'+schoolLevels.scholarGrades[j].scholarGrade+'</option>');
            	}
        	}
        });
        $("select[name='grado'] option:last").attr("selected", "selected");
    });

    $("select[name='cursando'], select[name='grado']").change(function () {
    	fn_loadStatusQualifications();
    });
    fn_loadStatusQualifications();
};

/**
 * Function to be executed when My Information is loaded.
 */
function loadMisDatos(){
	$("#btnMisDatos").addClass("active");
	$("#btnMiBeca, #btnMisCalificaciones, #btnMisTutores").removeClass("active");
	loadTemplate("templateInicio", templates.misDatos, {
		user: scholar.personalData.username,
		scholarName: scholar.personalData.name,
		schoolGrade : scholar.statusQualifications.schoolGrade,
		program : scholar.scholarship.programName,
		actLevel : scholar.statusQualifications.schoolLevels[scholar.statusQualifications.schoolLevels.length-1].scholarLevel,
		lastName: scholar.personalData.lastName,
		secondLastName: scholar.personalData.secondLastName,
		age: scholar.personalData.age,
		cr: scholar.personalData.assignedCR,
		accountNumber: "******"+scholar.personalData.accountNumber.toString().slice(-4),
		status : scholar.scholarship.statusDispersion,
		programStatus: scholar.program[0].status,
		modality: scholar.scholarship.modalityParticipation,
		schoolName: scholar.schoolData.name,
		schoolDomicile: scholar.schoolData.domicile,
		schoolType: scholar.schoolData.type,
		turn: scholar.schoolData.turn,
		typeCareer: scholar.schoolData.typeCareer,
		control: scholar.schoolData.control,
		cct: scholar.schoolData.cct,
		schoolState: scholar.schoolData.state,
		schoolMunicipality: scholar.schoolData.municipality
	});
}

/**
 * Varible que ejecuta una serie de funciones al terminar de cargar el template de Mis Datos.
 */
var fn_misDatos = function(){
	actTable();

    //***********************************************Personal Information******************************************************//
    $('[data-toggle="tooltip"]').tooltip({
        placement: "top"
    });

    $('.input-group.date').datetimepicker({
        format: 'DD-MM-YYYY',
        locale: 'es',
        minDate: new Date(80,0,1),
        maxDate: new Date()
    });

    //Letters of CURP
    $(".letrasCurp").keypress(function (key) {
    	writeLog(key.charCode);
        if ((key.charCode >= 48 && key.charCode <= 57) || (key.charCode >= 65 && key.charCode <= 90) || (key.charCode >= 97 && key.charCode <= 122) || key.charCode ==0) return true;
        return false;
	});

    $("input[name='birthdate']").keyup(function () {
       if($("input[name='birthdate']").val() !== ""){
           $("input[name='birthdate']").parent().parent().removeClass("has-error");
           $("#nobirthdate").fadeOut("fast",function(){$("#nobirthdate").remove();});
        }
    });

    $(".icon-167").click(function (event) {
        event.preventDefault();
        $("input[name='birthdate']").parent().parent().removeClass("has-error");
        $("#nobirthdate").fadeOut("fast",function(){$("#nobirthdate").remove();});
    });

    $(".numeros").keypress(function (key) {
        if (key.charCode >= 48 && key.charCode <= 57) return true;
        return false;
	});

    $("#curp2").keyup(function () {
	    curpIn = $("#curp2").val();
		validacion = expRegCurp.test(curpIn);
		if (validacion) {
			$("#curp2").removeClass("has-error");
            $("#noCurp2").fadeOut("fast",function(){$("#noCurp2").remove();});
		}
	});

    $("#principalEmail,#firstOptionalEmail,#secondOptionalEmail").keyup(function () {
        pEmail = $("#principalEmail").val();
        email1 = $("#firstOptionalEmail").val();
        email2 = $("#secondOptionalEmail").val();
        validacionPEmail = expRegEmail.test(pEmail);
        validacionEmail1 = expRegEmail.test(email1);
        validacionEmail2 = expRegEmail.test(email2);
        writeLog(validacionPEmail);
        if (validacionPEmail) {
            $("#principalEmail").removeClass("has-error");
            $("#noPEmail").fadeOut("fast",function(){$("#noPEmail").remove();});
            $("#principalEmail").blur(function () {
                $("#principalEmail").removeClass("has-error");
            });
        }
        if (validacionEmail1 || email1 === "") {
            $("#firstOptionalEmail").removeClass("has-error");
            $("#noEmail1").fadeOut("fast",function(){$("#noEmail1").remove();});
            $("#firstOptionalEmail").blur(function () {
                $("#firstOptionalEmail").removeClass("has-error");
            });
        }
        if (validacionEmail2 || email2 === "") {
            $("#secondOptionalEmail").removeClass("has-error");
            $("#noEmail2").fadeOut("fast",function(){$("#noEmail2").remove();});
            $("#secondOptionalEmail").blur(function () {
                $("#secondOptionalEmail").removeClass("has-error");
            });
        }
	});

    /**
     * When button btnSendInfo is clicked this function is executed.
     * @param {object} event Event object.
    */
    $("input[name='btnSendInfo']").click(function(event){
    	event.preventDefault();
    	var misDatosJSON = {
        			"userCurrent": scholar.studentID,
        			"student":[
        			           {
        			        	   "studentId": scholar.studentID,
        			        	   "programType":scholar.scholarship.programType,
        			        	   "statusDispersion":scholar.scholarship.statusDispersion,
        			        	   "cdOriginState": scholar.personalData.cdOriginState,
        			        	   "originState": scholar.personalData.originState,
        			        	   "cdOriginMunicipality": scholar.personalData.cdOriginMunicipality,
        			        	   "originMunicipality": scholar.personalData.originMunicipality,
        			        	   "originRegion": scholar.personalData.originRegion,
        			        	   "schoolCycle": scholar.statusQualifications.schoolCycle,
        			        	   "cdAssignedCR":scholar.personalData.cdAssignedCR,
        			        	   "assignedCR":scholar.personalData.assignedCR,
        			        	   "scholarNumber": scholar.personalData.scholarNumber,
        			        	   "accountNumber": scholar.personalData.accountNumber,
        			        	   "folioPhoto": scholar.personalData.profilePicture,
        			        	   "name": scholar.personalData.name,
        			        	   "firstName": scholar.personalData.lastName,
        			        	   "lastName": scholar.personalData.secondLastName,
        			        	   "CURP": scholar.personalData.curp,
        			        	   "scholarBirthdate": scholar.personalData.birthdate,
        			        	   "gender": scholar.personalData.gender,
        			        	   "schoolData":[
        			        	                 {
        			        	                	 "duration": scholar.schoolData.duration,
        			        	                	 "turn": scholar.schoolData.turn,
        			        	                	 "typeCareer": scholar.schoolData.typeCareer,
        			        	                	 "nameCareer": scholar.schoolData.name,
        			        	                	 "area": scholar.schoolData.area,
        			        	                	 "school":[
        			        	                	           {
        			        	                	        	   "cdState": scholar.schoolData.cdState,
        			        	                	        	   "state": scholar.schoolData.state,
        			        	                	        	   "cdMunicipality": scholar.schoolData.cdMunicipality,
        			        	                	        	   "municipality": scholar.schoolData.municipality,
        			        	                	        	   "CCT": scholar.schoolData.cct,
        			        	                	        	   "control": scholar.schoolData.control,
        			        	                	        	   "initials": scholar.schoolData.initials,
        			        	                	        	   "type": scholar.schoolData.type,
        			        	                	        	   "name": scholar.schoolData.name,
        			        	                	        	   "domicile": scholar.schoolData.domicile
        			        	                	           }
        			        	                	          ]
        			        	                 }
        			        	                ],
	        	                   "domicile":[
	        	                               {
	        	                            	   "street": scholar.domicile.street,
	        	                            	   "locality": scholar.domicile.locality,
	        	                            	   "numExterior": scholar.domicile.numExterior,
	        	                            	   "numInterior": scholar.domicile.numInterior,
	        	                            	   "codePostal": scholar.domicile.codePostal,
	        	                            	   "cdMunicipality": scholar.domicile.cdMunicipality,
	        	                            	   "municipality": scholar.domicile.municipality,
	        	                            	   "colony": scholar.domicile.colony,
	        	                            	   "cdState": scholar.domicile.cdState,
	        	                            	   "state": scholar.domicile.state,
	        	                            	   "betweenStreet": scholar.domicile.betweenStreet,
	        	                            	   "typeOfRoad1": scholar.domicile.typeOfRoad1,
	        	                            	   "andTheStreet": scholar.domicile.andTheStreet,
	        	                            	   "typeOfRoad2": scholar.domicile.typeOfRoad2,
	        	                            	   "behindStreet": scholar.domicile.behindStreet,
	        	                            	   "typeOfRoad3": scholar.domicile.typeOfRoad3,
	        	                            	   "particularReferences": scholar.domicile.particularReferences
	        	                                }
	        	                               ],
	        	                   "contactInf":[
	        	                                 {
	        	                                	 "homePhone": scholar.contactData.homePhone,
	        	                                	 "cellPhone": scholar.contactData.cellPhone,
	        	                                	 "messagePhone": scholar.contactData.messagePhone,
	        	                                	 "email": scholar.contactData.email,
	        	                                	 "email1": scholar.contactData.email1,
	        	                                	 "email2": scholar.contactData.email2
	        	                                 }
	        	                                ],
	        	                   "tutorData":[
	        	                                {
	        	                                	"tutorName": scholar.tutorData.name,
	        	                                	"firstNameTutor": scholar.tutorData.lastName,
	        	                                	"lastNameTutor": scholar.tutorData.secondLastName,
	        	                                	"kinship": scholar.tutorData.kinship,
	        	                                	"kinshipType": scholar.tutorData.kinshipType
	        	                                }
	        	                               ],
	        	                 "program": scholar.program
        			           }
        			          ]
        				};

    	btnID=$(this).attr("id");
    	var hasErrorPersonalInfo=false;
    	switch(btnID){
    		case "btnPersonalInformation":
    			writeLog("btnPersonalInformation");
    	        $("#nobirthdate").remove();
    	        $("#noCurp2").remove();

    	        //Fecha de nacimiento
    	        if ($("input[name='birthdate']").val() === "" ){
    	            $("input[name='birthdate']").parent().parent().addClass("has-error");
    	            $(".date").focus().after("<small style='color: #c8175e' id='nobirthdate'>Por favor ingresa tu fecha de nacimiento</small>");
    	            hasErrorPersonalInfo=true;
    	        }

    	        //CURP
    	        curp = $("#curp2").val();
    	        validacion = expRegCurp.test(curp);
    	        if($("#curp2").val() !== "") {
    	            if (!validacion) {
    	            	hasErrorPersonalInfo=true;
    	                $("#curp2").addClass("has-error");
    	                $("#seccCurp").focus().after("<span id='noCurp2'><br/><span style='color: #c8175e; font-size:80%'>Por favor verifica tu CURP</span></span>");
    	            }
    	        }else hasErrorPersonalInfo=true;

    	        if($("select[name='gender'] option:selected").val()==0) hasErrorPersonalInfo=true;


    	        writeLog(hasErrorPersonalInfo);
	        	writeLog("hasErrorPersonalInfo");
	        	misDatosJSON.student[0].CURP=$("#curp2").val();
	        	misDatosJSON.student[0].scholarBirthdate=$("input[name='birthdate']").val();
	        	misDatosJSON.student[0].gender=$("select[name='gender'] option:selected").val();
	        	writeLog("!hasErrorPersonalInfo  misDatosJSON",misDatosJSON);
    			break;
    		case "btnSendDomicile":
    			writeLog("btnSendDomicile");
    	    	if($("input[name='street']").val() == "" ||
    	    	   $("input[name='numExterior']").val() == "" ||
    	    	   $("input[name='postalCode']").val() == "" ||
    	    	   $("input[name='localityHouse']").val() == "" ||
    	    	   $("input[name='colonyHouse']").val() == "" ||
    	    	   $("input[name='betweenStreet']").val() == "" ||
    	    	   $("input[name='andTheStreet']").val() == "" ||
    	    	   $("input[name='behindStreet']").val() == "" ||
    	    	   $("textarea[name='references']").val() == "" ||
    	    	   $("select[name='stateHouse'] option:selected").val() == 0 ||
    	    	   $("select[name='municipalityHouse'] option:selected").val() == 0 ||
    	    	   $("#road1 option:selected").val() == 0 ||
    	    	   $("#road2 option:selected").val() == 0 ||
    	    	   $("#road3 option:selected").val() == 0) hasErrorPersonalInfo=true;

    	    		misDatosJSON.student[0].domicile[0]={
        		        "street": $("input[name='street']").val(),
        		        "locality": $("input[name='localityHouse']").val(),
        		        "numExterior": $("input[name='numExterior']").val(),
        		        "numInterior": $("input[name='numInterior']").val(),
        		        "codePostal": $("input[name='postalCode']").val(),
        				"cdMunicipality":$("select[name='municipalityHouse'] option:selected").val(),
        				"municipality": $("select[name='municipalityHouse'] option:selected").text(),
        				"colony": $("input[name='colonyHouse']").val(),
        				"cdState":$("select[name='stateHouse'] option:selected").val(),
        				"state": $("select[name='stateHouse'] option:selected").text(),
        				"betweenStreet": $("input[name='betweenStreet']").val(),
        				"typeOfRoad1": $("#road1 option:selected").val(),
        				"andTheStreet": $("input[name='andTheStreet']").val(),
        				"typeOfRoad2": $("#road2 option:selected").val(),
        				"behindStreet": $("input[name='behindStreet']").val(),
        				"typeOfRoad3": $("#road3 option:selected").val(),
        				"particularReferences": $("textarea[name='references']").val()
        			}


    			break;
    		case "btnSaveContactInformation":
    			writeLog("btnSaveContactInformation");
    			$("#noPEmail").remove();
    			$("#noEmail1").remove();
    			$("#noEmail2").remove();
    			if ($("#principalEmail").val() !== "") {
    	            pEmail = $("#principalEmail").val();
    				validacionPEmail = expRegEmail.test(pEmail);
    	            if (!validacionPEmail){
    	            	if($("#principalEmail").next('span#noPEmail').length==0){
	    	                $("#principalEmail").focus().after("<span id='noPEmail'><br/><span style='color: #c8175e; font-size:80%'>Por favor verifica el correo</span></span>");
	    	                $("#principalEmail").blur(function () {
	    	                    $("#principalEmail").addClass("has-error");
	    	                });
    	            	}
    	                hasErrorPersonalInfo=true;
    	            }
    	        } else hasErrorPersonalInfo=true;

    	        if ($("#firstOptionalEmail").val() !== "") {
    	            email1 = $("#firstOptionalEmail").val();
    	            validacionEmail1 = expRegEmail.test(email1);
    	            if (!validacionEmail1){
    	            	if($("#firstOptionalEmail").next('span#noEmail1').length==0){
	    	                $("#firstOptionalEmail").focus().after("<span id='noEmail1'> <br/> <span style='color: #c8175e; font-size:80%'>Por favor verifica el correo</span></span>");
	    	                $("#firstOptionalEmail").blur(function () {
	    	                    $("#firstOptionalEmail").addClass("has-error");
	    	                });
    	            	}
    	                hasErrorPersonalInfo=true;
    	            }
    	        }

    	        if ($("#secondOptionalEmail").val() !== ""){
    	            email2 = $("#secondOptionalEmail").val();
    	            validacionEmail2 = expRegEmail.test(email2);
    	            if (!validacionEmail2){
    	            	if($("#secondOptionalEmail").next('span#noEmail2').length==0){
	    	                $("#secondOptionalEmail").focus().after("<span id='noEmail2'><br/><span style='color: #c8175e; font-size:80%'>Por favor verifica el correo</span>");
	    	                $("#secondOptionalEmail").blur(function () {
	    	                    $("#secondOptionalEmail").addClass("has-error");
	    	                });
	    	            }
    	                hasErrorPersonalInfo=true;
    	            }
    	        }
    	        $("input[name='tCasa']").val(parseInt($("input[name='tCasa']").val(), 10)+"");
    	        $("input[name='tCel']").val(parseInt($("input[name='tCel']").val()+"", 10)+"");
    	        $("input[name='tRecados']").val(parseInt($("input[name='tRecados']").val()+"", 10)+"");
    	        
    	        $("input[name='tCasa'],[name='tCel'],[name='tRecados']").each(function(){
    	        	if((typeof $(this).attr("minLength") != "undefined" && $(this).val().length < $(this).attr("minLength"))||
    	        	   (typeof $(this).attr("maxLength") != "undefined" && $(this).val().length > $(this).attr("maxLength"))||
    	        	   $(this).val() == ""){
    	        		hasErrorPersonalInfo=true;
    	        	}
    	        });
    	        misDatosJSON.student[0].contactInf[0]={
     		       "homePhone": $("input[name='tCasa']").val(),
     		       "cellPhone": $("input[name='tCel']").val(),
     		       "messagePhone": $("input[name='tRecados']").val(),
     		       "email": $("input[name='email1']").val(),
     		       "email1": $("input[name='email2']").val(),
     		       "email2": $("input[name='email3']").val()
    	        };
    			break;
    		case "btnSendTutorData":
    			writeLog("btnSendTutorData");
    			if($("input[name='tutorName']").val() == "" ||
    			   $("input[name='tutorLastName']").val() == "" ||
	    	       $("select[name='relation'] option:selected").val() == 0) hasErrorPersonalInfo=true;

		    	if($("select[name='relation'] option:selected").val() == "OTRO" &&
		    	   $("input[name='relation_other']").val() == "")hasErrorPersonalInfo=true;

		    	misDatosJSON.student[0].tutorData[0]={
     		       "tutorName": $("input[name='tutorName']").val(),
     		       "firstNameTutor": $("input[name='tutorLastName']").val(),
     		       "lastNameTutor": $("input[name='tutorSecondLastName']").val(),
     		       "kinship": $("select[name='relation'] option:selected").val(),
     		       "kinshipType": $("input[name='relation_other']").val()
		    	};
    			break;
    	}

    	if(!hasErrorPersonalInfo){
    		restExec({
    			service: 'MODIF_UPLOADSCHOLAR',
        		data: misDatosJSON,
        		showWait: true,
            		customWait: {
            			title: "Guardando datos",
            			message: "Por favor espera."
            		},
	        	success: rest_fnModifUploadScholar,
	        	finallySuccess: function() {
	        		loadMisDatos();
	        		showModals("Se han modificado tus datos","Gracias","savedFile");
	        	}
    		});
    	}

    });

    //*********************************************** BECA ******************************************************//
    if(scholar.confirm.length !== 0){
        loadTemplate("depositosPendientes", templates.depositosPendientesBeca, {
            title : "Confirmaciones de dep\u00f3sitos pendientes"
        });
    }

    //************************************************ESCUELA****************************************************//
    if(scholar.statusQualifications.averagesScholarLevel[scholar.statusQualifications.averagesScholarLevel.length-1].scholarLevel == "Universidad"){
        loadTemplate("universityData", templates.uniInformation, {
            typeOfCareer : scholar.schoolData.typeCareer,
            careerName : scholar.schoolData.nameCareer,
            area : scholar.schoolData.area,
            duration : scholar.schoolData.duration
        });
    }

    $(".letras").keypress(function (key) {
    	writeLog("key.charCode", key.charCode);
        if ((key.charCode < 97 || key.charCode > 122)//letras mayusculas
                    && (key.charCode < 65 || key.charCode > 90) //letras minusculas
                    && (key.charCode !== 241) //enhe
                    && (key.charCode !== 209) //ENHE
                    && (key.charCode !== 32) //espacio
                    && (key.charCode !== 225) //a con acento
                    && (key.charCode !== 233) //e con acento
                    && (key.charCode !== 237) //i con acento
                    && (key.charCode !== 243) //o con acento
                    && (key.charCode !== 250) //u con acento
                    && (key.charCode !== 193) //A con acento
                    && (key.charCode !== 201) //E con acento
                    && (key.charCode !== 205) //I con acento
                    && (key.charCode !== 211) //O con acento
                    && (key.charCode !== 218) //U con acento
                    && (key.charCode !== 0) //Borrar
                    ) return false;
            return true;
    });

    $('select.other-relation').on('change', function() {
        if ($(this).val() === $(this).find('.other-relation-op').attr('value')) {
            $(this).closest('form').find('.other-relation-target').show();
            $(this).closest('form').find('.other-relation-target').find('input').val('').focus();
        } else {
            $(this).closest('form').find('.other-relation-target').hide();
        }

        if ($(this).closest('#new-staff-form')) {
            $('#btn-new-staff').removeAttr('disabled');
        }
    });

    $("#changePassword").click(function(event){
        event.preventDefault();
        loadTemplate("templateInicio", templates.newPassword, {
            title : "Ingresa tu nueva contrase\u00F1a"
        });
    });


    $("a[data-toggle='tooltip']").click(function (event) {
        if ($(this).attr("href") === "#") event.preventDefault();
    });

    if(scholar.personalData.originRegion != "") $("label[name='originRegion']").text(scholar.personalData.originRegion);
	if(scholar.personalData.originState != "") $("label[name='originState']").text(scholar.personalData.originState);
	if(scholar.personalData.originMunicipality != "") $("label[name='originMunicipality']").text(scholar.personalData.originMunicipality);
	if(scholar.personalData.curp.trim() != "") $("input[name='curp']").val(scholar.personalData.curp);
	if(scholar.personalData.birthdate.trim() != "") $("input[name='birthdate']").val(scholar.personalData.birthdate);
	if(scholar.domicile.street.trim() != "") $("input[name='street']").val(scholar.domicile.street);
	if(scholar.domicile.numExterior.trim() != "") $("input[name='numExterior']").val(scholar.domicile.numExterior);
	if(scholar.domicile.numInterior.trim() != "") $("input[name='numInterior']").val(scholar.domicile.numInterior);
	if(scholar.domicile.codePostal != "") $("input[name='postalCode']").val(scholar.domicile.codePostal);
	if(scholar.domicile.betweenStreet.trim() != "") $("input[name='betweenStreet']").val(scholar.domicile.betweenStreet);
	if(scholar.domicile.andTheStreet.trim() != "") $("input[name='andTheStreet']").val(scholar.domicile.andTheStreet);
	if(scholar.domicile.behindStreet.trim() != "") $("input[name='behindStreet']").val(scholar.domicile.behindStreet);
	if(scholar.domicile.particularReferences.trim() !== "") $("textarea[name='references']").val(scholar.domicile.particularReferences);
	if(scholar.domicile.locality.trim() != "") $("input[name='localityHouse']").val(scholar.domicile.locality);
	if(scholar.domicile.colony.trim() != "") $("input[name='colonyHouse']").val(scholar.domicile.colony);
	if(scholar.contactData.homePhone.trim() != "") $("input[name='tCasa']").val(scholar.contactData.homePhone);
	if(scholar.contactData.cellPhone.trim() !== "") $("input[name='tCel']").val(scholar.contactData.cellPhone);
	if(scholar.contactData.messagePhone.trim() != "") $("input[name='tRecados']").val(scholar.contactData.messagePhone);
	if(scholar.contactData.email.trim() != "") $("input[name='email1']").val(scholar.contactData.email);
	if(scholar.contactData.email1.trim() != "") $("input[name='email2']").val(scholar.contactData.email1);
	if(scholar.contactData.email2.trim() != "") $("input[name='email3']").val(scholar.contactData.email2);
	if(scholar.tutorData.name.trim() !== "") $("input[name='tutorName']").val(scholar.tutorData.name);
	if(scholar.tutorData.lastName.trim() != "") $("input[name='tutorLastName']").val(scholar.tutorData.lastName);
	if(scholar.tutorData.secondLastName.trim() != "") $("input[name='tutorSecondLastName']").val(scholar.tutorData.secondLastName);

	for(var i in combos.gender){
		$("select[name='gender']").append("<option value="+combos.gender[i]+">"+combos.gender[i]+"</option>");
	}

	for(var i in combos.typeOfViality){
		$("select[name='vialidad']").append("<option value="+combos.typeOfViality[i]+">"+combos.typeOfViality[i]+"</option>");
	}

	for(var i in combos.kindship){
		$("select[name='relation']").append("<option value="+combos.kindship[i]+">"+combos.kindship[i]+"</option>");
		if($("select[name='relation']>option[value='OTRO']").length == 1) $("select[name='relation']>option[value='OTRO']").addClass("other-relation-op");
	}
	for(var i in statesTransactions){
		selectedStr = (statesTransactions[i].state.name == scholar.domicile.state)?"selected":"";
		$("select[name='stateHouse']").append("<option value="+statesTransactions[i].state.code+" "+selectedStr+">"+statesTransactions[i].state.name+"</option>");
	}
	if(currentStateMunicipality.municipalityTransactions.length != 0 && currentStateMunicipality.municipalityTransactions["0"].municipality.state.name==scholar.domicile.state){
		fn_listMunicipality(currentStateMunicipality);
	}else{
		fn_getMunicipality();
	}

	if(scholar.personalData.gender.trim() != "") $("select[name='gender']>option[value="+scholar.personalData.gender+"]").attr("selected",true);
	else $("select[name='gender']>option[value=0]").attr("selected",true);
	if(scholar.domicile.typeOfRoad1.trim() != "") $("#road1>option[value="+scholar.domicile.typeOfRoad1+"]").attr("selected",true);
	else $("#road1>option[value=0]").attr("selected",true);
	if(scholar.domicile.typeOfRoad2.trim() != "") $("#road2>option[value="+scholar.domicile.typeOfRoad2+"]").attr("selected",true);
	else $("#road2>option[value=0]").attr("selected",true);
	if(scholar.domicile.typeOfRoad2.trim() != "") $("#road3>option[value="+scholar.domicile.typeOfRoad3+"]").attr("selected",true);
	else $("#road3>option[value=0]").attr("selected",true);
	if(scholar.tutorData.kinship.trim() != ""){
		$("select[name='relation']>option[value="+scholar.tutorData.kinship.replace("(","\\(").replace(")","\\)")+"]").attr("selected",true);
		if(scholar.tutorData.kinship == "OTRO"){
			$('select.other-relation').closest('form').find('.other-relation-target').show();
            $('select.other-relation').closest('form').find('.other-relation-target').find('input').val(scholar.tutorData.kinshipType.trim()).focus();
		}
	}else $("select[name='relation']>option[value=0]").attr("selected",true);
	if(scholar.scholarship.confirmDispersion=="")$("#accordion-deposit").hide();


	$("select[name='stateHouse']").on("change",fn_getMunicipality);
	requerido();
};

/**
 * Funtion that fills municipality's combo.
 */
var fn_getMunicipality = function(){
	selectedState = $("select[name='stateHouse']").val();
	writeLog("selectedState ",selectedState);
	$("select[name='municipalityHouse']").empty();
	$("select[name='municipalityHouse']").append("<option value=\"0\">Selecciona</option>");
	if(selectedState!=0){
		rest_getMunicipality(selectedState);
	}
}

/**
 * Upload the list of municipalities.
 */
var fn_listMunicipality = function(municipalitys){
	actualstate = (scholar.domicile.state == municipalitys.municipalityTransactions["0"].municipality.state.name)?true:false;
	if(actualstate&&currentStateMunicipality!=municipalitys){
		currentStateMunicipality = municipalitys
	}
	for(var i in municipalitys.municipalityTransactions){
		actualmunicipalitystr=(actualstate&&municipalitys.municipalityTransactions[i].municipality.name==scholar.domicile.municipality)?"selected":"";
		$("select[name='municipalityHouse']").append("<option value="+municipalitys.municipalityTransactions[i].municipality.code+" "+actualmunicipalitystr+">"+municipalitys.municipalityTransactions[i].municipality.name+"</option>");
	}
}

/**
 * Show the cards of pending months to confirm(My Information).
 */
var fn_confirmacionMesesPendientesBeca = function () {
    for (var i in scholar.confirm) {
        var div1 = document.createElement("div");
        var att = document.createAttribute("id");
        att.value = "confirmacion" + scholar.confirm[i].idMonth;
        div1.setAttributeNode(att);
        document.getElementById("confirmacion").appendChild(div1);
        loadTemplate(att.value, templates.mesesPendientesBeca, {
            idMonth : scholar.confirm[i].idMonth,
            month : scholar.confirm[i].month,
            year : scholar.confirm[i].year
        });
    };
    confirmacionPagoBeca();
    fn_comboConfirmacionDepo();
};

/**
 * Upload a profile picture.
 */
var fn_loadProfilePicture = function(){
	if(scholar.personalData.base64ProfilePicture){
		$('[data-target="#uploadScholarImage"]').css("background-image", "url("+scholar.personalData.base64ProfilePicture+")", "background-size", "10px 10px");
		$("#iconoBecario").removeClass("icon-49");
	}
}

/**
 * Function to validate the quealifications.
 */
var fn_qualificationValidate = function  () {
    $("input[name='score']").keypress(function (key) {
        if (key.charCode >= 48 && key.charCode < 58 || key.charCode == 46) return true;
        return false;
    });

    $('#btnSaveDocs').click(function(event){
        event.preventDefault();
        scores=$(".inscore");
        scoresToSend=[];
        score_HasError = false;
        scores.each(function(){
        	$iScore = $(this);
        	old_score = $iScore.attr("data-iscore");
        	in_score = $iScore.val();
        	writeLog("in_score ",in_score);
        	writeLog("old score ",old_score);
        	
        	if(in_score!=old_score){
        		in_grade = $iScore.attr("data-grade");
            	in_period = $iScore.attr("data-period");
            	if(in_score !== "" && expRegCalif.test(in_score) && in_score !== "0"){
            		scoresToSend.push({
            			studentID: scholar.studentID+"",
						programType: scholar.scholarship.programType,
						schoolGrade: in_grade,
						schoolCycle: scholar.statusQualifications.schoolCycle,
						schoolPeriod: in_period,
						qualification: in_score,
						userCurrent: scholar.studentID+""
            		});
            	}else{
            		score_HasError = true;
            		$("#e"+$iScore.attr("id")).remove();
            		$($iScore.attr("data-helpsoce")).focus().after("<span id='e"+$iScore.attr("id")+"'><br/><span style='color: #c8175e; font-size:80%; margin-left:87px'>Ingresa una calificaci&oacute;n valida</span>");
            		$iScore.parent(".form-group.no-grid").addClass("has-error");
                    $iScore.blur();
            	}
        	}
        });
        if(scoresToSend.length && !score_HasError){
        	_modal = SCONFIG.getMessage('wait');
    		showModals(_modal.title,_modal.message,_modal.idModal);
    		setTimeout(function () {
    			_hasErrorScore = false;
    			_scoreInd = 0;
    			do{
    				writeLog("guardando",scoresToSend[_scoreInd]);
    				restExec({
                		service:'UPDATE_QUALIFICATION',
                		data: scoresToSend[_scoreInd],
                		finallyError: function(){
                			_hasErrorScore = true;
                		}
                	});
    				_scoreInd++;
    			}while(!_hasErrorScore&&_scoreInd<scoresToSend.length);
    			if(!_hasErrorScore){
    				rest_averageQuery();
    				rest_reloadQualifications();
        			showModals("Tu calificaci\u00F3n se ha guardado satisfactoriamente","Gracias por la espera","savedFile");
        			$("#savedFile").find("button").on("click",function(){
        				writeLog("reload calification");
    	            	fn_loadStatusQualifications();
    	            	$($(this)).prop('onclick',null).off('click');
    	            });
    			}
    	    }, 400);
        }
    });

    $("input.inscore").keyup(function(){
    	inputScore = $(this);
        score=inputScore.val();
        validateScore = expRegCalif.test(score);
        if(validateScore&&score!="0"){
            $("#e"+inputScore.attr("id")).fadeOut();
            inputScore.parent(".form-group.no-grid").removeClass("has-error");
            inputScore.blur(function () {
            	inputScore.parent(".form-group.no-grid").removeClass("has-error");
            });
            if(!($(inputScore.attr("data-boletaid")).is(":visible")))$(inputScore.attr("data-boletaid")).fadeIn("slow");
        }
    });
}

/**
 * Funtion that validates a passwords.
 */
var fn_validatePasswords = function () {
	$("button[href='#']").click(function(event){
        event.preventDefault();
    });
    const abcdario = "ABCDEFGHIJKLMN\u00D1OPQRSTUVWXYZ";//debe estar en mayusculas
    var arrabc = new Array(),
        arrcba = new Array();
        longi = 5;
    for(i=0;i<abcdario.length-longi+1;i++){
        sect = abcdario.substring(i,i+longi);
        arrabc.push(sect);
        arrcba.push(sect.split("").reverse().join(""));
    }
    function isIncreasing(pass){
        itIs=false;
        passUP=pass.toUpperCase();
        for(i=0;i<arrabc.length;i++){
            if(passUP.indexOf(arrabc[i])!=-1||passUP.indexOf(arrcba[i])!=-1){
                itIs = true;
                break;
            }
        }
        return itIs;
    }

    $("#btnChangePassword").click(function(event) {
        event.preventDefault();
        writeLog("btnChangePassword");
		$("#diffPass").remove();
		$("#numSequences").remove();
        $("#repeatChar").remove();
        $("#abcdario").remove();
        $("#nullPass").remove();
        $("#elongPass").remove();
        $("#notHasN").remove();
        $("#notHasL").remove();
        pass1 = $("input[name='newPassword']").val();
        pass2 = $("input[name='confirmPassword']").val();
        errorPW = false;
        //Contrasenhas no nulas
		if ((pass1 !== "") && (pass2 !== "")) {
			if (pass1.length != 10 || pass2.length != 10 ) {
		    	$("input[name='confirmPassword']").focus().after("<span class='text-danger' id='elongPass' style='font-size:80%'>Contrase\u00F1as deben tener longitud de 10 caracteres \n </span>");
				$("input[name='newPassword'], input[name='confirmPassword']").addClass("has-error");
		    	$("input[name='newPassword'], input[name='confirmPassword']").blur(function () {
					$("input[name='newPassword']").addClass("has-error");
					$("input[name='confirmPassword']").addClass("has-error");
				});
                errorPW=true;
			}
			if (!expRegHasNumber.test(pass1)) {
		    	$("input[name='confirmPassword']").focus().after("<span class='text-danger' id='notHasN' style='font-size:80%'>Debe contener al menos un n\u00FAmero \n </span>");
				$("input[name='newPassword']").addClass("has-error");
		    	$("input[name='newPassword'], input[name='confirmPassword']").blur(function () {
					$("input[name='newPassword']").addClass("has-error");
					$("input[name='confirmPassword']").addClass("has-error");
				});
                errorPW=true;
			}
			if (!expRegHasLetter.test(pass1)) {
		    	$("input[name='confirmPassword']").focus().after("<span class='text-danger' id='notHasL' style='font-size:80%'>Debe contener al menos una letra \n </span>");
				$("input[name='newPassword']").addClass("has-error");
		    	$("input[name='newPassword'], input[name='confirmPassword']").blur(function () {
					$("input[name='newPassword']").addClass("has-error");
					$("input[name='confirmPassword']").addClass("has-error");
				});
                errorPW=true;
			}
			//Contrasenhas diferentes
			if (pass1 !== pass2) {
		    	$("input[name='confirmPassword']").focus().after("<span class='text-danger' id='diffPass' style='font-size:80%'>Contrase\u00F1as diferentes, por favor verificalas \n </span>");
				$("input[name='newPassword']").addClass("has-error");
		    	$("input[name='newPassword'], input[name='confirmPassword']").blur(function () {
					$("input[name='newPassword']").addClass("has-error");
					$("input[name='confirmPassword']").addClass("has-error");
				});
                errorPW=true;
			}
            if (expRegAscNum.test(pass1) || expRegDesNum.test(pass1)) {
            //Contienen numeros en forma ascendente o descendente
                $("input[name='confirmPassword']").focus().after("<span class='text-danger' id='numSequences' style='font-size:80%'>No se permiten n\u00FAmeros de forma ascendente y/o descendente <br /> </span>");
                $("input[name='newPassword'], input[name='confirmPassword']").addClass("has-error");
                $("input[name='newPassword'], input[name='confirmPassword']").blur(function () {
                $("input[name='newPassword'], input[name='confirmPassword']").addClass("has-error");
                });
                errorPW=true;
            }
            if (expRegRepeat.test(pass1)){
                //Se repiten mas de 2 veces algun caracter
                $("input[name='confirmPassword']").focus().after("<span class='text-danger' id='repeatChar' style='font-size:80%'>No se permiten m\u00E1s de 2 letras y/o n\u00FAmeros iguales de forma consecutiva <br /></span>");
                $("input[name='newPassword'], input[name='confirmPassword']").addClass("has-error");
                $("input[name='newPassword'], input[name='confirmPassword']").blur(function () {
                    $("input[name='newPassword'], input[name='confirmPassword']").addClass("has-error");
                });
                errorPW=true;
            }

            if(isIncreasing(pass1)){
                $("input[name='confirmPassword']").focus().after("<span class='text-danger' id='abcdario' style='font-size:80%'>No se permiten m\u00E1s de 2 letras y/o n\u00FAmeros iguales de forma consecutiva <br /></span>");
                $("input[name='newPassword'], input[name='confirmPassword']").addClass("has-error");
                $("input[name='newPassword'], input[name='confirmPassword']").blur(function () {
                    $("input[name='newPassword'], input[name='confirmPassword']").addClass("has-error");
                });
                errorPW=true;
            }
            if(!errorPW){
            	writeLog("!errorPW");
            	restExec({
					service: 'SCHOLAR_UPDATEPASSWORD',
					data: {
						alias: scholar.personalData.username,
						password: $("#newPassword").val()
					},
					showWait: true,
					customWait:{
						title: "Actualizando tu contrase\u00f1a",
						message: "Espera un momento"
					},
					success: rest_fnUpdatePassword
				});
            }
        } else {
            $("input[name='confirmPassword']").focus().after("<span class='text-danger' id='nullPass' style='font-size:80%'>Por favor llena los campos<br /></span>");
            $("input[name='newPassword'], input[name='confirmPassword']").addClass("has-error");
            $("input[name='newPassword'], input[name='confirmPassword']").blur(function () {
                $("input[name='newPassword'], input[name='confirmPassword']").addClass("has-error");
            });
            errorPW=true;
        }

    });

	$("input[name='newPassword'], input[name='confirmPassword']").keyup(function () {
        pass1 = $("input[name='newPassword']").val();
        pass2 = $("input[name='confirmPassword']").val();
        if(pass1 !== "" && pass2 !== "") $("#nullPass").fadeOut();
        if (pass1.length == 10 && pass2.length == 10 ) $("#elongPass").fadeOut();
        if(expRegHasNumber.test(pass1))$("#notHasN").fadeOut();
        if(expRegHasLetter.test(pass1))$("#notHasL").fadeOut();
        if (pass1 === pass2) $("#diffPass").fadeOut();
        
        if (!expRegAscNum.test(pass1) && !expRegDesNum.test(pass1) && !expRegAscNum.test(pass2) && !expRegDesNum.test(pass2)) $("#numSequences").fadeOut();
        
        if (!expRegRepeat.test(pass1) && !expRegRepeat.test(pass1) && !expRegRepeat.test(pass2) && !expRegRepeat.test(pass2))         $("#repeatChar").fadeOut();

        if(!isIncreasing(pass1)) $("#abcdario").fadeOut();

        if(pass1 === pass2 &&
            !expRegAscNum.test(pass1) &&
            !expRegDesNum.test(pass1) &&
            !expRegRepeat.test(pass1) &&
            !expRegRepeat.test(pass1) &&
            pass1.length == 10 && 
            pass2.length == 10 &&
            expRegHasNumber.test(pass1) &&
            expRegHasLetter.test(pass1)&&
            !isIncreasing(pass1)){
            $("input[name='newPassword']").removeClass("has-error");
            $("input[name='confirmPassword']").removeClass("has-error");
            $("input[name='newPassword'], input[name='confirmPassword']").blur(function () {
                $("input[name='newPassword'], input[name='confirmPassword']").removeClass("has-error");
            });
        }
	});
	$("#btnCancelsChangePassword").click(function(event){
		event.preventDefault();
		$("#btnMisDatos").click();
		writeLog("btnCancelsChangePassword");
	});
};

/**
 * Load the alert's template.
 */
var fn_showAlerts = function() {
    if(scholar.alerts.length !=0) {
        if(scholar.alerts.length == 1){
            loadTemplate("alertMessage", templates.alertScholar, {
                alertText : scholar.alerts[0].message
            });
        } else {
            loadTemplate("alertMessage", templates.multipleAlertScholar, {
                btnPrev : "Previous",
                btnNext : "Next"
            });
        }
    }
}

/**
 * This function gets the alerts to show them in the alert's carousel.
 */
var fn_carouselItemAlert = function () {
    for (var i in scholar.alerts) {
        var div1 = document.createElement("div");
        div1.setAttribute("class","carousel-item");
        div1.innerHTML="<div style='margin:0px 30px'><i class='icon icon-72'></i>"+scholar.alerts[i].message+"</div>";
        document.getElementById("carouselInner").appendChild(div1);
        if(i == 0) $("div .carousel-item").addClass("active");
    }
};

/**
 * Load the template about status of deposit incompletes or not received.
 */
function loadPendingCards() {
    var contador = 0;
    for (var i in scholar.scholarship.confirmDispersion) {
        if (scholar.scholarship.confirmDispersion[i].statusReview === "Resuelto" ||
            scholar.scholarship.confirmDispersion[i].statusReview === "En proceso") {
            if ($("#pendingCard > .card").length == 0) {
                loadTemplate("pendingCard", templates.cardPendientes, {
                    subtitle: "Respuestas a dep\u00f3sitos pendientes"
                });
                $(".showAllAnswers").click(function(event){
                    event.preventDefault();
                    fn_afterMisDatos=fn_scroll;
                    $("#btnMisDatos").click();
                });
            }
            if (scholar.scholarship.confirmDispersion[i].statusReview === "Resuelto") {
                contador++;
                var div1 = document.createElement("div");
                var att = document.createAttribute("id");
                att.value = "responses" + scholar.scholarship.confirmDispersion[i].idMonth;
                div1.setAttributeNode(att);
                document.getElementById("responses").appendChild(div1);
                loadTemplate(att.value,templates.confirmSolved, {
                    month: scholar.scholarship.confirmDispersion[i].monthConfirm,
                    year: scholar.scholarship.confirmDispersion[i].yearConfirm,
                    response: scholar.scholarship.confirmDispersion[i].statusScholarshipReceived
                });
            }else if (scholar.scholarship.confirmDispersion[i].statusReview === "En proceso") {
                var div1 = document.createElement("div");
                var att = document.createAttribute("id");
                att.value = "responses" + scholar.scholarship.confirmDispersion[i].monthConfirm +""+scholar.scholarship.confirmDispersion[i].yearConfirm;
                div1.setAttributeNode(att);
                document.getElementById("responses").appendChild(div1);
                loadTemplate(att.value,templates.confirmInProgress, {
                    month: scholar.scholarship.confirmDispersion[i].monthConfirm,
                    year: scholar.scholarship.confirmDispersion[i].yearConfirm,
                    response: scholar.scholarship.confirmDispersion[i].statusScholarshipReceived
                });
            }
        }
    }
    $("a[href='#']").click(function(event){
       event.preventDefault();
    });
    if (contador == 0) $("a[class='showAnswers']").hide()
    else fn_showAnswers();
}

/**
 * Load the pending months of deposits.
 */
var fn_loadConfirmCardsHome = function() {
	if(scholar.confirm.length !=0){
		for (var i in scholar.confirm) {
	        var div1 = document.createElement("div");
	        //var att = document.createAttribute("id");
	        //att.value = "confirmacion" + scholar.confirm[i].idMonth;
	        div1.setAttribute("id","confirmacion" + scholar.confirm[i].idMonth);
	        document.getElementById("confirmacion").appendChild(div1);
	        loadTemplate("confirmacion" + scholar.confirm[i].idMonth, templates.confirmacion, {
	            idMonth : scholar.confirm[i].idMonth,
	            month : scholar.confirm[i].month,
	            year : scholar.confirm[i].year
	        });
	    }
	}
    confirmacionPago();
    loadPendingCards();
}

/**
 * Function to confirm pending months.
 */
function confirmacionPago() {
    if ($("#btnSendConfirm").attr("data-fn") == "1")return;
    $("#btnSendConfirm").attr("data-fn", "1");
    $("#btnSendConfirm").click(function(event){
        event.preventDefault();
        meses=[];
        anhios=[];
        confirms=[];
        respuesta=[];
        if ($("input:checkbox:checked").length!=0){
        	var arr_confSuccess=[];
        	var _iConfirm=0;
        	$("input:checkbox:checked").each(function () {
        		var mes="";
				var anhio="";
				var respuesta="";
        		respuesta=$("#confirmacion"+$(this).attr("data-month")+$(this).attr("data-year")).find($("select[name='status'] option:selected")).val();
        		if(respuesta != 0){
        			mes=$(this).attr("data-month");
        			anhio=$(this).attr("data-year");
        			meses.push(mes);
    				anhios.push(anhio);
        			confirms.push({
	            		service:'DEPOSIT_MODIFICATION',
	            		showWait: false,
	                	data: {
	                	    "userCurrent" : scholar.studentID,
	                	    "studentID" : scholar.studentID,
	                	    "monthConfirm" : mes,
	                	    "yearConfirm" : anhio,
	                	    "programType" : scholar.scholarship.programType,
	                	    "scholarCycle" : scholar.statusQualifications.schoolCycle,
	                	    "scholarLevel" : scholar.statusQualifications.averagesScholarLevel[scholar.statusQualifications.averagesScholarLevel.length-1].scholarLevel,
	                	    "scholarGrade" : scholar.statusQualifications.averagesScholarLevel[scholar.statusQualifications.averagesScholarLevel.length-1].schoolGrade,
	                	    "statusScholarshipReceived" : respuesta,
	                	    "statusReview" : "",
	                	    "staffAnswer" : ""
	                	},
	        			success: rest_fnDepositModification,
	        			finallySuccess: function(){
	        				arr_confSuccess.push(_iConfirm);
	        				$("#confirmacion"+meses[_iConfirm]+""+anhios[_iConfirm]).hide();
	        				_iConfirm++;
	        			}
	            	});
        		}
    		});
        	if(confirms.length){
        		showModals("Enviando tus confirmaciones","Por favor espera",SCONFIG.getMessage('wait').idModal);
        		writeLog("confirms",confirms);
        		setTimeout(function(){
        			confirms.forEach(function(curr_confirm,_iConfirm){
        				restExec(curr_confirm);
        			});
        			$("#waitModal").modal("hide");
        			if(arr_confSuccess.length !=0){
	    				loadTemplate("messageSuccess", templates.successConfirm, {
	                        thanks: "Gracias"
	                    });
	    				for(var i_meses in meses){
	    					$("p[name='confirm']").append("<span>"+meses[i_meses]+" "+anhios[i_meses]+"</span><br/>");
	    				}
	    				writeLog("meses",meses,"años",anhios);
	    				setTimeout(function() {
	                        $("#messageSuccess > .card-block").slideUp("slow", function(){
	                        	scholar.confirm=[];
	            				scholar.scholarship.confirmDispersion=[];
	                            restExec({
	    	            			service:'DEPOSIT_QUERY',
	    	            			data: {
	    	            				userCurrent : scholar.studentID,
	    	            			    studentID : scholar.studentID,
	    	            			    programType : scholar.scholarship.programType,
	    	            			    statusScholarshipReceived : ""
	    	            			},
	    	            			success: rest_fnDepositQuery,
	    	            			finallySuccess: function() {
	    	            				loadCardsConfirmHome();
	    	            			}
	    	            		});
	                        });

	                    },2000);
        			}
        		},400);
        	}
        } else showModals("Por favor selecciona el dep\u00f3sito a confirmar","Gracias","errorFile");
    });
}

/**
 * Function to confirm pending months on My Information > scholarship.
 */
function confirmacionPagoBeca() {
    $("#btnSendConfirm").click(function(event){
        event.preventDefault();
            meses=[];
            anhios=[];
            confirms=[];
            respuesta=[];
            if ($("input:checkbox:checked").length!=0){
            	var arr_confSuccess=[];
            	var _iConfirm=0;
            	$("input:checkbox:checked").each(function () {
            		var mes="";
    				var anhio="";
    				var respuesta="";
            		respuesta=$("#confirmacion"+$(this).attr("data-month")+$(this).attr("data-year")).find($("select[name='status'] option:selected")).val();
            		if(respuesta != 0){
            			mes=$(this).attr("data-month");
            			anhio=$(this).attr("data-year");
            			meses.push(mes);
        				anhios.push(anhio);
            			confirms.push({
    	            		service:'DEPOSIT_MODIFICATION',
    	            		showWait: false,
    	                	data: {
    	                	    "userCurrent" : scholar.studentID,
    	                	    "studentID" : scholar.studentID,
    	                	    "monthConfirm" : mes,
    	                	    "yearConfirm" : anhio,
    	                	    "programType" : scholar.scholarship.programType,
    	                	    "scholarCycle" : scholar.statusQualifications.schoolCycle,
    	                	    "scholarLevel" : scholar.statusQualifications.averagesScholarLevel[scholar.statusQualifications.averagesScholarLevel.length-1].scholarLevel,
    	                	    "scholarGrade" : scholar.statusQualifications.averagesScholarLevel[scholar.statusQualifications.averagesScholarLevel.length-1].schoolGrade,
    	                	    "statusScholarshipReceived" : respuesta,
    	                	    "statusReview" : "",
    	                	    "staffAnswer" : ""
    	                	},
    	        			success: rest_fnDepositModification,
    	        			finallySuccess: function(){
    	        				arr_confSuccess.push(_iConfirm);
    	        				$("#confirmacion"+meses[_iConfirm]+""+anhios[_iConfirm]).hide();
    	        				_iConfirm++;
    	        			}
    	            	});
            		}
        		});
            	if(confirms.length){
            		showModals("Enviando tus confirmaciones","Por favor espera",SCONFIG.getMessage('wait').idModal);
            		writeLog("confirms",confirms);
            		setTimeout(function(){
            			confirms.forEach(function(curr_confirm,_iConfirm){
            				writeLog("curr_confirm,_iConfirm");
            				writeLog(curr_confirm,_iConfirm);
            				restExec(curr_confirm);
            			});
            			$("#waitModal").modal("hide");
            			writeLog("arr_confSuccess",arr_confSuccess.length);
            			if(arr_confSuccess.length != 0){
	            			showModals("Gracias por confimar el dep\u00f3sito de:","","savedFile");
	        				for(var i_meses in meses){
	        					$("#messageSuccessModal").append("<span>"+meses[i_meses]+" "+anhios[i_meses]+"</span><br/>");
	        				}
	        				scholar.confirm=[];
            				scholar.scholarship.confirmDispersion=[];
                            restExec({
    	            			service:'DEPOSIT_QUERY',
    	            			data: {
    	            				userCurrent : scholar.studentID,
    	            			    studentID : scholar.studentID,
    	            			    programType : scholar.scholarship.programType,
    	            			    statusScholarshipReceived : ""
    	            			},
    	            			success: rest_fnDepositQuery,
    	            			finallySuccess: function() {
    	            				actTable();
    	            				if(scholar.confirm.length != 0){
		            					$("#depositosPendientes").html("");
		            					loadTemplate("depositosPendientes", templates.depositosPendientesBeca, {
		            						title : "Confirmaciones de dep\u00f3sitos pendientes"
		            					});
		            				}else $("#depositosPendientes").html("");
    	            			}
    	            		});
            			}
            		},400);
            	}
            } else showModals("Por favor selecciona el dep\u00f3sito a confirmar","Gracias","errorFile");
        });
}

/**
 * Function to show staff's answer about incomplete months.
 */
var fn_showAnswers = function() {
    $(".showAnswers").click(function(event){
        event.preventDefault();
        fn_afterMisDatos=fn_scroll;
        $("#btnMisDatos").click();

    });
}

var fn_afterMisDatos = fn_nothing;

/**
 * Function to move the scroll on My Information.
 */
var fn_scroll = function(){
	$("#becaAcordion").click();
    var altura = $("#detalleDeposito").offset().top;
    $("html,body").animate({scrollTop:altura+"px"},"slow");
}

/**
 * Function to create and show the table of deposit's details.
 */
function actTable() {
	if(scholar.scholarship.confirmDispersion != ""){
		$("#accordion-deposit").parent().show();
		$("#accordion-deposit").show();
		$("#tableConfirm > tbody tr td").remove();

	    scholar.scholarship.confirmDispersion.forEach(function (confirms){
	        $("#tableConfirm > tbody tr:last").after('<tr><td class="text-center">'+confirms.monthConfirm+" "+confirms.yearConfirm+'</td>');

	        if (confirms.statusScholarshipReceived === "Incompleta") $("td:last").after('<td class="text-center warning">Dep&oacute;sito incompleto</td>');
	        else if (confirms.statusScholarshipReceived === "No") $("td:last").after('<td class="text-center error">Sin dep&oacute;sito</td>');
	        else if (confirms.statusScholarshipReceived === "Sí") $("td:last").after('<td class="text-center success">'+"Dep&oacute;sito completo"+'</td>');

	        if (confirms.statusReview === "En proceso") $("td:last").after('<td class="text-center warning">'+confirms.statusReview+'</td>');
	        else $("td:last").after('<td>'+confirms.statusReview+'</td>');

	        if (confirms.staffAnswer === "En proceso") $("td:last").after('<td class="text-center warning">'+confirms.staffAnswer+'</td>');
	        else if (confirms.staffAnswer === "Resuelto") $("td:last").after('<td class="text-center success">'+confirms.staffAnswer+'</td>');
	        else $("td:last").after('<td class="text-center">'+confirms.staffAnswer+'</td>');

	    });
	}else {
		$("#accordion-deposit").parent().hide();
		$("#accordion-deposit").hide();
	}
}

/**
 * Function to show files on IMAX visor.
 */
function loadShowUpdateFile(){
	$('a[data-tar="consultFile"][data-loaded="0"]').each(function(){
		$(this).on('click',function(e){
			e.preventDefault();
			pre_fnloadFile($(this).attr("data-folio"));
			$(this).attr("data-loaded","1");
		})
	});
	$('[data-btn="uploadFiles"][data-loaded="0"]').each(function(){
		$(this).on('click',function(e){
			$("#uploadFiles").attr("data-grade",$(this).attr("data-grade"))
							 .attr("data-period",$(this).attr("data-period"))
							 .attr("data-document",$(this).attr("data-document"));
		});
		$(this).attr("data-loaded","1");
	});
}

/*Shutdown window*/
$(window).bind('beforeunload', function(){
	$.ajax({
		type : 'GET',
		dataType : 'html',
		contentType : "application/json; charset=utf-8",
		url : window.location.origin+"/pkmslogout.form",
		async: false
	});
});
