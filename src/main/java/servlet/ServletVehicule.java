/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import database.DaoTypeVehicule;
import database.DaoVehicule;
import form.FormVehicule;
import form.FormVehicule;
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
import model.TypeVehicule;
import model.Vehicule;

/**
 *
 * @author zakina
 */
public class ServletVehicule extends HttpServlet {

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
            out.println("<title>Servlet ServletVehicule</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletVehicule at " + request.getContextPath() + "</h1>");
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
       
        // Récup et affichage les eleves 
        if(url.equals("/sdisweb/ServletVehicule/lister"))
        {              
            ArrayList<Vehicule> lesVehicules = DaoVehicule.getLesVehicules(cnx);
            request.setAttribute("vLesVehicules", lesVehicules);
           
            ArrayList<TypeVehicule> lesTypesVehicules = DaoTypeVehicule.getLesTypeVehicules(cnx);
            request.setAttribute("lesTypesVehicules", lesTypesVehicules);


       //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
            getServletContext().getRequestDispatcher("/vues/vehicule/listerVehicule.jsp").forward(request, response);
        }
        
        
    if (url.equals("/sdisweb/ServletVehicule/consulter")) {
    int idVehicule = Integer.parseInt((String) request.getParameter("idVehicule"));
    Vehicule vehicule = DaoVehicule.getVehiculeById(cnx, idVehicule);
    
    ArrayList<Intervention> listeDesInterventions = DaoVehicule.getLesInterventionsByVehicule(cnx, idVehicule);
    
    Vehicule nomVehicule = DaoVehicule.getNomVehiculeById(cnx, idVehicule);
    request.setAttribute("vVehicule", vehicule);
    
    request.setAttribute("lesInterventions", listeDesInterventions);
    
    request.setAttribute("vNom", nomVehicule);
    getServletContext().getRequestDispatcher("/vues/vehicule/consulterVehicule.jsp").forward(request, response);

          
           
        }
        
    if(url.equals("/sdisweb/ServletVehicule/ajouter")) {
            
    ArrayList<TypeVehicule> lesTypesVehicules = DaoTypeVehicule.getLesTypeVehicules(cnx);
    request.setAttribute("vLesTypeVehicules", lesTypesVehicules);

    
            this.getServletContext().getRequestDispatcher("/vues/vehicule/ajouterVehicule.jsp").forward(request, response);
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
        
        FormVehicule form = new FormVehicule();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Vehicule v = form.ajouterVehicule(request);
        
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "vVehicule", v );
        
        System.out.println("111111111111111");
		
        if (form.getErreurs().isEmpty()){
            Vehicule vehiculeInsere =  DaoVehicule.addVehicule(cnx, v);
            if (vehiculeInsere != null ){
                request.setAttribute( "vVehicule", vehiculeInsere );
                System.out.println("aaaaaaaaaaaaaaaaaa");
                
                this.getServletContext().getRequestDispatcher("/vues/vehicule/consulterVehicule.jsp" ).forward( request, response );
                System.out.println("zzzzzzzzzzzz");
            }
            else 
            {
                // Cas oùl'insertion en bdd a échoué
                //renvoyer vers une page d'erreur 
                 System.out.println("222222222222222222222");
            }
           
        }
        else
    { 
        // il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs
        ArrayList<TypeVehicule> lesTypesVehicules = DaoTypeVehicule.getLesTypeVehicules(cnx);
        request.setAttribute("tLesTypeVehicules", lesTypesVehicules);
        System.out.println("23333333333333333333333");

        this.getServletContext().getRequestDispatcher("/vues/vehicule/ajouterVehicule.jsp" ).forward( request, response );
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
