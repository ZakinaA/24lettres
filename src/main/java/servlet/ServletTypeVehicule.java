/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import database.DaoTypeVehicule;
import form.FormTypeVehicule;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;
import model.TypeVehicule;

/**
 *
 * @author zakina
 */
public class ServletTypeVehicule extends HttpServlet {

     Connection cnx ;
            
    @Override
    public void init()
    {     
        ServletContext servletContext=getServletContext();
        cnx = (Connection)servletContext.getAttribute("connection");     
    }

    
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletTypeVehicule</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletTypeVehicule at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    
    String url = request.getRequestURI();  
    
    // Récup et affichage les types de véhicules 
    if(url.equals("/sdisweb/ServletTypeVehicule/lister"))
    {              
        ArrayList<TypeVehicule> lesTypeVehicules = DaoTypeVehicule.getLesTypeVehicules(cnx);
        if (lesTypeVehicules == null) {
            // Si la liste est nulle, initialiser avec une liste vide
            lesTypeVehicules = new ArrayList<>();
        }
        request.setAttribute("tLesTypeVehicules", lesTypeVehicules);
        
        getServletContext().getRequestDispatcher("/vues/type_vehicule/listerTypeVehicule.jsp").forward(request, response);
    }
    
}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         FormTypeVehicule form = new FormTypeVehicule();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        TypeVehicule t = form.ajouterTypeVehicule(request);
        
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "tTypeVehicule", t );
		
        if (form.getErreurs().isEmpty()){
            TypeVehicule typeVehiculeInsere =  DaoTypeVehicule.addTypeVehicule(cnx, t);
            if (typeVehiculeInsere != null ){
                request.setAttribute( "tTypeVehicule", typeVehiculeInsere );
                this.getServletContext().getRequestDispatcher("/vues/type_vehicule/consulterTypeVehicule.jsp" ).forward( request, response );
            }
            else 
            {
                // Cas oùl'insertion en bdd a échoué
                //renvoyer vers une page d'erreur 
            }
           
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
