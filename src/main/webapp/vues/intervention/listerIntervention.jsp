<%-- 
    Document   : lister_pompiers.jsp
    Created on : 15 mars 2024, 16:50:49
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Intervention"%>
<%@page import="java.util.ArrayList"%>
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
    <body>
        <h1>Liste des interventions du Calvados</h1>
            <%
                ArrayList<Intervention> lesInterventions = (ArrayList)request.getAttribute("iLesInterventions");
            %>
            <table>  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>lieu</th>   
                    <th>heureAppel</th>    
                    <th>heureArrivee</th> 
                    <th>duree</th>               
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Intervention i : lesInterventions)
                        {              
                            out.println("<tr><td>");
                            out.println(i.getId());
                            out.println("</a></td>");

                            out.println("<td><a href ='../ServletIntervention/consulter?idIntervention="+ i.getId()+ "'>");
                            out.println(i.getLieu());
                            out.println("</td>");
                            
                            out.println("<td>");
                            out.println(i.getHeureAppel());
                            out.println("</td>");
                            
                            out.println("<td>");
                            out.println(i.getHeureArrivee());
                            out.println("</td>");
                            
                            out.println("<td>");
                            out.println(i.getDuree());
                            out.println("</td>");
    
    
    
    
    
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
    </body>
</html>
