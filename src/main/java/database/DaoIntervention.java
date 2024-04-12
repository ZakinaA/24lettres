/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Intervention;
import model.Pompier;

/**
 *
 * @author zakina
 */
public class DaoIntervention {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Intervention> getLesInterventions(Connection cnx){
        
        ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>();
        try{
            requeteSql = cnx.prepareStatement("SELECT intervention.id AS i_id, intervention.lieu AS i_lieu, intervention.date AS i_date, intervention.heureAppel AS i_heureAppel, intervention.heureArrivee AS i_heureArrivee, intervention.duree AS i_duree "
                                            + "FROM intervention");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Intervention i = new Intervention();
                i.setId(resultatRequete.getInt("i_id"));
                i.setLieu(resultatRequete.getString("i_lieu"));
                 
                Date datee = resultatRequete.getDate("i_date");
                i.setDate(datee.toLocalDate());
                    
                i.setHeureAppel(resultatRequete.getString("i_heureAppel"));
                i.setHeureArrivee(resultatRequete.getString("i_heureArrivee"));
                i.setDuree(resultatRequete.getString("i_duree"));
                    
                
                lesInterventions.add(i);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesInterventions a généré une erreur");
        }
        return lesInterventions;
    }
    
    public static Intervention getInterventionById(Connection cnx, int idIntervention){
        
        Intervention i = null ;
        try{
            requeteSql = cnx.prepareStatement("SELECT intervention.id AS i_id, intervention.lieu AS i_lieu, intervention.date AS i_date, intervention.heureAppel AS i_heureAppel, intervention.heureArrivee AS i_heureArrivee, intervention.duree AS i_duree, pompier.id AS p_id, pompier.nom AS p_nom, pompier.prenom AS p_prenom "
                                                + "FROM intervention "
                                                + "INNER JOIN pompier_intervention "
                                                + "ON intervention.id = pompier_intervention.intervention_id "
                                                + "INNER JOIN pompier "
                                                + "ON pompier.id = pompier_intervention.pompier_id "
                                                + "where intervention.id= ? ");
            requeteSql.setInt(1, idIntervention);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                i = new Intervention();
                i.setId(resultatRequete.getInt("i_id"));
                i.setLieu(resultatRequete.getString("i_lieu"));
                 
                Date datee = resultatRequete.getDate("i_date");
                i.setDate(datee.toLocalDate());
                    
                i.setHeureAppel(resultatRequete.getString("i_heureAppel"));
                i.setHeureArrivee(resultatRequete.getString("i_heureArrivee"));
                i.setDuree(resultatRequete.getString("i_duree"));
                 
             
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getFonctionById  a généré une erreur");
        }
        return i ;
    }
    
    public static ArrayList<Pompier> getLesPompiersByIntervention(Connection cnx, int idIntervention){
        
        ArrayList<Pompier> lesPompiers = new ArrayList<Pompier>();
        Pompier p = null;
        
        try{
            requeteSql = cnx.prepareStatement ("SELECT pompier.id AS p_id, pompier.nom AS p_nom, pompier.prenom AS p_prenom FROM pompier INNER JOIN pompier_intervention ON pompier.id = pompier_intervention.pompier_id WHERE pompier_intervention.intervention_id = ?;");
            requeteSql.setInt(1, idIntervention);
            resultatRequete = requeteSql.executeQuery();
        
        while (resultatRequete.next()){
            
            p = new Pompier();
            p.setId(resultatRequete.getInt("p_id"));
            p.setNom(resultatRequete.getString("p_nom"));
            p.setPrenom(resultatRequete.getString("p_prenom"));
            
            lesPompiers.add(p);
            }
        }
        
        
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getFonctionById  a généré une erreur");
        }
        return lesPompiers;
    }
    
    
    public static Intervention getNomInterventionById(Connection cnx, int idIntervention){
        
        Intervention i = null;
        
        try{
            requeteSql = cnx.prepareStatement("SELECT intervention.id AS i_id, intervention.lieu AS i_lieu "
                    + "FROM intervention "
                    + "WHERE intervention.id = ?;");
            requeteSql.setInt(1, idIntervention);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                i = new Intervention();
                i.setId(resultatRequete.getInt("i_id"));
                i.setLieu(resultatRequete.getString("i_lieu"));
            }
        }
          catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return i ;    
    }
    
}