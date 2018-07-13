function restExec(restToExe){
	var secRestToExe = {
		"service": restToExe.service,
		"data": restToExe.data || {},
		"async": restToExe.async || false,
		"success": restToExe.success || rest_fnNothig,
		"error": restToExe.error || rest_fnShowError,
		//"showWait": restToExe.showWait || false,
		"finallySuccess": restToExe.finallySuccess || rest_fnNothig,
		"finallyError": restToExe.finallyError || rest_fnNothig
	};
	console.log("datos a enviar: ",secRestToExe.data);
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
				//if(secRestToExe.showWait){$("#"+SCONFIG.getMessage('wait').idModal).modal('hide');}
				secRestToExe.success(data);
				secRestToExe.finallySuccess(data);
			},
			error : function(error) {
				console.log(error);
				//if(secRestToExe.showWait){$("#"+SCONFIG.getMessage('wait').idModal).modal('hide');}
				//error['serviceName']=secRestToExe.service;
				secRestToExe.error(error);
				//alert(error.responseJSON.message);
				secRestToExe.finallyError(error);
			}
		});
	}/*
	if(secRestToExe.showWait){
		if(restToExe.customWait){
			modal.title = restToExe.customWait.title || modal.title;
			modal.message = restToExe.customWait.message || modal.message;
		}
		$('#'+modal.idModal).modal();
		rest_fnShowWait(modal);
		setTimeout(function () {
	        rest_execute();
	    }, 400);
	}else{*/
		console.log("else");
		rest_execute();
	//}

}

/*FUNCIONES GENERALES*/
var rest_fnNothig = function(obj){console.log("nothing");return};

var rest_fnShowError = function(error){
	console.log("rest_fnShowError");
	console.log(error);
	$(".waitModal").fadeOut("slow");
	msj=error.responseJSON.message;
	showError(msj);
	return;
}

function showSuccess(successResp){
	$("span[name='iconMsj']").removeClass("icon-71");
	$("#messages").removeClass("message-error");
	$("span[name='iconMsj']").addClass("icon-153");
	$("#messages").addClass("message-success");
	$("#messages").html(successResp);
	$(".messaggeModal").fadeIn("slow");
}
function showError(errorResp){
	$("span[name='iconMsj']").removeClass("icon-153");
	$("#messages").removeClass("message-success");
	$("span[name='iconMsj']").addClass("icon-71");
	$("#messages").addClass("message-error");
	$("#messages").html(errorResp);
	$(".messaggeModal").fadeIn("slow");
}
function showWait(mensaje,fn_sw){
	$("#waitMessage").html(mensaje);
	$(".waitModal").fadeIn("slow",fn_sw);
}
/*OPERACIONES CON LAS RESPUESTAS*/
var rest_fnValidationScholar = function(resp){
	console.log(rest_fnValidationScholar);
	console.log(resp);
	scholarValidation.isScholarValid=resp.isScholarValid;
	scholarValidation.studentCompleteName=resp.studentCompleteName;
	scholarValidation.studentEmail=resp.studentEmail;
}

var rest_fnGetStatusScholar = function(resp){
	console.log(resp);
	getStatus.statusCode=resp.statusCode;
	getStatus.statusDescription=resp.statusDescription
}

var rest_fnUpdatePassword = function(resp){
	console.log("rest_fnUpdatePassword");
	console.log(resp);
        if(resp.statusCode == "MDO_000"){
            $("#btnAceptMessage").click(redirectToLogin);
            showSuccess("Tu contrase\u00F1a se ha actualizado correctamente");
        }else if(resp.statusCode== "MDO_008" ||
             resp.statusCode== "MDO_013" ||
             resp.statusCode== "MDO_015" ||
             resp.statusCode== "MDO_017" ||
             resp.statusCode== "MDO_020" ||
             resp.statusCode== "MDO_021") showError(resp.statusDescription+" ("+resp.statusCode+").");
         else showError("Ocurri\u00f3 un problema, por favor intentalo m\u00e1s tarde");
}

var rest_fnCreateScholarship = function(resp){
	console.log("rest_fnCreateScholarship");
	console.log(resp);
	$("#btnAceptMessage").click(redirectToLogin);
	showSuccess("Tu cuenta ha sido activada");
}

var rest_fnReactivation=function(resp){
	console.log(resp);
    if(resp.statusCode == "MDO_000"){
        $("#btnAceptMessage").click(redirectToLogin);
        showSuccess("Tu cuenta ha sido reactivada");
    }else if(resp.statusCode == "MDO_008" ||
             resp.statusCode == "MDO_015" ||
            resp.statusCode == "MDO_016" ||
            resp.statusCode == "MDO_017" ) showError(resp.statusDescription+" "+resp.statusCode+").");
    else showError("Ocurri\u00f3 un problema, por favor intentalo m\u00e1s tarde");
}
