<%-- 
    Document   : loginPaciente
    Created on : 26-05-2017, 5:39:51
    Author     : Alejandro Arévalo Sánchez.
--%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("max-age", 0);
    response.setDateHeader("Expires", 0);
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="public/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="public/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="public/css/login-modal.css" rel="stylesheet" type="text/css"/>
        <script src="public/js/funcionesRut.js" type="text/javascript"></script>
    </head>
    <body style="background-color: #d4d4d4">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <h2 class="text-center"><b>Centro Médico Galenos</b></h2>
                    <div class="account-wall">
                        <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=121" alt="">
                        <h4 class="text-center">Acceso pacientes</h4>
                        <form class="form-signin" method="post" action="controller.htm">
                            <c:if test="${msg!=null}">
                                <div class="alert alert-danger">
                                    <strong>Atención!</strong>
                                    ${msg}
                                </div>
                            </c:if>
                            <input type="text" class="form-control" placeholder="Rut" name="rut" id="rut" oninput="formatoRut(this)" onkeypress="return isCharRut(event, this)"  required autofocus>
                            <input type="password" class="form-control" placeholder="Contraseña" name="pass" id="pass" required>
                            <button class="btn btn-lg btn-primary btn-block" type="submit" name="accion" value="autpaciente">Ingresar</button>
                            <label class="checkbox pull-left">
                            </label>
                            <a href="#" class="pull-right need-help">Registrarse</a><span class="clearfix"></span>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
