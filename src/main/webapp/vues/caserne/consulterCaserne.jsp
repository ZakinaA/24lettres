<%-- 
    Document   : consulterPompier
    Created on : 18 mars 2024, 12:03:07
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Caserne"%>
<%@page import="model.Vehicule"%>
<%@page import="model.Pompier"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <%
    Caserne c = (Caserne)request.getAttribute("cCaserne");
    if (c != null) {
%>
    <h1> <%= c.getId() %> | <%= c.getNom() %> </h1>
    <div class="pompier">
        <main>
            <div class="un">
                <div class="pompierInfo">
                    <label>ID :</label>
                    <span><%= c.getId() %></span>
                </div>
                <div class="pompierInfo">
                    <label>Nom :</label>
                    <span><%= c.getNom() %></span>
                </div>
                <div class="pompierInfo">
                    <label>Rue :</label>
                    <span><%= c.getRue() %></span>
                </div>
                <div class="pompierInfo">
                    <label>Code postal :</label>
                    <span><%= c.getCopos() %></span>
                </div>
                <div class="pompierInfo">
                    <label>Ville :</label>
                    <span><%= c.getVille() %></span>
                </div>
                    <label>Pompiers :</label>
                <div>
                    <ul>
                        <% for (Pompier pompier : c.getLesPompiers()) { %>
                            <li><%= pompier.getNom() %> <%= pompier.getPrenom() %></li>
                        <% } %>
                    </ul>
                </div> <label>Vehicule :</label>
                <div>
                    <ul>
                        <% for (Vehicule vehicule : c.getLesVehicules()) { %>
                            <li><%= vehicule.getId() %> <%= vehicule.getImmat() %></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </main>
    </div>
<%
    } else {
        out.println("Grade not found or null.");
    }
%>
           </main>
                    <style>
                        body, html{
                            margin: 0;
                            padding: 0;
                            height: 100%;
                        }
                        .pompier{
                            display: flex;
                        }
                        .un, .deux{
                            flex:1;
                            padding:20px;
                            box-sizing: border-box;
                        }
                        .deux{
                            marging-right:50px;
                        }
                        .pompierInfo{
                            margin-bottom: 20px;
                        }
                        label{
                            display: block;
                            margin-bottom: 5px;
                            font-weight: bold;
                        }
                        span{
                            display: inline-block;
                            margin-bottom: 5px;
                        }
                    </style>
    </body>
</html>
