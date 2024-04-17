<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Grade"%>
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
        <h1>Liste des grades</h1>
    </div>
    <div class="page-content">
        <div class="record-header">
                <div class="browse"> </div>
                <div class="add">
                    <button><a href="../ServletGrade/ajouter"> Ajouter un grade</a></button>
                </div>
            </div> 
        <div class="grade-container">
            <% ArrayList<Grade> lesGrades = (ArrayList<Grade>) request.getAttribute("pLesGrades"); %>
            <% for (Grade g : lesGrades) { %>
                <div class="grade-card">
                    <h2><%= g.getLibelle() %></h2>
                    <br>
                    <p><strong>Description :</strong> <em><%= g.getDescription() %></em></p> 
                    <br>
                    <p><strong>Surgrade :</strong> <%= g.getSurgrade().getLibelle() %></p>
                    <br>
                    <a href="../ServletGrade/consulter?idGrade=<%= g.getId() %>"><button class="consult-button">Consulter</button></a>
                </div>
            <% } %>
        </div>
    </div>
</body>
</html>
