<%-- 
    Document   : consulterPompier
    Created on : 18 mars 2024, 12:03:07
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Grade"%>
<%@page import="model.Pompier"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <%
    Grade g = (Grade)request.getAttribute("pGrade");
    if (g != null) {
%>
    <h1> <%= g.getId() %> | <%= g.getLibelle() %> </h1>
    <div class="pompier">
        <main>
            <div class="un">
                <div class="pompierInfo">
                    <label>ID :</label>
                    <span><%= g.getId() %></span>
                </div>
                <div class="pompierInfo">
                    <label>Libelle :</label>
                    <span><%= g.getLibelle() %></span>
                </div>
                    <label>Pompiers :</label>
                <div>
                    <ul>
                        <% for (Pompier pompier : g.getLesPompiers()) { %>
                            <li><%= pompier.getNom() %> <%= pompier.getPrenom() %></li>
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
