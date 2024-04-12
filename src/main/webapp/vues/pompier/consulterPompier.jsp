<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pompier"%>
<%@page import="model.Caserne"%>
<%@page import="model.Grade"%>
<%@page import="model.Fonction"%>
<%@page import="model.Intervention"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<% Pompier p = (Pompier)request.getAttribute("pPompier"); %>
        <main>
            <div class="page-header">
                <h1>Fiche de renseignement : </h1>
            </div>
            <br>
            <br> 
            <br>
            <br>
            <div class="pompier">
        <div class="un">
            <div class="pompierInfo">
                <strong><div class="labelConsulter">ID :</div></strong>
                <div class="spanConsulter"><%= p.getId() %></div>
            </div>
            <div class="pompierInfo">
               <strong> <div class="labelConsulter">Nom :</div></strong>
                <div class="spanConsulter"><%= p.getNom() %></div>
            </div>
            <div class="pompierInfo">
                <strong><div class="labelConsulter">Sexe :</div></strong>
                <div class="spanConsulter"><%= p.getSexe() %></div>
            </div>
            <div class="pompierInfo">
                <strong><div class="labelConsulter">Téléphone :</div></strong>
                <div class="spanConsulter"><%= p.getTelephone() %></div>
            </div>
            <div class="pompierInfo">
               <strong> <div class="labelConsulter">Caserne :</div></strong>
                <div class="spanConsulter"><%= p.getUneCaserne().getNom() %></div>
            </div>
            <div class="pompierInfo">
                <strong><div class="labelConsulter">Fonction :</div></strong>
                <ul>
                    <% for (Fonction fonction : p.getLesFonctions()) { %>
                        <li><div class="spanConsulter"><%= fonction.getLibelle() %></div></li>
                    <% } %>
                </ul>
            </div>
        </div>
        <div class="deux">
            <div class="pompierInfo">
                <strong><div class="labelConsulter">Date de Naissance :</div></strong>
                <div class="spanConsulter"><%= p.getDateNaissance() %></div>
            </div>
            <div class="pompierInfo">
               <strong> <div class="labelConsulter">Prénom :</div></strong>
                <div class="spanConsulter"><%= p.getPrenom() %></div>
            </div>
            <div class="pompierInfo">
               <strong> <div class="labelConsulter">Grade :</div></strong>
                <div class="spanConsulter"><%= p.getUnGrade().getLibelle() %></div>
            </div>
            <div class="pompierInfo">
               <strong> <div class="labelConsulter">Numéro de Bip :</div></strong>
                <div class="spanConsulter"><%= p.getBip() %></div>
            </div>
             <div class="pompierInfo">
                <strong><div class="labelConsulter">Intervention :</div></strong>
                <ul>
                    <% for (Intervention intervention : p.getLesInterventions()) { %>
                        <li><div class="spanConsulter"><%= intervention.getLieu() %></div></li>
                        <li><div class="spanConsulter"><%= intervention.getDate() %></div></li>
                        <li><div class="spanConsulter"><%= intervention.getHeureAppel() %></div></li>
                        <li><div class="spanConsulter"><%= intervention.getHeureArrivee() %></div></li>
                        <li><div class="spanConsulter"><%= intervention.getDuree() %></div></li>
                        </br>
                    <% } %>
                        
                </ul>
            </div>
        </div>
    </div>

        </main>

    </div>
                            