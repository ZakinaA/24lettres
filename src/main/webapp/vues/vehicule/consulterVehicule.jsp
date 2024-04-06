<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Intervention"%>
<%@page import="model.Vehicule"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
        <main>
            <div class="page-header">
        <% Vehicule n = (Vehicule)request.getAttribute("vNom"); %>
        <% if (n != null) { %>
        <h1>Les interventions du véhicule <% out.println(n.getImmat()); %> sont : </h1>
        <% } else { %>
        <h1>Aucun véhicule n'a été trouvée.</h1>
        <% } %>
            </div>
            <br>
            <br> 
            <br>
            <br>
            <div>
                        <table width="100%">
                            <thead>
                                <tr>
                                    <th><span class="las la-sort"></span> ID :</th>
                                    <th><span class="las la-sort"></span> Lieu :</th>
                                    <th><span class="las la-sort"></span> Date : </th>
                                    <th><span class="las la-sort"></span>  </th>
                                    <th><span class="las la-sort"></span>  </th>
                                    <th><span class="las la-sort"></span>  </th>
                                    <th><span class="las la-sort"></span>  </th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (Intervention i : (ArrayList<Intervention>) request.getAttribute("lesInterventions"))  { %>
                                <tr>
                                    <td><%= i.getId() %></td>
                                    <td><%= i.getLieu() %></td>
                                    <td><%= i.getDate()%></td>
                                    <td>
                                        
                                    </td>
                                </tr>
                                <% } %>
                            </tbody>
                        </table>
                    </div>

        </main>

    </div>
                            