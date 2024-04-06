<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pompier"%>
<%@page import="model.Caserne"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<% ArrayList<Pompier> lesPompiers = (ArrayList)request.getAttribute("pLesPompiers"); %>
        <main>

            <div class="page-header">
                <h1>Liste des pompiers :</h1>
                <small>Calvados / Caen</small>
            </div>

            <div class="page-content">

                <div class="records table-responsive">

                    <div class="record-header">
                        <div class="browse"> </div>
    
                    <div class="add"> <!-- Échange de l'ordre des éléments -->
                        
                        <button><a href="../ServletPompier/ajouter"> Ajouter un pompier</a></button>
    </div>
</div> 
                
                    <div>
                        <table width="100%">
                            <thead>
                                <tr>
                                    <th><span class="las la-sort"></span> Nom</th>
                                    <th><span class="las la-sort"></span> Prénom</th>
                                    <th><span class="las la-sort"></span> Caserne</th>
                                    <th><span class="las la-sort"></span> </th>
                                    <th><span class="las la-sort"></span> Consulter</th>
                                    <th><span class="las la-sort"></span> Modifier</th>
                                    <th><span class="las la-sort"></span> </th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (Pompier p : lesPompiers) { %>
                                <tr>
                                    <td><%= p.getNom() %></td>
                                    <td><%= p.getPrenom() %></td>
                                    <td><%= p.getUneCaserne().getNom() %></td>
                                    <td>
                                        <div class="actions">
                                            <span class="lab la-telegram-plane"><%out.println("<td><a href ='../ServletPompier/consulter?idPompier="+ p.getId()+ "'> Consulter </a>");%></span>
                                            <span class="las la-eye"><%out.println("<td><a href ='../ServletPompier/modifier'> Modifier </a>");%></span>
                                        </div>
                                    </td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
            </div>

        </main>

                            