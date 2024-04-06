<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Vehicule"%>
<%@page import="model.TypeVehicule"%>
<%@page import="form.FormVehicule"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/vues/commun.jsp" />
<% ArrayList<Vehicule> lesVehicules = (ArrayList)request.getAttribute("vLesVehicules"); %>
        <main>

            <div class="page-header">
                <h1>Liste des véhicules :</h1>
                <small>Calvados / Caen</small>
            </div>

            <div class="page-content">

                <div class="records table-responsive">

                    <div class="record-header">
                        <div class="browse"> </div>
    
                    <div class="add"> 
                        
                        <button><a href="../ServletVehicule/ajouter"> Ajouter un véhicule</a></button>
    </div>
</div> 
                
                    <div>
                        <table width="100%">
                            <thead>
                                <tr>
                                    <th><span class="las la-sort"></span> Immatriculation</th>
                                    <th><span class="las la-sort"></span> Date d'origine</th>
                                    <th><span class="las la-sort"></span> Date de révision</th>
                                    <th><span class="las la-sort"></span> Type de véhicule</th>
                                    <th><span class="las la-sort"></span> </th>
                                    <th><span class="las la-sort"></span> Consulter</th>
                                    <th><span class="las la-sort"></span> Modifier</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (Vehicule v : lesVehicules)
 { %>
                                <tr>
                                    <td><%= v.getImmat() %></td>
                                    <td><%= v.getDateOrigine() %></td>
                                    <td><%= v.getDateRevision() %></td>
                                    <td><%= v.getTypeVehicule().getNom() %></td>
                                    <td>
                                        <div class="actions">
                                            <span class="lab la-telegram-plane"><%out.println("<td><a href ='../ServletVehicule/consulter?idVehicule="+ v.getId()+ "'> Consulter </a>");%></span>
                                            <span class="las la-eye"><%out.println("<td><a href ='../ServletVehicule/modifier'> Modifier </a>");%></span>
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

                            