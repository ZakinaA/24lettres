/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import database.DaoIntervention;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;
import model.Intervention;
import model.Pompier;
import model.Vehicule;

/**
 *
 * @author zakina
 */
public class ServletIntervention extends HttpServlet {

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
            out.println("<title>Servlet ServletIntervention</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletIntervention at " + request.getContextPath() + "</h1>");
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
        
        String url = request.getRequestURI().toLowerCase(); 
     
        String[] args = url.split("/");  
       
        // Récup et affichage les eleves 
        if(args[3].equals("lister"))
        {              
            ArrayList<Intervention> lesInterventions = DaoIntervention.getLesInterventions(cnx);
            request.setAttribute("iLesInterventions", lesInterventions);
            //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
           getServletContext().getRequestDispatcher("/vues/intervention/listerIntervention.jsp").forward(request, response);
        }
        
         // Récup et affichage des clients interessés par une certaine catégorie de ventes
        else if(args[3].equals("consulter"))
        {  
            // tout paramètre récupéré de la request Http est de type String
            // Il est donc nécessaire de caster le paramètre idPompier en int
            int idIntervention = Integer.parseInt((String)request.getParameter("idIntervention"));
            System.out.println( "pompier à afficher = " + idIntervention);
            ArrayList<Pompier> lesPompiers = DaoIntervention.getLesPompiersByIntervention(cnx, idIntervention);
            request.setAttribute("lesPompiers", lesPompiers);
            
            System.out.println( "véhicule à afficher = " + idIntervention);
            ArrayList<Vehicule> lesVehicules = DaoIntervention.getLesVehiculesByIntervention(cnx, idIntervention);
            request.setAttribute("lesVehicules", lesVehicules);
            
            Intervention n = DaoIntervention.getNomInterventionById(cnx, idIntervention);
            request.setAttribute("iNom", n);
            
            getServletContext().getRequestDispatcher("/vues/intervention/consulterIntervention.jsp").forward(request, response);       
           
        }
        
        else if(args[3].equals("ajouter"))
        {                   
            ArrayList<Intervention> lesInterventions = DaoIntervention.getLesInterventions(cnx);
            request.setAttribute("iLesInterventions", lesInterventions);
            this.getServletContext().getRequestDispatcher("/vues/intervention/ajouterIntervention.jsp" ).forward( request, response );
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
