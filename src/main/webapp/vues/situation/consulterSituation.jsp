<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Intervention"%>
<%@page import="model.Situation"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Liste des interventions</title>
    <style>
        .grade-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin-top: 20px;
        }
        .grade-card {
            width: calc(25% - 20px);
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            margin-bottom: 20px;
            box-sizing: border-box;
            position: relative; 
        }
        .consult-button {
            position: absolute;
            bottom: 10px;
            right: 10px;
            background-color: #DA001B;
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="page-header">
        </br> 
        </br> 
        </br> 
        </br> 
        <% Situation n = (Situation)request.getAttribute("sNom"); %>
        <% if (n != null) { %>
        <h1>Les interventions de la situation <% out.println(n.getLibelle()); %> sont : </h1>
        <% } else { %>
        <h1>Aucune situation n'a été trouvée.</h1>
        <% } %>
    </div>
    <div class="page-content">
        <div class="grade-container">
            <% ArrayList<Intervention> lesInterventions = (ArrayList<Intervention>)request.getAttribute("iLesInterventions"); %>
            <% for (Intervention i : (ArrayList<Intervention>) request.getAttribute("lesInterventions"))  { %>
                <div class="grade-card">
                    <h2><%= i.getLieu() %></h2>
                    <br>
                    <p><strong>Date :</strong> <%= i.getDate() %></p> 
                    <br>
                    <p><strong>Heure d'appel :</strong> <%= i.getHeureAppel() %></p> 
                    <br>
                    <p><strong>Heure de révision :</strong> <%= i.getHeureArrivee() %></p>
		    <br>
                    <p><strong>Durée </strong> <%= i.getDuree() %></p>
		    
                    <a href="../ServletIntervention/consulter?idIntervention=<%= i.getId() %>"><button class="consult-button">Consulter</button></a>
                </div>
            <% } %>
        </div>
    </div>
</body>
</html>
