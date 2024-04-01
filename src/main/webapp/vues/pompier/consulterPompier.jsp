<%-- 
    Document   : consulterPompier
    Created on : 18 mars 2024, 12:03:07
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pompier"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <%
            Pompier p = (Pompier)request.getAttribute("pPompier");
        %>
        <h1>Bienvenue <%  out.println(p.getPrenom());%>  <%  out.println(p.getNom());%></h1>
       <div class="pompier">
           <main>
               <div class="un">
                   <div class="pompierInfo">
                   <label>ID :</label>
                   <span><%= p.getId() %></span>
                   </div>
                   <div class="pompierInfo">
                   <label>Nom :</label>
                   <span><%= p.getNom() %></span>
                   </div>
                   <div class="pompierInfo">
                   <label>Sexe :</label>
                   <span><%= p.getSexe() %></span>
                   </div>
                   <div class="pompierInfo">
                   <label>Téléphone :</label>
                   <span><%= p.getTelephone() %></span>
                   </div>
                   <div class="pompierInfo">
                   <label>Caserne :</label>
                   <span><%= p.getUneCaserne().getNom() %></span>
                   </div>
                   <div class="pompierInfo">
                   <label>Fonction :</label>
                </div>
               </div>
           </main>
            <div class="deux">
                <main>
                        <div class ="pompierInfo">
                        <label>Date de Naissance :</label>
                        <span><%= p.getDateNaissance() %></span>
                        </div>
                        <div class="pompierInfo">
                        <label>Prénom :</label>
                        <span><%= p.getPrenom() %></span>
                        </div>
                        <div class="pompierInfo">
                        <label>Grade :</label>
                        <span><%= p.getUnGrade().getLibelle() %></span>
                        </div>
                        <div class="pompierInfo">
                        <label> Numéro de Bip :</label>
                        <span><%= p.getBip() %></span>
                        </div>
                    
                </main>
            </div>
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
