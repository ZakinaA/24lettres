<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pompier"%>
<%@page import="model.Caserne"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<% ArrayList<Pompier> lesPompiers = (ArrayList)request.getAttribute("pLesPompiers"); %>
        <main>

            <div class="page-header">
                <h1>Dashboard</h1>
                <small>Home / Dashboard</small>
            </div>

            <div class="page-content">

                <div class="records table-responsive">

                    <div>
                        <table width="100%">
                            <thead>
                                <tr>
                                    <th><span class="las la-sort"></span> Nom</th>
                                    <th><span class="las la-sort"></span> Prénom</th>
                                    <th><span class="las la-sort"></span> Caserne</th>
                                    <th><span class="las la-sort"></span> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (Pompier p : lesPompiers) { %>
                                <tr>
                                    <td><%= p.getNom() %></td>
                                    <td><%= p.getPrenom() %></td>
                                    <td><%= p.getUneCaserne().getNom() %></td>
                                    
                                    <td>
                                       <%out.println("<td><a href ='../ServletPompier/consulter?idPompier="+ p.getId()+ "'> Consulter </a>");%>
                                    </td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
                    </div>

                </div>

            </div>

        </main>

    </div>
                            