<%-- 
    Document   : commun
    Created on : 6 avr. 2024, 00:12:41
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="/vues/style.jsp" />
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
    <title>SDIS WEB</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
    <input type="checkbox" id="menu-toggle">
    <div class="sidebar">
        <div class="side-header">
            <h3><span>Lettres</span></h3>
        </div>

        <div class="side-content">
            <div class="profile">
                <div class="profile-img bg-img" style="background-image: url(img/3.jpeg)"></div>
                <h4>???? nom + prenom</h4>
                <small>???? role </small>
            </div>

            <div class="side-menu">
                <ul>
                    <li>
                        <a href="../ServletPompier/lister" class="active">
                            <span class="las la-home"></span>
                            <small>Pompier</small>
                        </a>
                    </li>
                    <li>
                        <a href="../ServletCaserne/lister">
                            <span class="las la-user-alt"></span>
                            <small>Caserne</small>
                        </a>
                    </li>
                    <li>
                            <a href="../ServletFonction/lister">
                            <span class="las la-envelope"></span>
                            <small>Fonction</small>
                        </a>
                    </li>
                    <li>
                            <a href="../ServletVehicule/lister">
                            <span class="las la-clipboard-list"></span>
                            <small>Véhicule</small> 
                        </a>
                    </li>
                    <li>
                        <a href="../ServletGrade/lister">
                            <span class="las la-shopping-cart"></span>
                            <small>Grade</small>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <span class="las la-tasks"></span>
                            <small>Tasks</small>
                        </a>
                    </li>
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
            
