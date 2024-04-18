<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Caserne"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Liste des casernes</title>
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
        <h1>Liste des casernes du Calvados</h1>

    </div>
    <div class="page-content">
        <div class="record-header">
                <div class="browse"> </div>
                <div class="add">
                    <button><a href="../ServletCaserne/ajouter"> Ajouter une caserne</a></button>
                </div>
            </div> 
        <div class="grade-container">
            <%
            ArrayList<Caserne> lesCasernes = (ArrayList)request.getAttribute("pLesCasernes");
            int count = 0;
            for (Caserne c : lesCasernes) {
                count++;
        %>
                <div class="grade-card">
                    <h2> Nom : <%= c.getNom() %></h2>
                    <br>
                    <p><strong>Adresse :</strong> <%= c.getRue() %></p> 
                    <br>
                    <p><strong>Code postal :</strong> <%= c.getCopos() %></p>
		    <br>
                    <p><strong>Ville : </strong> <%= c.getVille() %></p>
		    <br>
                    <a href="../ServletCaserne/consulter?idCaserne=<%= c.getId() %>"><button class="consult-button">Consulter</button></a>
                </div>
            <% } %>
        </div>
    </div>
</body>
</html>
