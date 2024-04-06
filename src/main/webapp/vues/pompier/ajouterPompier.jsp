<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pompier"%>
<%@page import="model.Caserne"%>
<%@page import="form.FormPompier"%>
<%@page import="model.Grade"%>
<%@page import="model.Fonction"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<% FormPompier form = (FormPompier)request.getAttribute("form"); %>
        <main>
            <div class="page-header">
                <h1>Ajouter un pompier : </h1>
            </div>
            <br><br><br><br>
            
            <div class="pompier">
             <div class="un">

             <form class="form-inline" action="ajouter" method="POST">
                <label for="nom">Nom : </label><br>
                <input id="nom" type="text" name="nom"  size="30" maxlength="30">
                </br> </br>
                
                <label for="sexe">Sexe : </label><br>
                <input id="sexe"  type="text"  name="sexe" size="30" maxlength="30">      
                </br> </br>
                
                <label for="telephone">Téléphone : </label><br>
                <input id="telephone"  type="text"  name="telephone" size="30" maxlength="30">      
                </br> </br>
                
                 <%-- Champ Liste des casernes --%>
                <label for="caserne">Caserne : </label><br>
                <select name="idCaserne">
                    <%
                        ArrayList<Caserne> lesCasernes= (ArrayList)request.getAttribute("pLesCasernes");
                        for (int i=0; i<lesCasernes.size();i++){
                            Caserne c = lesCasernes.get(i);
                            out.println("<option value='" + c.getId()+"'>" + c.getNom()+"</option>" );
                        }
                    %>
                </select>
             </div>
                <div class="deux">
                </br>   </br>
                
                <label for="dateNaissance">Date de naissance : </label><br>
                <input id="dateNaissance"  type="date"  name="dateNaissance" size="30" maxlength="30">      
                </br> </br>
                
                <label for="prenom">Prénom : </label><br>
                <input id="prenom"  type="text"  name="prenom" size="30" maxlength="30">      
                </br> </br>
                 
                <%-- Champ Liste des grades --%>
                <label for="grade">Grade : </label><br>
        <select name="idGrade"> 
            <%
                ArrayList<Grade> lesGrades = (ArrayList)request.getAttribute("pLesGrades");
                for (int i = 0; i < lesGrades.size(); i++){
                    Grade g = lesGrades.get(i);
                    out.println("<option value='" + g.getId() + "'>" + g.getLibelle() + "</option>");
                }
                %>
        </select>
                </br></br>
                
                <label for="numBip">Numéro Bip  : </label><br>
                <input id="numBip"  type="text"  name="numBip" size="30" maxlength="30">      
                </br> </br>
                        
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
    </div>
   </div>
        </main>

    </div>
                            
