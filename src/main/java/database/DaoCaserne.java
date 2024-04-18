/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author ts1sio
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Caserne;
import model.Pompier;
import model.Vehicule;

/**
 *
 * @author mahdi.ashuri
 */
public class DaoCaserne {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Caserne> getLesCasernes(Connection cnx){
        
        ArrayList<Caserne> lesCasernes = new ArrayList<Caserne>();
        try{
            requeteSql = cnx.prepareStatement("SELECT caserne.id AS c_id,"
                    + " caserne.nom AS c_nom,"
                    + " caserne.rue AS c_rue,"
                    + " caserne.copos AS c_copos,"
                    + " caserne.ville AS c_ville"
                    + " FROM caserne;");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Caserne c = new Caserne();
                    c.setId(resultatRequete.getInt("c_id"));
                    c.setNom(resultatRequete.getString("c_nom"));
                    c.setRue(resultatRequete.getString("c_rue"));
                    c.setCopos(resultatRequete.getString("c_copos"));
                    c.setVille(resultatRequete.getString("c_ville"));
                     
                lesCasernes.add(c);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesCasernes a généré une erreur");
        }
        return lesCasernes;
    }
    
    
    public static ArrayList<Pompier> getPompiersByCaserneId(Connection cnx, int idPompier){
        
        ArrayList<Pompier> lesPompiers = new ArrayList<Pompier>();
        Pompier p = null;
        
        try{
            requeteSql = cnx.prepareStatement("SELECT pompier.id AS p_id, pompier.nom AS p_nom, pompier.prenom AS p_prenom FROM pompier WHERE pompier.caserne_id = ?;");
            requeteSql.setInt(1, idPompier);
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
            System.out.println("La requête de getPompierByCaserneId  a généré une erreur");
        }
        return lesPompiers;
    }
       
    
    public static ArrayList<Vehicule> getVehiculeByCaserneId(Connection cnx, int idPompier){
        
        ArrayList<Vehicule> lesVehicules = new ArrayList<Vehicule>();
        Vehicule v = null;
        
        try{
            requeteSql = cnx.prepareStatement("SELECT vehicule.id AS v_id, vehicule.immat AS v_immat FROM vehicule WHERE vehicule.caserne_id = ?;");
            requeteSql.setInt(1, idPompier);
            resultatRequete = requeteSql.executeQuery();
        
        while (resultatRequete.next()){
            
            v = new Vehicule();
                v.setId(resultatRequete.getInt("v_id"));
                v.setImmat(resultatRequete.getString("v_immat"));
            
                lesVehicules.add(v);
        }
        }
        
        
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getVehiculeByCaserneId  a généré une erreur");
        }
        return lesVehicules;
    }
    
    public static Caserne getCaserneById(Connection cnx, int idCaserne){
        
        Caserne c = null ;
        try{
            requeteSql = cnx.prepareStatement("SELECT caserne.id AS c_id,"
            + "                                 caserne.nom AS c_nom,"
                    + "caserne.rue AS c_rue,"
                    + "caserne.copos AS c_copos,"
                    + "caserne.ville AS c_ville"
            + "                                 FROM caserne"
            + "                                 WHERE caserne.id = ?;");
            requeteSql.setInt(1, idCaserne);
            resultatRequete = requeteSql.executeQuery();
            
            if (resultatRequete.next()){
                
                    c = new Caserne();
                    c.setId(resultatRequete.getInt("c_id"));
                    c.setNom(resultatRequete.getString("c_nom"));
                    c.setRue(resultatRequete.getString("c_rue"));
                    c.setCopos(resultatRequete.getString("c_copos"));
                    c.setVille(resultatRequete.getString("c_ville"));
                    
                    ArrayList<Pompier> lesPompiers = DaoCaserne.getPompiersByCaserneId(cnx, idCaserne);
                    c.setLesPompiers(lesPompiers);
                    ArrayList<Vehicule> lesVehicules = DaoCaserne.getVehiculeByCaserneId(cnx, idCaserne);
                    c.setLesVehicules(lesVehicules);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getCaserneById a généré une erreur");
        }
        return c ;
    }
    
}
