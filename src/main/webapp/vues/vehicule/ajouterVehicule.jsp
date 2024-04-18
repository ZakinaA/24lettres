<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Vehicule"%>
<%@page import="model.TypeVehicule"%>
<%@page import="form.FormVehicule"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">

<% FormVehicule form = (FormVehicule)request.getAttribute("form"); %>

<main style="display: flex; justify-content: center; align-items: center; height: 100vh;">
    <div style="width: 80%; max-width: 1200px; background-color: #ffffff; border-radius: 10px; box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1); padding: 20px;">
        <div class="page-header">
            <h1>Ajouter un véhicule</h1>
        </div>
        <br><br><br><br>
        <div class="pompier-container">
	<form class="form-inline" action="ajouter" method="POST">

            <div class="deux">

                <div class="pompierInfo">
                    <i class="zmdi zmdi-car zmdi-hc-5x" style="font-size: 200px; margin-right: 20px;"></i>
                </div><br><br><br><br>
                <div class="pompierInfo">
                    <strong> <label for="immat">Immatriculation : </label></strong>
                    <div class="spanConsulter"><input id="immat" type="text" name="immat"  size="30" maxlength="30">
</div>
                </div>
                <div class="pompierInfo">
                    <strong><label for="type_vehicule">Type de véhicule : </label></strong>
                    <div class="spanConsulter"> <select name="idVehicule">
                <% ArrayList<TypeVehicule> lesTypeVehicules = (ArrayList<TypeVehicule>) request.getAttribute("vLesTypeVehicules");
                    if (lesTypeVehicules != null) {
                        for (int i = 0; i < lesTypeVehicules.size(); i++) {
                            TypeVehicule t = lesTypeVehicules.get(i);
                   %>
                <option value='<%= t.getId() %>'><%= t.getNom() %></option>
                <% } }%>
        </select> </div>
                </div>


            </div>
            <div class="un">
                <div class="pompierInfo">
                    <strong><label for="dateOrigine">Date d'origine : </label></strong>
                    <div class="spanConsulter"><input id="dateOrigine"  type="date"  name="dateOrigine" size="30" maxlength="30"></div>
                </div>

                <div class="pompierInfo">
                    <strong><label for="dateRevision">Date de révision : </label></strong>
                    <div class="spanConsulter"><input id="dateRevision"  type="date"  name="dateRevision" size="30" maxlength="30"></div>
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