/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import database.DaoFonction;
import form.FormFonction;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;
import model.Fonction;
import model.Pompier;

/**
 *
 * @author zakina
 */
public class ServletFonction extends HttpServlet {

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
            out.println("<title>Servlet ServletFonction</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletFonction at " + request.getContextPath() + "</h1>");
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
            ArrayList<Fonction> lesFonctions = DaoFonction.getLesFonctions(cnx);
            request.setAttribute("pLesFonctions", lesFonctions);
            //System.out.println("lister eleves - nombres d'élèves récupérés" + lesEleves.size() );
           getServletContext().getRequestDispatcher("/vues/fonction/listerFonction.jsp").forward(request, response);
        }
        
        // Récup et affichage des clients interessés par une certaine catégorie de ventes
        else if(args[3].equals("consulter"))
        {  
            // tout paramètre récupéré de la request Http est de type String
            // Il est donc nécessaire de caster le paramètre idPompier en int
            int idFonction = Integer.parseInt((String)request.getParameter("idFonction"));
            System.out.println( "pompier à afficher = " + idFonction);
            ArrayList<Pompier> lesPompiers = DaoFonction.getLesPompiersByFonction(cnx, idFonction);
            request.setAttribute("lesPompiers", lesPompiers);
            
            Fonction n = DaoFonction.getNomFonctionById(cnx, idFonction);
            request.setAttribute("fNom", n);
            
            getServletContext().getRequestDispatcher("/vues/fonction/consulterFonction.jsp").forward(request, response);       
           
           
        }
        
        else if(url.equals("ajouter"))
        {                   
            ArrayList<Fonction> lesFonctions = DaoFonction.getLesFonctions(cnx);
            request.setAttribute("fLesFonctions", lesFonctions);
            this.getServletContext().getRequestDispatcher("/vues/fonction/ajouterFonction.jsp" ).forward( request, response );
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
        
         FormFonction form = new FormFonction();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Fonction f = form.ajouterFonction(request);
        
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "fFonction", f );
		
        if (form.getErreurs().isEmpty()){
            Fonction fonctionInsere =  DaoFonction.addFonction(cnx, f);
            if (fonctionInsere != null ){
                request.setAttribute( "fFonction", fonctionInsere );
                this.getServletContext().getRequestDispatcher("/vues/fonction/consulterFonction.jsp" ).forward( request, response );
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
