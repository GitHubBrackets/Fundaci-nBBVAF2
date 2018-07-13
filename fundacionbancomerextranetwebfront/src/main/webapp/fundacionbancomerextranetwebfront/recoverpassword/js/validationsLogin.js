$(document).ready(function () {
//***********************************************EXPRESIONES REGULARES*************************************************************//
//Numeros ascendentes
    const expRegAscNum = /01|12|23|34|45|56|67|78|89/;
//Números descendentes
    const expRegDesNum = /98|87|76|65|54|43|32|21|10/;
//No permite repetir números o letras más de 2 veces
    const expRegRepeat= /((.+)?)((.)\4\4)((.+)?)/;
    const expRegHasNumber= /\d/;
    const expRegHasLetter= /[a-zA-Z]/;
//CURP
    const expCurp = /^[A-Z]{1}[AEIOU]{1}[A-Z]{2}[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])[HM]{1}(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)[B-DF-HJ-NP-TV-Z]{3}[0-9A-Z]{1}[0-9]{1}$/;

//*************************************************RESPUESTA DEL LOGIN*************************************************************//
    /**
 * Obtiene la ruta raíz de la página
 * @returns {string} url con la ruta
 */
function getRootPath() {
    _url = window.location.href;
    if (_url.charAt(_url.length - 1) === "/") {
        return _url;
    }
    return _url.substring(0, _url.lastIndexOf("/"));
}

dojo.registerModulePath("template", getRootPath() + "/template");
//************************************PERMITE INTRODUCIR CON EL TECLADO SOLO LETRAS***********************************************//
    $(".letras").keypress(function (key) {
        if ((key.charCode < 97 || key.charCode > 122)//letras mayusculas
                    && (key.charCode < 65 || key.charCode > 90) //letras minusculas
                    && (key.charCode !== 241) //ñ
                    && (key.charCode !== 209) //Ñ
                    && (key.charCode !== 32) //espacio
                    && (key.charCode !== 225) //á
                    && (key.charCode !== 233) //é
                    && (key.charCode !== 237) //í
                    && (key.charCode !== 243) //ó
                    && (key.charCode !== 250) //ú
                    && (key.charCode !== 193) //Á
                    && (key.charCode !== 201) //É
                    && (key.charCode !== 205) //Í
                    && (key.charCode !== 211) //Ó
                    && (key.charCode !== 218) //Ú
                    && (key.charCode !== 0) //Borrar
                    ) return false;

            return true;
    });

//*****************************************************VALIDACION CURP***************************************************************//
	$("#btnRecoverPassword").click(function () {
		$("#noCurp").remove();

		if ($("input[name='curp']").val() !== "") {
			curp = $("input[name='curp']").val();
			validacion = expCurp.test(curp);
	    	if (!validacion) {
		    	$("input[name='curp']").focus().after("<span class='text-danger' id='noCurp' style='font-size:80%'>Por favor verifica el CURP</span>");
		    	$("input[name='curp']").blur(function () {
					$("input[name='curp']").addClass("has-error");
				});
	    	}else if($("#tutor_name").val() !== "" &&
	    			 $("#tutor_surname1").val() !== "" &&
	    			 $("#name").val() !== "" &&
	    			 $("#surname1").val() !== ""){
	    				scholarValidation.isScholarValid=-1;
	    				scholarValidation.studentEmail="";
	    				showWait("Validando tu informaci\u00f3n, por favor espera",function(){
		    				restExec({
				    			service: 'VALIDATION_SCHOLAR',
				    			data: {
				    				tutorName:$("#tutor_name").val(),
				    				tutorLastName:$("#tutor_surname1").val(),
				    				tutorSecondLastName:$("#tutor_surname2").val(),
				    				studentName:$("#name").val(),
				    				studentLastName:$("#surname1").val(),
				    				studentSecondLastName:$("#surname2").val(),
				    				studentCURP:$("#curpRecover").val()
				    			},
				    			success: rest_fnValidationScholar,
				    			finallySuccess: function(){
				    				$(".waitModal").fadeOut("slow");
				    				getStatus.statusCode="";
				    				getStatus.statusDescription="";
				    				console.log("scholarValidation.isScholarValid",scholarValidation.isScholarValid);
				    				switch(scholarValidation.isScholarValid){
			    						case 0:
			    							showError("El usuario no existe");
			    							break;
			    						case 1:
			    							dojo.registerModulePath("template", getRootPath() + "/template");
				                			dojo.addOnLoad (function(){
				                				dojo.byId("templateRecover").innerHTML = dojo.cache("template", "new-password.html");
				                				validatePass();
				                			});
			    							break;
			    						case 2:
			    							showError("Usuario suspendido");
			    							break;
				    				}
				    			}
				    		});
                	});
            }
		}
	});

	$("input[name='curp']").keyup(function () {
	    curp = $("input[name='curp']").val();
		validacion = expCurp.test(curp);
		if (validacion) {
            $("#noCurp").fadeOut();
			$("input[name='curp']").blur(function () {
				$("input[name='curp']").removeClass("has-error");
			});
		}
	});

	$("input[name='curp']").keypress(function (key) {
        if ((key.charCode >= 48 && key.charCode <= 57) || (key.charCode >= 65 && key.charCode <= 90) || (key.charCode >= 97 && key.charCode <= 122) || key.charCode == 0) return true;
        	return false;
	});


//***********************************************VALIDACION CONTRASEÑA NUEVA********************************************************//
    function validatePass () {
        var abcdario = "ABCDEFGHIJKLMN\u00D1OPQRSTUVWXYZ";//debe estar en mayusculas
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

        $("#sendPasswords").click(function () {
            $("#differentPass").remove();
            $("#numSec").remove();
            $("#repeat").remove();
            $("#abecedario").remove();
	    $("#noPass").remove();
            $("#elongPass").remove();
            $("#notHasN").remove();
            $("#notHasL").remove();

            pass1 = $("#password1").val();
            pass2 = $("#password2").val();
            errorPW = false;
            //Contraseñas no nulas
            if ((pass1 !== "") && (pass2 !== "")) {
                //Contraseñas diferentes
                if (pass1 !== pass2) {
                    $("#password2").focus().after("<span class='text-danger' id='differentPass' style='font-size:80%'>Contraseñas diferentes, por favor verificalas \n </span>");
                    $("#password1").addClass("has-error");
                    $("#password1, #password2").blur(function () {
                        $("#password1").addClass("has-error");
                        $("#password2").addClass("has-error");
                    });
                    errorPW=true;
                }
                if (pass1.length != 10 || pass2.length != 10) {
                    $("#password2").focus().after("<span class='text-danger' id='elongPass' style='font-size:80%'>Contrase\u00F1as deben tener longitud de 10 caracteres <br /> </span>");
                    $("#password1, #password2").addClass("has-error");
                    $("#password1, #password2").blur(function () {
                    $("#password1, #password2").addClass("has-error");
                    });
                    errorPW=true;
                }
                	if (!expRegHasNumber.test(pass1)) {
                        $("#password2").focus().after("<span class='text-danger' id='notHasN' style='font-size:80%'>Debe contener al menos un n\u00FAmero <br /> </span>");
                        $("#password1, #password2").addClass("has-error");
                        $("#password1, #password2").blur(function () {
                        $("#password1, #password2").addClass("has-error");
                        });
                        errorPW=true;
                    }
                	if (!expRegHasLetter.test(pass1)) {
                            $("#password2").focus().after("<span class='text-danger' id='notHasL' style='font-size:80%'>Debe contener al menos una letra <br /> </span>");
                            $("#password1, #password2").addClass("has-error");
                            $("#password1, #password2").blur(function () {
                            $("#password1, #password2").addClass("has-error");
                            });
                            errorPW=true;
                        }
                    if (expRegAscNum.test(pass1) || expRegDesNum.test(pass1)) {
                    //Contienen números en forma ascendente o descendente
                        $("#password2").focus().after("<span class='text-danger' id='numSec' style='font-size:80%'>No se permiten números de forma ascendente y/o descendente <br /> </span>");
                        $("#password1, #password2").addClass("has-error");
                        $("#password1, #password2").blur(function () {
                        $("#password1, #password2").addClass("has-error");
                        });
                        errorPW=true;
                    }
                    if (expRegRepeat.test(pass1)){
                        //Se repiten más de 2 veces algún carácter
                        $("#password2").focus().after("<span class='text-danger' id='repeat' style='font-size:80%'>No se permiten más de 2 letras y/o números iguales de forma consecutiva <br /></span>");
                        $("#password1, #password2").addClass("has-error");
                        $("#password1, #password2").blur(function () {
                            $("#password1, #password2").addClass("has-error");
                        });
                        errorPW=true;
                    }

                    if(isIncreasing(pass1)){
                        $("#password2").focus().after("<span class='text-danger' id='abecedario' style='font-size:80%'>No se permiten más de 2 letras y/o números iguales de forma consecutiva <br /></span>");
                        $("#password1, #password2").addClass("has-error");
                        $("#password1, #password2").blur(function () {
                            $("#password1, #password2").addClass("has-error");
                        });
                        errorPW=true;
                    }
                    if(!errorPW){
                    	createScholarship.statusCode="";
                    	createScholarship.statusDescription="";
                    	showWait("Por favor espera un momento estamos enviando tu contraseña",function(){
                    		restExec({
    			    			service: 'LDAPSCHOLAR_GETSTATUS',
    			    			data: {
    			    				alias:scholarValidation.studentEmail
    			    			},
    			    			success: rest_fnGetStatusScholar,
    			    			finallySuccess: function(){
    			    				$(".waitModal").fadeOut("slow");
    			    				if(getStatus.statusCode == "SUCESSFUL"){
    			    					updatePassword();
    			    				}else if (getStatus.statusCode == "ERROR"){
    			    					if(getStatus.statusDescription == "El usuario no existe")createScholar();
    			    					else if(getStatus.statusDescription == "El usuario est\u00e1 bloqueado")reactivationScholar();
    			    				}
    			    			}
    			    		});
                    	});
                    }
            }else {
                $("#password2").focus().after("<span class='text-danger' id='noPass' style='font-size:80%'>Por favor llena los campos<br /></span>");
                $("#password1, #password2").addClass("has-error");
                $("#password1, #password2").blur(function () {
                    $("#password1, #password2").addClass("has-error");
                });
                errorPW=true;
            }

        });

        function updatePassword(){
        	restExec({
    			service: 'LDAPSCHOLAR_UPDATEPASSWORD',
    			data: {
    				alias:scholarValidation.studentEmail,
    				password:$("#password1").val()
				},
    			success: rest_fnUpdatePassword
    		});
        }

        function createScholar(){
        	restExec({
    			service: 'LDAPSCHOLAR_CREATE',
    			data: {
    				alias:scholarValidation.studentEmail,
    				password:$("#password1").val()
				},
    			success: rest_fnCreateScholarship,
    			finallySuccess: function(){
    				$("#btnAceptMessage").click(redirectToLogin);
    				showSuccess("Tu cuenta ha sido activada");
    			}
    		});
        }

        function reactivationScholar(){
        	restExec({
    			service: 'LDAPSCHOLAR_REACTIVATION',
    			data: {
    				alias:scholarValidation.studentEmail,
    				password:$("#password1").val()
				},
    			success: rest_fnReactivation
    		});
        }

        $("#password1, #password2").keyup(function () {
            pass1 = $("#password1").val();
            pass2 = $("#password2").val();
            if(pass1 !== "" && pass2 !== ""){
                $("#noPass").fadeOut();
            }
            if (pass1.length == 10 && pass2.length == 10)$("#elongPass").fadeOut();
            if(expRegHasNumber.test(pass1))$("#notHasN").fadeOut();
            if(expRegHasLetter.test(pass1))$("#notHasL").fadeOut();
            if (pass1 === pass2) {
                $("#differentPass").fadeOut();
            }
            if (!expRegAscNum.test(pass1) && !expRegDesNum.test(pass1) && !expRegAscNum.test(pass2) && !expRegDesNum.test(pass2)) {
                $("#numSec").fadeOut();
            }
            if (!expRegRepeat.test(pass1) && !expRegRepeat.test(pass1) && !expRegRepeat.test(pass2) && !expRegRepeat.test(pass2)) {
                $("#repeat").fadeOut();
            }
            if(!isIncreasing(pass1)){
                $("#abecedario").fadeOut();
            }

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

                $("#password1").removeClass("has-error");
                $("#password2").removeClass("has-error");
                $("#password1, #password2").blur(function () {
                    $("#password1, #password2").removeClass("has-error");
                });

            }
        });
    }
    $("#btnAceptMessage").click(function(event){
    	event.preventDefault();
    	$(".outer").fadeOut("slow");
    });

    $("#signIn").click(function(e){
    	e.preventDefault();
    	redirectToLogin();
    });

});

function redirectToLogin(){
	var servOrigin = window.location.origin;
	if(servOrigin.indexOf("localhost")!=-1){//local
		return;
	}else if(servOrigin.indexOf("150.250.238.172")!=-1){//Desarrollo
		window.location=servOrigin+"/mgbfprv_des_mx_web/mgbf_mult_web_fundacionbancomerextranetwebfront_01/";
	}else if(servOrigin.indexOf("150.250.238.173")!=-1){//Test
		window.location=servOrigin+"/mgbfprv_test_mx_web/mgbf_mult_web_fundacionbancomerextranetwebfront_01/";
	}else if(servOrigin.indexOf("calplataformabecas.fundacionbbvabancomer.com.mx")!=-1){//Calidad
		window.location=servOrigin+"/mgbfprv_qa_mx_web/mgbf_mult_web_fundacionbancomerextranetwebfront_01/";
	}else if(servOrigin.indexOf("plataformabecaslo.fundacionbbvabancomer.org")!=-1){//liga oculta
		window.location=servOrigin+"/mgbf_mult_web_fundacionbancomerextranetwebfront_01/";
	}else if(servOrigin.indexOf("plataformabecas.fundacionbbvabancomer.org")!=-1){//Prod
		window.location=servOrigin+"/mgbf_mult_web_fundacionbancomerextranetwebfront_01/";
	}
}
