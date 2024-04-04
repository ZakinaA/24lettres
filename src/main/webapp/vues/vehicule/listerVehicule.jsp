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
        <h1>Lister les véhicules</h1>
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
    </body>
</html>