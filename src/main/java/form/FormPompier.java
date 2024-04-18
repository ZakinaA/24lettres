/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import model.Caserne;
import model.Grade;
import model.Pompier;

/**
 *
 * @author zakina
 */
public class FormPompier {
    
     private String resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(Map<String, String> erreurs) {
        this.erreurs = erreurs;
    }
    
    //méthode de validation du champ de saisie nom
    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }

    private void setErreur( String champ, String message ) {
    erreurs.put(champ, message );
    }    
    
    private static String getDataForm( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }   
    }
    
    
    public Pompier ajouterPompier( HttpServletRequest request ) {
      
        Pompier p  = new Pompier();
         
        String nom = getDataForm( request, "nom" );
        String sexe = getDataForm( request, "sexe");
        String telephone = getDataForm( request, "telephone");
        int idCaserne = Integer.parseInt(getDataForm(request, "idCaserne"));
        String dateNaissanceString = getDataForm(request, "dateNaissance");
        LocalDate dateNaiss = LocalDate.parse(dateNaissanceString);
        String prenom = getDataForm( request, "prenom");
        int idGrade = Integer.parseInt(getDataForm(request, "idGrade"));
        String numeroBip = getDataForm( request, "numBip");
        

      
       
         p.setNom(nom);

        
         
      
        p.setSexe(sexe);
        p.setTelephone(telephone);
        p.setUneCaserne(new Caserne(idCaserne));
        p.setDateNaissance(dateNaiss);
        p.setPrenom(prenom);
        p.setUnGrade(new Grade(idGrade));
        p.setBip(numeroBip);
        
        return p ;
    }
    
    
}
