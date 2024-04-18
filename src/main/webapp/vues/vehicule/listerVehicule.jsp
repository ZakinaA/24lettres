<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pompier"%>
<%@page import="model.Caserne"%>
<%@page import="model.Vehicule"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
<% ArrayList<Vehicule> lesVehicules = (ArrayList)request.getAttribute("vLesVehicules"); %>

<main>
    <div class="page-header">
	<h1>Liste des véhicules :</h1>
        <small>Calvados / Caen</small>
    </div>
    <div class="page-content">
        <div class="records table-responsive">
            <div class="record-header">
                <div class="browse"> </div>
                <div class="add">
                    <button><a href="../ServletVehicule/ajouter"> Ajouter un véhicule</a></button>
                </div>
            </div> 
            <div class="casernes-container" style="display: flex; flex-wrap: wrap;">
                <% for (Vehicule vehicule : lesVehicules) { %>
                    <div class="caserne" style="width: 30%; margin: 5px; padding: 20px; background-color: #f0f0f0; border-radius: 10px; box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1); display: flex; align-items: center;">
                        <i class="zmdi zmdi-directions-car" style="font-size: 48px; margin-right: 20px;"></i> 
                        <div>
                            <p style="font-weight: bold; margin-bottom: 5px; margin-top: 0;"><%= vehicule.getImmat() %></p>
                        </div>
                        <div class="actions" style="margin-left: auto;">
                            <a href="../ServletVehicule/consulter?idVehicule=<%= vehicule.getId() %>"><button>Consulter</button></a>
                        </div>
                    </div>
                <% } %>
            </div>
            <br>
        </div>
    </div>
   
</main>