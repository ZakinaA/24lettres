<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pompier"%>
<%@page import="model.Fonction"%>
<%@page import="model.Intervention"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
<% Pompier p = (Pompier)request.getAttribute("pPompier"); %>

<main style="display: flex; justify-content: center; align-items: center; height: 100vh;">
    <div style="width: 80%; max-width: 1200px; background-color: #ffffff; border-radius: 10px; box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1); padding: 20px;">
        <div class="page-header">
            <h1>Fiche de renseignement :</h1>
        </div>
        <br><br><br><br>
        <div class="pompier-container">
            <div class="deux">
                <div class="pompierInfo">
                    <i class="zmdi zmdi-account-circle zmdi-hc-5x" style="font-size: 200px; margin-right: 20px;"></i>
                </div><br><br><br><br>
                <div class="pompierInfo">
                    <strong>Nom :</strong>
                    <div class="spanConsulter"><%= p.getNom() %></div>
                </div>
                <div class="pompierInfo">
                    <strong>Prénom :</strong>
                    <div class="spanConsulter"><%= p.getPrenom() %></div>
                </div>
                <div class="pompierInfo">
                    <strong>Téléphone :</strong>
                    <div class="spanConsulter"><%= p.getTelephone() %></div>
                </div>
                <div class="pompierInfo">
                    <strong>Date de Naissance :</strong>
                    <div class="spanConsulter"><%= p.getDateNaissance() %></div> 
                </div>
                <div class="pompierInfo">
                    <strong>Fonction :</strong>
                    <div class="spanConsulter">
                        <ul>
                            <% for (Fonction fonction : p.getLesFonctions()) { %>
                                <li><%= fonction.getLibelle() %></li>
                            <% } %>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="un">
                <div class="pompierInfo">
                    <strong>Sexe :</strong>
                    <div class="spanConsulter"><%= p.getSexe() %></div>
                </div>
                <div class="pompierInfo">
                    <strong>Grade :</strong>
                    <div class="spanConsulter"><%= p.getUnGrade().getLibelle() %></div>
                </div>
                <div class="pompierInfo">
                    <strong>Numéro de bip :</strong>
                    <div class="spanConsulter"><%= p.getBip() %></div>
                </div><br>
                <div class="pompierInfo">
                    <strong>Intervention :</strong> <br>
                    <br>
                    <div class="spanConsulter">
                        <ul>
                            <% for (Intervention intervention : p.getLesInterventions()) { %>
                                <li><%= intervention.getLieu() %> - <%= intervention.getDate() %> - <%= intervention.getHeureAppel() %> - <%= intervention.getHeureArrivee() %> - <%= intervention.getDuree() %></li>
                            <% } %>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<style>
.pompier-container {
    display: flex;
    justify-content: space-between;
}

.un,
.deux {
    flex: 1;
    padding: 20px;
    display: flex;
    flex-direction: column;
    align-items: flex-start; 
}

.pompierInfo {
    margin-bottom: 20px;
}

.pompierInfo strong {
    display: inline-block;
    width: 160px; 
}

.pompierInfo .spanConsulter {
    display: inline-block;
    border: 1px solid #ccc;
    padding: 10px;
    border-radius: 5px;
    margin-left: 10px; 
}

.spanConsulter ul {
    list-style: none;
    padding: 0;
}

.spanConsulter ul li {
    margin-bottom: 5px;
}

</style>