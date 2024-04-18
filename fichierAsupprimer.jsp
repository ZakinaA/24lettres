<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Intervention"%>
<%@page import="model.Pompier"%>
<%@page import="model.Vehicule"%>
<jsp:include page="/vues/commun.jsp" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
<main>
    <div class="page-header">
                <h1>L'intervention est composée des véhicules et pompiers suivant :</h1>
        <small>Calvados / Caen</small>
    </div>
    <div class="page-content">
        <div class="records table-responsive">
            <div class="record-header">
                <div class="browse"> </div>
                <div class="add">
                    <button><a href="../ServletFonction/ajouter"> Ajouter une fonction</a></button>
                </div>
            </div> 
            <div class="casernes-container" style="display: flex; flex-wrap: wrap;">
                <% for (Pompier p : (ArrayList<Pompier>) request.getAttribute("lesPompiers")) { %>
                    <div class="caserne" style="width: 30%; margin: 5px; padding: 20px; background-color: #f0f0f0; border-radius: 10px; box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1); display: flex; align-items: center;">
                        <i class="zmdi zmdi-account-circle zmdi-hc-5x" style="font-size: 48px; margin-right: 20px;"></i>
                        <div>
                            <p style="font-weight: bold; margin-bottom: 5px; margin-top: 0;"><%= p.getNom() %> <%= p.getPrenom() %></p>
                        </div>
                        <div class="actions" style="margin-left: auto;">
                            <a href="../ServletPompier/consulter?idPompier=<%= p.getId() %>"><button>Consulter</button></a>
                        </div>
                    </div>
                <% } %>
                <% for (Vehicule vehicule : (ArrayList<Vehicule>) request.getAttribute("lesVehicules")) { %>
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