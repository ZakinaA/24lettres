<%-- 
    Document   : consulterCasernes
    Created on : 4 avr. 2024, 11:04:40
    Author     : ts1sio
--%>

<%-- 
    Document   : consulterCasernes
    Created on : 4 avr. 2024, 09:13:20
    Author     : ts1sio
--%>

<%-- 
    Document   : consulterCasernes
    Created on : 28 mars 2024, 15:59:16
    Author     : ts1sio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Caserne"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <h1>Caserne</h1>
        <%
            Caserne c = (Caserne)request.getAttribute("cCaserne");
        %>
        <div class="caserne">
           <main>
               <div class="un">
                   <div class="caserneInfo">
                   <label>ID :</label>
                   <span><%= c.getId() %></span>
                   </div>
                   <div class="caserneInfo">
                   <label>Nom :</label>
                   <span><%= c.getNom() %></span>
                   </div>
                   <div class="caserneInfo">
                   <label>Rue :</label>
                   <span><%= c.getRue() %></span>
                   </div>
                   <div class="caserneInfo">
                   <label>Copos :</label>
                   <span><%= c.getCopos() %></span>
                   </div>
                   <div class="caserneInfo">
                   <label>Ville :</label>
                   <span><%= c.getVille %></span>
                   </div>
                   <div class="caserneInfo">
                   <label>Fonction :</label>
                </div>
               </div>
           </main>
    </body>
</html>

