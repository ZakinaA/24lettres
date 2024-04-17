<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Vehicule"%>
<%@page import="model.Intervention"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
<% 
    Vehicule vehicule = (Vehicule) request.getAttribute("vVehicule");
    ArrayList<Intervention> lesInterventions = (ArrayList<Intervention>) request.getAttribute("lesInterventions");

    if (vehicule != null) {
%>

<main style="display: flex; justify-content: center; align-items: center; height: 100vh;">
    <div style="width: 80%; max-width: 1200px; background-color: #ffffff; border-radius: 10px; box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1); padding: 20px;">
        <div class="page-header">
            <h1>Fiche de renseignement du véhicule Nº <%= vehicule.getId() %> :</h1>
        </div>
        <br><br><br><br>
        <div class="pompier-container">
            <div class="deux"> 
                <div class="pompierInfo">
                <i class="zmdi zmdi-car zmdi-hc-5x" style="font-size: 200px; margin-right: 20px;"></i>
            </div>
            <div class="pompierInfo">
                <strong>Immatriculation :</strong>
                <div class="spanConsulter"><%= vehicule.getImmat() %></div>
            </div>
            <div class="pompierInfo">
                <strong>Type de véhicule :</strong>
                <div class="spanConsulter"><%= vehicule.getTypeVehicule().getNom() %></div>
            </div>
            </div>
            <div class="un"> 
                <div class="pompierInfo">
                <strong>Date d'origine :</strong>
                <div class="spanConsulter"><%= vehicule.getDateOrigine() %></div>
            </div>
            <div class="pompierInfo">
                <strong>Date de révision :</strong>
                <div class="spanConsulter"><%= vehicule.getDateRevision() %></div>
            </div>
            <div class="pompierInfo">
                <strong>Intervention :</strong>
                <br>
                <br>
                <ul>
                    <% for (Intervention intervention : lesInterventions) { %>
                    <li><%= intervention.getId() %> - <%= intervention.getLieu() %> - <%= intervention.getDate() %></li>
                    <% } %>
                </ul>
            </div>

            </div>
        </div>
    </div>
</main>
<%
    } else {
        out.println("Aucun véhicule trouvé.");
    }
%>
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