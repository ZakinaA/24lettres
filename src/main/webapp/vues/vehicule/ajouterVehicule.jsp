<%-- 
    Document   : ajouterPompier
    Created on : 18 mars 2024, 13:30:47
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Vehicule"%>
<%@page import="model.TypeVehicule"%>
<%@page import="form.FormVehicule"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDIS WEB</title>
    </head>
    <body>
        <h1>NOUVEAU VEHICULE</h1>
        
            <%
                FormVehicule form = (FormVehicule)request.getAttribute("form");
            %>
        
        <form class="form-inline" action="ajouter" method="POST">
                <label for="nom">NOM : </label>
                <input id="nom" type="text" name="nom"  size="30" maxlength="30">
                </br>
                
                <label for="prenom">PRENOM : </label>
                <input id="prenom"  type="text"  name="prenom" size="30" maxlength="30">      
                 </br>
               
                
                <%-- Champ Liste des caserbes --%>
                <label for="type_vehicule">Type de véhicule : </label>
                <select name="idVehicule">
                    <%
                        ArrayList<TypeVehicule> lesTypeVehicules= (ArrayList)request.getAttribute("vLesTypeVehicules");
                        for (int i=0; i<lesTypeVehicules.size();i++){
                            TypeVehicule t = lesTypeVehicules.get(i);
                            out.println("<option value='" + t.getId()+"'>" + t.getNom()+"</option>" );
                        }
                    %>
                </select>
                </br>            
                               
            <input type="submit" name="valider" id="valider" value="Valider"/>
            </form>
        
        
        
        
    </body>
</html>
