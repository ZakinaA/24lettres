<%-- 
    Document   : consulterPompier
    Created on : 18 mars 2024, 12:03:07
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Fonction"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <%
            Fonction f = (Fonction)request.getAttribute("fFonction");
        %>
        <h1>Bienvenue <%  out.println(p.getLibelle());%>  <%  out.println(f.getLibelle());%></h1>
        
    </body>
</html>
