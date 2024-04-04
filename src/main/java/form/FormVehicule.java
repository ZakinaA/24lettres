/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import model.TypeVehicule;
import model.Vehicule;

/**
 *
 * @author zakina
 */
public class FormVehicule {
    
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
    private void validationImmat( String immat ) throws Exception {
        if ( immat != null && immat.length() < 3 ) {
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
    
    
    public Vehicule ajouterVehicule( HttpServletRequest request ) {
      
        Vehicule v  = new Vehicule();
         
        String immat = getDataForm( request, "immat" );
        LocalDate dateOrigine = LocalDate.parse(getDataForm(request, "dateOrigine"));
        LocalDate dateRevision = LocalDate.parse(getDataForm(request, "dateRevision"));
        int idVehicule = Integer.parseInt((String)getDataForm( request, "idVehicule" ));
       
      
        try {
             validationImmat( immat );
        } catch ( Exception e ) {
            setErreur( "immat", e.getMessage() );
        }
        v.setImmat(immat);

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
         
      
        v.setDateOrigine(dateOrigine);
        v.setDateRevision(dateRevision);
        v.setTypeVehicule(new TypeVehicule(idVehicule));
        
        return v ;
    }
    
    
}
