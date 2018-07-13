<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="org.springframework.web.context.request.ServletRequestAttributes" %>
<%@ page import="org.springframework.web.context.request.RequestContextHolder" %>

<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
	<!--[if lt IE 9]>
      <script type="text/javascript" src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, shrink-to-fit=no, user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-cache" />  
        <meta http-equiv="Pragma" content="no-cache" />
	<script>
		var ivTicket="<%=request.getHeader("iv_ticketservice")%>";
		var ivUser="<%=request.getHeader("iv-user")%>";
	</script>
	<script src="../../jsArquitectura/dojo/dojo.js"></script>
	<script src="js/libs/jquery-2.1.1.min.js"></script>
	<meta name="description" content="project_name" />
	<meta name="author" content="project_name" />
	<title>Restore password</title>
	<link rel="stylesheet" type="text/css" href="css/bundleRecover.css">
	 <%
	HttpServletRequest requesttr = null;
    ServletRequestAttributes request1 = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    request1.getRequest().getSession().setAttribute("iv-ticketservice",null);
    request1.getRequest().getSession().setAttribute("iv-user",null);
	request1.getRequest().getSession().setMaxInactiveInterval(5400);
	%>
	<script>
	    //****************************************Configuración de DOJO**************************************//

        dojoConfig = {
            isDebug: true,
            parseOnLoad: false,
            foo: "bar"
        };
        //***************************LLamadas de dojo para habilitar ciertas funciones************************//
        dojo.require("dijit._Templated");
        //Es necesario para el uso de las funciones de wipe
        dojo.require("dojo.fx");
    </script>
    <script src="js/conf.services.js"></script>
    <script src="js/context.js"></script>
    <script src="js/validationsLogin.js"></script>
    <script src="js/model.js"></script>
</head>

<body>
   <div id="templateRecover">
    <div class="page-layout-cover recover-password">
        <main class="container columns">
            <div class="column sidebar">
            </div>
            <div class="column main">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <form action="new-password.html" class="form-gray" method="post">
                                <h1>Recupera tu contrase&ntilde;a</h1>
                                <div class="row">
                                    <div class="col-12 col-sm-6">
                                        <h2>Datos del becario</h2>
                                        <div class="form-group row">
                                            <div class="col-12">
                                                <label>Nombre(s)</label>
                                                <input class="form-control letras" name="name" id="name" type="text" data-placeholder="Ingresa tu nombre(s)" onkeyup="this.value=this.value.toUpperCase()" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-12">
                                                <label>Apellido paterno</label>
                                                <input class="form-control letras" name="surname1" id="surname1" type="text" data-placeholder="Ingresa tu apellido paterno" onkeyup="this.value=this.value.toUpperCase()" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-12">
                                                <label>Apellido materno
                                                <span class="icon icon-200" data-tooltip="Opcional para becarios nacidos en EUA y que no cuenten con apellido materno"></span>
                                                </label>
                                                <input class="form-control letras" name="surname2" id="surname2" type="text" data-placeholder="Ingresa tu apellido materno" data-optional-text="opcional para becarios nacidos en EUA" onkeyup="this.value=this.value.toUpperCase()">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-12">
                                                <label>CURP
                                                <span class="icon icon-200" data-tooltip="&iquest;No sabes cu&aacute;l es tu CURP? Cons&uacute;ltalo <a href='https://consultas.curp.gob.mx' target='_blank'>aqu&iacute;</a>"></span>
                                                </label>
                                                <input class="form-control" name="curp" id="curpRecover" type="text" data-placeholder="Ingresa tu CURP" onkeyup="this.value=this.value.toUpperCase()" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-sm-6">
                                        <h2>Datos del tutor</h2>
                                        <div class="form-group row">
                                            <div class="col-12">
                                                <label>Nombre(s)</label>
                                                <input class="form-control letras" name="tutor_name" id="tutor_name" type="text" data-placeholder="Ingresa nombre(s) de tutor" onkeyup="this.value=this.value.toUpperCase()" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-12">
                                                <label>Apellido paterno</label>
                                                <input class="form-control letras" name="tutor_surname1" id="tutor_surname1" type="text" data-placeholder="Ingresa apellido paterno de tutor" onkeyup="this.value=this.value.toUpperCase()" required>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-12">
                                                <label>Apellido materno
                                                    <span class="icon icon-200" data-tooltip="Opcional para tutores nacidos en EUA y que no cuenten con apellido materno"></span>
                                                </label>
                                                <input class="form-control letras" name="tutor_surname2" id="tutor_surname2" type="text" data-placeholder="Ingresa apellido materno de tutor" data-optional-text="opcional para becarios nacidos en EUA" onkeyup="this.value=this.value.toUpperCase()">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-footer">
                                    <div class="form-group">
                                        <input class="btn btn-primary" type="submit" id="btnRecoverPassword" value="Enviar" />
                                    </div>
                                    <div class="form-group">
                                        <a href="#" class="link" id="signIn">&iquest;Ya tienes cuenta?</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
   </div>
   <div class="outer messaggeModal" style="display:none;">
		<div class="middle">
			<div class="inner">
				<span name="iconMsj" class="icon"></span>
				<div id="messages"></div>
				<input class="btn-primary" type="button" id="btnAceptMessage" value="Aceptar" />
			</div>
		</div>
	</div>
	<div class="outer waitModal" style="display:none;">
		<div class="middle">
			<div class="inner pad">
				<span class="icon icon-168"></span>
				<div id="waitMessage">Enviando tu contrase&ntilde;a, por favor espera un momento</div>
			</div>
		</div>
	</div>
    <script src="js/bundleRecover.js"></script>
</body>

</html>
