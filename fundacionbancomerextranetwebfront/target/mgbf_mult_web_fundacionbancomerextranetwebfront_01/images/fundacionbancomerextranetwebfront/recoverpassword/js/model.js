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
		"finallySuccess": restToExe.finallySuccess || rest_fnNothig,
		"finallyError": restToExe.finallyError || rest_fnNothig
	};
	writeLog("datos a enviar: ",secRestToExe.data);
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
				secRestToExe.success(data);
				secRestToExe.finallySuccess(data);
			},
			error : function(error) {
				writeLog(error);
				secRestToExe.error(error);
				secRestToExe.finallyError(error);
			}
		});
	}
		writeLog("else");
		rest_execute();
}

/*General functions*/

/**
 * Function doesn't do anything.
 * @param {object} obj Return nothing.
 */
var rest_fnNothig = function(obj){writeLog("nothing");return};

/**
 * Function to catch error.
 * @param {object} error Data of the error.
 */
var rest_fnShowError = function(error){
	writeLog("rest_fnShowError");
	writeLog(error);
	$(".waitModal").fadeOut("slow");
	msj=error.responseJSON.message;
	showError(msj);
	return;
}

/**
 * Function to show success modal.
 * @param {object} Response data of succesful transaction.
 */
function showSuccess(successResp){
	$("span[name='iconMsj']").removeClass("icon-71");
	$("#messages").removeClass("message-error");
	$("span[name='iconMsj']").addClass("icon-153");
	$("#messages").addClass("message-success");
	$("#messages").html(successResp);
	$(".messaggeModal").fadeIn("slow");
}

/**
 * Function to show error modal.
 * @param {string} explanation of error.
 */
function showError(errorResp){
	$("span[name='iconMsj']").removeClass("icon-153");
	$("#messages").removeClass("message-success");
	$("span[name='iconMsj']").addClass("icon-71");
	$("#messages").addClass("message-error");
	$("#messages").html(errorResp);
	$(".messaggeModal").fadeIn("slow");
}

/**
 * Function to show wait modal.
 * @param {string} mensaje Message/Description.
 * @param {function} fn_sw   Function to execute when wait modal finished to fade in.
 */
function showWait(mensaje,fn_sw){
	$("#waitMessage").html(mensaje);
	$(".waitModal").fadeIn("slow",fn_sw);
}

/**
 * Function that is executed when the service validate scholar response correctly(status code=200).
 * @param {object} resp Response of service validate scholar.
 */
var rest_fnValidationScholar = function(resp){
	writeLog(rest_fnValidationScholar);
	writeLog(resp);
	scholarValidation.isScholarValid=resp.isScholarValid;
	scholarValidation.studentCompleteName=resp.studentCompleteName;
	scholarValidation.studentEmail=resp.studentEmail;
}

/**
 * Function that is executed when the service getStatusScholarshipUser response correctly(status code=200).
 * @param {object} resp Response of service getStatusScholarshipUser.
 */
var rest_fnGetStatusScholar = function(resp){
	writeLog(resp);
	getStatus.statusCode=resp.statusCode;
	getStatus.statusDescription=resp.statusDescription
}

/**
 * Function that is executed when the service updatePasswordScholarshipUser response correctly(status code=200).
 * @param {object} resp Response of service updatePasswordScholarshipUser.
 */
var rest_fnUpdatePassword = function(resp){
	writeLog("rest_fnUpdatePassword");
	writeLog(resp);
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

/**
 * Function that is executed when the service createScholarshipUser response correctly(status code=200).
 * @param {object} resp Response of service createScholarshipUser.
 */
var rest_fnCreateScholarship = function(resp){
	writeLog("rest_fnCreateScholarship");
	writeLog(resp);
	$("#btnAceptMessage").click(redirectToLogin);
	showSuccess("Tu cuenta ha sido activada");
}

/**
 * Function that is executed when the service requestReactivationaScholarshipUser response correctly(status code=200).
 * @param {object} resp Response of service requestReactivationaScholarshipUser.
 */
var rest_fnReactivation=function(resp){
	writeLog(resp);
    if(resp.statusCode == "MDO_000"){
        $("#btnAceptMessage").click(redirectToLogin);
        showSuccess("Tu cuenta ha sido reactivada");
    }else if(resp.statusCode == "MDO_008" ||
             resp.statusCode == "MDO_015" ||
            resp.statusCode == "MDO_016" ||
            resp.statusCode == "MDO_017" ) showError(resp.statusDescription+" "+resp.statusCode+").");
    else showError("Ocurri\u00f3 un problema, por favor intentalo m\u00e1s tarde");
}
