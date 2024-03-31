<%-- 
    Document   : listerCaserne
    Created on : 28 mars 2024, 10:47:34
    Author     : ts1sio
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
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>APPLICATION DE GESTION SDIS CALVADOS</title>
    </head>
        <h1>Lister les fonctions</h1>
        <%
                ArrayList<Vehicule> lesVehicules = (ArrayList)request.getAttribute("vLesVehicules");
            %>
            <div class="cadre2">
    <table class="centrer">
    <thead>
        <tr>
            <th>Immatriculation :</th>
            <th>Date d'origine :</th>
            <th>Date de révision :</th>
            <th>Type de véhicule</th>
        </tr>
    </thead>

    <tbody>
                <tr>
                    <%
                        for (Vehicule v : lesVehicules)
                        {              
                            out.println("<tr><td>");
                            out.println(v.getImmat());
                            out.println("</a></td>");
                            
                            out.println("<td>");
                            out.println(v.getDateOrigine());
                            out.println("</td>");
                            
                            out.println("<td>");
                            out.println(v.getDateRevision());
                            out.println("</td>");;
                            
                            out.println("<td>");
                            out.println(v.getTypeVehicule().getNom());
                            out.println("</td>");;
                               
                        }
                    %>
                </tr>
    </tbody>  
    </table>
</div>
<style>
h2{
    color:#333;
    font-size:50px;
    margin-bottom:10px;
}
        
.centrer{
    margin-left:auto;
    margin-right:auto;
}
        
table{
    width:100%;
    border-collapse:collapse;
    margin-top:20px;
}
 
th, td{
    border:1px solid #333;
    padding:8px;
    text-align:center;
}

th{
    font-weight:bold;
}
        
.cadre2{
    background:white; 
    padding:10px;
    margin:2px auto; 
    width:70%;
}
        
.class{
    padding-left:700px;
}
        

</style>
    </body>
</html>