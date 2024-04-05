<%-- 
    Document   : ConsulterIntervention
    Created on : 4 avr. 2024, 10:39:32
    Author     : mahdi.ashuri
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Intervention"%>
<%@page import="model.Pompier"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <% Intervention i = (Intervention)request.getAttribute("iNom"); %>
        <% if (i != null) { %>
        <h1>Les pompiers de l'intervention  <% out.println(i.getLieu()); %>  sont : </h1>
        <% } else { %>
        <h1>Aucune intervention n'a été trouvée.</h1>
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
