<%-- 
    Document   : listerCaserne
    Created on : 28 mars 2024, 10:47:34
    Author     : ts1sio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1>Liste des casernes du Calvados</h1>
        <%
                ArrayList<Pompier> lesPompiers = (ArrayList)request.getAttribute("pLesPompiers");
            %>
            <table>  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>nom</th>                
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Caserne c : lesCasernes)
                        {              
                            out.println("<tr><td>");
                            out.println(p.getId());
                            out.println("</a></td>");

                            out.println("<td><a href ='../ServletCaserne/consulter?idCaserne="+ p.getId()+ "'>");
                            out.println(p.getNom());
                            out.println("</td>");;
                               
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
