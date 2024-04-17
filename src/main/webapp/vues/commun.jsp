<%-- 
    Document   : commun
    Created on : 6 avr. 2024, 00:12:41
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="database.ConnexionBdd" %>

<jsp:include page="/vues/style.jsp" />
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
    <title>SDIS WEB</title>
    <link rel="stylesheet" type="text/css" href="style.css">

    <style>
        .separator {
            height: 1px;
            background-color: white;
            margin: 10px 0;
        }
    </style>
</head>

<body>
    <input type="checkbox" id="menu-toggle">
    <div class="sidebar">
        <div class="side-header">
            <h3><span>SDISWEB</span></h3>
        </div>

        <div class="side-content">
            <div class="profile">
            <div class="profile-img bg-img" style="background-image: url(img/3.jpeg)"></div>
            <% 
                // Récupérer le nom et le prénom du pompier connecté à partir de la session
            
            String email = (String) session.getAttribute("utilisateurConnecte");
            String nomPrenomPompier = ConnexionBdd.recupererNomPrenomPompier(email);
            String gradePompier = ConnexionBdd.recupererGradePompier(email);
            %>
    <h4><%= nomPrenomPompier %></h4>
    <small><%= gradePompier %></small>
</div>


            <div class="side-menu">
                <ul><div class="separator"></div>
                    <li>
                        <a href="../ServletIntervention/lister">
                            <span class="las la-shopping-cart"></span>
                            <small>&nbsp;Accueil&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
                        </a>
                    </li>
                    <div class="separator"></div>
                    <li>
                        <a href="../ServletPompier/lister">
                            <span class="las la-home"></span>
                            <small>&nbsp;Pompiers&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
                        </a>
                    </li>
                    <div class="separator"></div>
                    <li>
                        <a href="../ServletCaserne/lister">
                            <span class="las la-user-alt"></span>
                            <small>Casernes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
                        </a>
                    </li>
                    <div class="separator"></div>
                    <li>
                        <a href="../ServletFonction/lister">
                            <span class="las la-envelope"></span>
                            <small>Fonctions&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
                        </a>
                    </li>
                    <div class="separator"></div>
                    <li>
                        <a href="../ServletVehicule/lister">
                            <span class="las la-clipboard-list"></span>
                            <small>Véhicules&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
                        </a>
                    </li>
                    <div class="separator"></div>
                    <li>
                        <a href="../ServletGrade/lister">
                            <span class="las la-shopping-cart"></span>
                            <small>Grades&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
                        </a>
                    </li>
                    <div class="separator"></div>
                    <li>
                        <a href="../ServletIntervention/lister">
                            <span class="las la-shopping-cart"></span>
                            <small>Interventions&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
                        </a>
                    </li>
                    <div class="separator"></div>
                    <li>
                        <a href="../ServletSituation/lister">
                            <span class="las la-shopping-cart"></span>
                            <small>Situations&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</small>
                        </a>
                    </li>
                    <div class="separator"></div>
                </ul>
            </div>
        </div>
    </div>

    <div class="main-content">

        <header>
            <div class="header-content">
                <label for="menu-toggle">
                    <span class="las la-bars"></span>
                </label>

                <div class="header-menu">

                    <!-- authentification <div class="user">
                        <div class="bg-img" style="background-image: url(img/1.jpeg)"></div>

                        <span class="las la-power-off"></span>
                        <span>Logout</span>
                    </div>-->
                </div>
            </div>
        </header>


</body>

</html>
