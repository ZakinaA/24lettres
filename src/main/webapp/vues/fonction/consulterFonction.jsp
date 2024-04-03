<%-- 
    Document   : consulterPompier
    Created on : 18 mars 2024, 12:03:07
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Fonction"%>
<%@page import="model.Pompier"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <% Fonction f = (Fonction)request.getAttribute("pfFonction"); %>
        <% if (f != null) { %>
        <h1>Les pompiers de la  <% out.println(f.getLibelle()); %>  sont : </h1>
        <% } else { %>
        <h1>Aucune fonction n'a été trouvée.</h1>
        <% } %>
       
        <table>
            <thead>
                <tr>
                    <th>Id :</th>
                    <th>Nom :</th>
                    <th>Prénom :</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Pompier p : (ArrayList<Pompier>) request.getAttribute("lesPompiers")) {
                        
                            out.println("<tr><td>");
                            out.println(p.getId());
                            out.println("</td>");
                            
                            out.println("<td>");
                            out.println(p.getNom());
                            out.println("</td>");
                            
                            out.println("<td>");
                            out.println(p.getPrenom());
                            out.println("</td>");
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
