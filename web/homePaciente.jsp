<%-- 
    Document   : homePaciente
    Created on : 26-05-2017, 5:39:28
    Author     : aleja
--%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("max-age", 0);
    response.setDateHeader("Expires", 0);
    if (session == null || session.getAttribute("nombre") == null) {
        response.sendRedirect("loginPaciente.jsp"); // No logged-in user found, so redirect to login page.
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
</html>
