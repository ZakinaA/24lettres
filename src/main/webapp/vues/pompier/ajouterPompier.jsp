<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pompier"%>
<%@page import="model.Fonction"%>
<%@page import="model.Caserne"%>
<%@page import="model.Grade"%>
<%@page import="form.FormPompier"%>
<%@page import="model.Intervention"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">
<% FormPompier form = (FormPompier)request.getAttribute("form"); %>

<main style="display: flex; justify-content: center; align-items: center; height: 100vh;">
    <div style="width: 80%; max-width: 1200px; background-color: #ffffff; border-radius: 10px; box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1); padding: 20px;">
        <div class="page-header">
            <h1>Ajouter un pompier</h1>
        </div>
        <br><br><br><br>
        <div class="pompier-container">
	<form class="form-inline" action="ajouter" method="POST">

            <div class="deux">

                <div class="pompierInfo">
                    <i class="zmdi zmdi-account-circle zmdi-hc-5x" style="font-size: 200px; margin-right: 20px;"></i>
                </div><br><br><br><br>
                <div class="pompierInfo">
                    <strong> <label for="nom">Nom : </label></strong>
                    <div class="spanConsulter"><input id="nom" type="text" name="nom"  size="30" maxlength="30">
</div>
                </div>
                <div class="pompierInfo">
                    <strong><label for="sexe">Sexe : </label></strong>
                    <div class="spanConsulter"><input id="sexe"  type="text"  name="sexe" size="30" maxlength="30"> </div>
                </div>
                <div class="pompierInfo">
                    <strong><label for="telephone">Téléphone : </label></strong>
                    <div class="spanConsulter"><input id="telephone"  type="text"  name="telephone" size="30" maxlength="30"></div>
                </div>
                <div class="pompierInfo">
                    <strong><label for="caserne">Caserne : </label></strong>
                    <div class="spanConsulter"><select name="idCaserne">
                    <%
                        ArrayList<Caserne> lesCasernes= (ArrayList)request.getAttribute("pLesCasernes");
                        for (int i=0; i<lesCasernes.size();i++){
                            Caserne c = lesCasernes.get(i);
                            out.println("<option value='" + c.getId()+"'>" + c.getNom()+"</option>" );
                        }
                    %>
                </select> </div>
                </div>

                <div class="pompierInfo">
                    <strong> <label for="dateNaissance">Date de naissance : </label></strong>
                    <div class="spanConsulter"><input id="dateNaissance"  type="date"  name="dateNaissance" size="30" maxlength="30"></div> 
                </div>

            </div>
            <div class="un">
                <div class="pompierInfo">
                    <strong><label for="prenom">Prénom : </label></strong>
                    <div class="spanConsulter"><input id="prenom"  type="text"  name="prenom" size="30" maxlength="30"></div>
                </div>
                <div class="pompierInfo">
                    <strong><label for="grade">Grade : </label></strong>
                    <div class="spanConsulter"> <select name="idGrade"> 
            <%
                ArrayList<Grade> lesGrades = (ArrayList)request.getAttribute("pLesGrades");
                for (int i = 0; i < lesGrades.size(); i++){
                    Grade g = lesGrades.get(i);
                    out.println("<option value='" + g.getId() + "'>" + g.getLibelle() + "</option>");
                }
                %>
        </select>
</div>
                </div>
                <div class="pompierInfo">
                    <strong><label for="numBip">Numéro Bip  : </label></strong>
                    <div class="spanConsulter"><input id="numBip"  type="text"  name="numBip" size="30" maxlength="30"></div>
                </div><br>
                
            </div>
		<input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
        </div>
    </div>
</main>

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