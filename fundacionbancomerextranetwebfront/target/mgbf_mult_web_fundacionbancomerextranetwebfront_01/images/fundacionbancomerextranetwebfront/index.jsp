<!--Index, es la base para toda la p&aacute;gina y su distribuci&oacute;n ya que en esta secci&oacute;n se colocan los templates principales de cada una de las cuatro pestañas con base en la que el becario seleccione.-->
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
	<!--[if lt IE 9]>
      <script type="text/javascript" src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, shrink-to-fit=no, user-scalable=no" />
	<meta name="description" content="project_name" />
	<meta name="author" content="project_name" />
	<meta http-equiv="Cache-Control" content="no-cache" />
    <meta http-equiv="Pragma" content="no-cache" />
	<title>Index</title>
	<link rel="stylesheet" type="text/css" href="fundacionbancomerextranetwebfront/css/bundle.css">
	<link rel="stylesheet" href="fundacionbancomerextranetwebfront/css/style.css">
	<script src="jsArquitectura/dojo/dojo.js"></script>
	<script src="fundacionbancomerextranetwebfront/js/contexto.js"></script>
	<script src="fundacionbancomerextranetwebfront/js/controlador.js"></script>
	<script src="fundacionbancomerextranetwebfront/js/services.conf.js"></script>
	<script src="fundacionbancomerextranetwebfront/scripts/lib/jquery-2.1.1.min.js"></script>
	<script src="fundacionbancomerextranetwebfront/js/modelo.js"></script>
	 <%@ page import="javax.servlet.http.HttpServletRequest" %>
	 <%@ page import="org.springframework.web.context.request.ServletRequestAttributes" %>
	 <%@ page import="org.springframework.web.context.request.RequestContextHolder" %>

	 <%
	HttpServletRequest requesttr = null;
    ServletRequestAttributes request1 = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    request1.getRequest().getSession().setAttribute("iv-ticketservice", "Wv8bfGBrnP1AdTdCzTHjHF62wPv9oUmPypPtGtCsmZbyU0e23swvZg==");
    request1.getRequest().getSession().setAttribute("iv-user", "FUN00000269");
	%>
</head>
<body>
	<div id="secLoading" style="text-align: center; font-size: 17px;">Cargando...</div>
	<div class="page-layout-1column index" style="display: none;">
		<header class="container">
			<div class="row">
				<div class="col-12">
					<div class="container">
						<div class="row">
							<div class="col-10">
								<img alt="" class="logo" src="fundacionbancomerextranetwebfront/images/logo.png">
							</div>
							<div class="col-2 exitarea">
								<a href="#"><span class="icon icon-149"></span><span>Salir</span></a>
							</div>
						</div>
					</div>
				</div>
				<nav class="btn-group btn-group-lg col-12" role="group">
					<a class="btn btn-primary col" href="#" id="btnHome">
                        <span class="icon icon-142"></span>
                    </a>
					<a class="btn btn-primary col" href="#" id="btnMiBeca">
					    <span class="icon icon-49"></span>
					    <span class="btn-text">Mi Beca</span>
				    </a>
					<a class="btn btn-primary col"  href="#" id="btnMisCalificaciones">
					    <span class="icon icon-66"></span>
					    <span class="btn-text">Mis calificaciones</span>
				    </a>
					<a class="btn btn-primary col" href="#" id="btnMisDatos">
					    <span class="icon icon-161"></span>
					    <span class="btn-text">Mis datos</span>
				    </a>
				<!--
                    <a class="btn btn-primary col" href="#" id="btnMisTutores">
					    <span class="icon icon-128"></span>
					    <span class="btn-text">Mis tutores</span>
				    </a>
				-->
				</nav>
			</div>
		</header>
		<div id="scholarheader"></div>
    </div>
    <div id="templateInicio"></div>
    <!-- Scholar Profile Picture -->
	<div class="modal show" id="uploadScholarImage" role="dialog" data-backdrop="static" data-keyboard="false">
	    <div class="modal-dialog modal-lg" role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title">Imagen de perfil</h5>
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                    <span aria-hidden="true">&times;</span>
	                </button>
	            </div>
	            <div class="alert alert-danger" role="alert" id="mssgError" style="display: none;">
	                <i class="icon icon-71"></i><span></span>
	            </div>
	            <div class="modal-body">
	                <div class="dropzone" id="upload-scholarImage">
	                    <div class="title">Arrastra y suelta tu foto aquí</div>
	                    <div>(Hasta 1 archivo)</div>
	                    <div>
	                        <div class="icon-wrapper"><i class="icon icon-15"></i></div>
	                    </div>
	                    <div>o selecciona tu imagen desde tu computadora.</div>
	                    <div>
	                        <label class="btn btn-default btn-file mt-4" id="uploadImage">
	                              Seleccionar imagen
	                        </label>
	                    </div>

	                </div>
	            </div>
	            <div class="modal-footer">
	                <ul>
	                    <li> Imagen en formato JPG
	                    <li>No deben exceder los 10MB
	                </ul>
	            </div>
	        </div>
	    </div>
	</div>
    <!-- Error File-->
    <div class="modal show" id="errorFile" role="dialog" data-backdrop="static" data-keyboard="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-body message-system danger">
                    <div class="icon-wrapper"><i class="icon icon-71"></i></div>
                    <h2>Ocurri&oacute; un error</h2>
                    <p>Mensaje explicación del error en la <br> aplicación.</p>
                    <button class="btn btn-primary" data-dismiss="modal" type="button">Entendido</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Save File-->
    <div class="modal show" id="savedFile" role="dialog" data-backdrop="static" data-keyboard="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-body message-system success">
                    <div class="icon-wrapper"><i class="icon icon-153"></i></div>
                    <h2>Se carg&oacute; correctamente</h2>
                    <p id="messageSuccessModal">Mensaje de operación <br> satisfactoria.</p>
                    <button class="btn btn-primary" data-dismiss="modal" type="button">Entendido</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Wait Modal -->
    <div class="modal show" id="waitModal" role="dialog" data-backdrop="static" data-keyboard="false" style="display: block;">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-body message-system info">
                    <div class="icon-wrapper"><i class="icon icon-168"></i></div>
                    <h2>Cargando informaci&#243;n.</h2>
                    <p>Por favor espera.</p>
                </div>
            </div>
        </div>
    </div>
    <!-- Consult Files-->
    <div class="modal show" id="consultFiles" role="dialog" data-backdrop="static" data-keyboard="false">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Consultar documento</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="preview">
                        <iframe id="show_file" src=""></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<script src="fundacionbancomerextranetwebfront/scripts/lib/moment-with-locales.min.js"></script>
	<script src="fundacionbancomerextranetwebfront/scripts/lib/tether.min.js"></script>
	<script src="fundacionbancomerextranetwebfront/scripts/lib/bootstrap.min.js"></script>
	<script src="fundacionbancomerextranetwebfront/scripts/lib/bootstrap-datetimepicker.min.js"></script>
	<script src="fundacionbancomerextranetwebfront/scripts/lib/dropzone.js"></script>
	<script src="fundacionbancomerextranetwebfront/scripts/lib/oliva.js"></script>
	<script src="fundacionbancomerextranetwebfront/scripts/lib/vostro.js"></script>
    <script src="fundacionbancomerextranetwebfront/js/plantillas.fn.js"></script>
    <script src="fundacionbancomerextranetwebfront/js/plantillas.conf.js"></script>
</body>

</html>
