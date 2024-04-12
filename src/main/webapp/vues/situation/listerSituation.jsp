<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Situation"%>
<%@page import="model.Intervention"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<% ArrayList<Situation> lesSituations = (ArrayList)request.getAttribute("pLesSituations"); %>
        <main>

            <div class="page-header">
                <h1>Liste des situations :</h1>
                <small>Calvados / Caen</small>
            </div>

            <div class="page-content">

                <div class="records table-responsive">

                    <div class="record-header">
                        <div class="browse"> </div>
    
                    <div class="add"> <!-- Échange de l'ordre des éléments -->
                        
                        <button><a href="../ServletSituation/ajouter"> Ajouter une situation</a></button>
    </div>
</div> 
                
                    <div>
                        <table width="100%">
                            <thead>
                                <tr>
                                    <th><span class="las la-sort"></span> Id</th>
                                    <th><span class="las la-sort"></span> Libelle</th>
                                    <th><span class="las la-sort"></span> </th>
                                    <th><span class="las la-sort"></span> </th>
                                    <th><span class="las la-sort"></span> Consulter</th>
                                    <th><span class="las la-sort"></span> Modifier</th>
                                    <th><span class="las la-sort"></span> </th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (Situation s : lesSituations) { %>
                                <tr>
                                    <td><%= s.getId() %></td>
                                    <td><%= s.getLibelle() %></td>
                                    <td></td>
                                    <td></td>
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

                            