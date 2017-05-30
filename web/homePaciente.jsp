<%-- 
    Document   : homePaciente
    Created on : 26-05-2017, 5:39:28
    Author     : aleja
--%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("max-age", 0);
    response.setDateHeader("Expires", 0);
    if (session == null || session.getAttribute("nombre") == null) {
        response.sendRedirect("loginPaciente.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>
<html>
    <head>
        <META Http-Equiv="Cache-Control" Content="no-cache">
        <META Http-Equiv="Pragma" Content="no-cache">
        <META Http-Equiv="Expires" Content="0"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Paciente</title>
    </head>
    <body>
        <h1>Pagina Inicio Paciente</h1>
        <h1>${sessionScope.nombre}</h1>
        <h1>${sessionScope.rut}</h1>
        <a href="controller.htm?accion=logout">Cerrar Sesión</a>
    </body>
</html>-->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--<meta name="description" content="">-->
        <!--<meta name="author" content="">-->
        <!--<link rel="icon" href="../../favicon.ico">-->
        <title>Centro Médico Galenos</title>
        <link href="public/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <div class="container">
            <!-- Static navbar -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Centro Médico Galenos</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="#">About</a></li>
                            <li><a href="#">Contact</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Nav header</li>
                                    <li><a href="#">Separated link</a></li>
                                    <li><a href="#">One more separated link</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <!--<li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li>-->
                            <!--<li><a href="../navbar-static-top/">Static top</a></li>-->
                            <!--<li><a href="../navbar-fixed-top/">Fixed top</a></li>-->
                            <li><a href="controller.htm?accion=logout">Cerrar Sesión</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <h1>Navbar example</h1>
                <p>This example is a quick exercise to illustrate how the default, static navbar and fixed to top navbar work. It includes the responsive CSS and HTML, so it also adapts to your viewport and device.</p>
                <p>
                    <a class="btn btn-lg btn-primary" href="../../components/#navbar" role="button">View navbar docs &raquo;</a>
                </p>
                <h3>${sessionScope.nombre}</h3>
                <h4>${sessionScope.rut}</h4>
            </div>
            <a href="controller.htm?accion=logout">Cerrar Sesión</a>
        </div> <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="public/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
