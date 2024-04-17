<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Situation"%>
<%@page import="model.Intervention"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Liste des grades</title>
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
        <h1>Liste des situations</h1>
    </div>
    <div class="page-content">
        <div class="record-header">
                <div class="browse"> </div>
                <div class="add">
                    <button><a href="../ServletSituation/ajouter"> Ajouter une situation</a></button>
                </div>
            </div> 
        <div class="grade-container">
            <% ArrayList<Situation> lesSituations = (ArrayList)request.getAttribute("pLesSituations"); %>
            <% for (Situation s : lesSituations) { %>
                <div class="grade-card">
                    <h2><%= s.getLibelle() %></h2>
                    <br>
                    <p><strong>Description :</strong> <em><%= s.getDescription() %></em></p> 
                    <br>
                    <a href="../ServletSituation/consulter?idSituation=<%= s.getId() %>"><button class="consult-button">Consulter</button></a>
                </div>
            <% } %>
        </div>
    </div>
</body>
</html>
