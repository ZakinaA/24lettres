<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Intervention"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SDIS WEB</title>
</head>
<body>
    <div class="page-header">
        <h1>Liste des interventions du Calvados</h1>
        <small>Calvados / Caen</small>
    </div>
    <div class="page-content">
        <div class="records table-responsive">
            <div class="record-header">
                <div class="browse"></div>
                <div class="add">
                    <button><a href="../ServletPompier/ajouter">Ajouter un pompier</a></button>
                </div>
            </div> 
            <div>
                <table width="100%">
                    <thead>
                        <tr>
                            <th><span class="las la-sort"></span> Id</th>
                            <th><span class="las la-sort"></span> Lieu</th>
                            <th><span class="las la-sort"></span> Heure d'appel</th>
                            <th><span class="las la-sort"></span> Heure d'arrivée</th>
                            <th><span class="las la-sort"></span> Durée</th>
                            <th><span class="las la-sort"></span> Consulter les pompiers</th>
                            <th><span class="las la-sort"></span> Consulter les véhicules</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% ArrayList<Intervention> lesInterventions = (ArrayList<Intervention>)request.getAttribute("iLesInterventions");
                        for (Intervention i : lesInterventions) { %>
                            <tr>
                                <td><%= i.getId() %></td>
                                <td><%= i.getLieu() %></td>
                                <td><%= i.getHeureAppel() %></td>
                                <td><%= i.getHeureArrivee() %></td>
                                <td><%= i.getDuree() %></td>
                                <td><a href="../ServletIntervention/consulter?idIntervention=<%= i.getId() %>">Consulter les pompiers</a></td>
                                <td><a href="../ServletVehicule/consulter?idVehicule=<%= i.getId() %>">Consulter les véhicules</a></td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
