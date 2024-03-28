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
        <h1>Lister les fonctions</h1>
        <%
                ArrayList<Fonction> lesFonction = (ArrayList)request.getAttribute("fLesFonctions");
            %>
            <table>  
            <thead>
                <tr>             
                    <th>id</th>
                    <th>libelle</th>                
                </tr>
            </thead>
            <tbody>
                <tr>
                    <%
                        for (Pompier p : lesPompier)
                        {              
                            out.println("<tr><td>");
                            out.println(p.getNom());
                            out.println("</a></td>");

                            out.println("<td><a href ='../ServletPompier/consulter?idFonction="+ p.getId()+ "'>");
                            out.println(p.getPrenom());
                            out.println("</td>");;
                               
                        }
                    %>
                </tr>
            </tbody>
        </table>
    </body>
</html>
