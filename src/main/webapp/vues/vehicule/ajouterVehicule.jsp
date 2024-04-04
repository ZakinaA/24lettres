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
                <label for="immat">Immatriculation : </label>
                <input id="immat" type="text" name="immat"  size="30" maxlength="30">
                </br>

                <label for="dateOrigine">Date d'origine : </label>
                <input id="dateOrigine"  type="date"  name="dateOrigine" size="30" maxlength="30">      
                </br>
                
                <label for="dateRevision">Date de révision : </label>
                <input id="dateRevision"  type="date"  name="dateRevision" size="30" maxlength="30">      
                </br>
                
                <label for="type_vehicule">Type de véhicule : </label>
                <select name="idVehicule">
                <% ArrayList<TypeVehicule> lesTypeVehicules = (ArrayList<TypeVehicule>) request.getAttribute("vLesTypeVehicules");
                    if (lesTypeVehicules != null) {
                        for (int i = 0; i < lesTypeVehicules.size(); i++) {
                            TypeVehicule t = lesTypeVehicules.get(i);
                   %>
                <option value='<%= t.getId() %>'><%= t.getNom() %></option>
                <% } }%>
        </select>
            <input type="submit" name="valider" id="valider" value="Valider"/>
    </form>




    </body>
</html>