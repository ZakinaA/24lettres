/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import static database.DaoPompier.requeteSql;
import static database.DaoPompier.resultatRequete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Caserne;
import model.Fonction;
import model.Pompier;

/**
 *
 * @author zakina
 */

public class DaoCaserne {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Caserne> getLesCasernes(Connection cnx){
        
        ArrayList<Caserne> lesCasernes= new ArrayList<Caserne>();
        try{
            requeteSql = cnx.prepareStatement("select * from caserne");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Caserne c = new Caserne();
                    c.setId(resultatRequete.getInt("id"));
                    c.setNom(resultatRequete.getString("nom"));
                    c.setRue(resultatRequete.getString("rue"));
                    c.setCopos(resultatRequete.getString("copos"));
                    c.setVille(resultatRequete.getString("ville"));

                lesCasernes.add(c);
            }
           
        }
        catch (SQLException e){
            System.out.println("La requête de getLesPompiers a généré une erreur");
        }
        return lesCasernes;
    }
    
public static Caserne getCaserneById(Connection cnx, int idCaserne){

    Caserne c = null ;
    try{
        requeteSql = cnx.prepareStatement("SELECT\n" + " caserne.id AS c_id,\n" + " caserne.nom AS c_nom,\n" + " caserne.rue AS c_rue,\n" + " caserne.copos AS c_copos,\n" + " caserne.ville AS c_ville\n" + "FROM\n" + " caserne\n" + "WHERE\n" + " caserne.id = ?;");
        requeteSql.setInt(1, idCaserne);
        resultatRequete = requeteSql.executeQuery();

        if (resultatRequete.next()){

            c = new Caserne();
            c.setId(resultatRequete.getInt("c_id"));
            c.setNom(resultatRequete.getString("c_nom"));
            c.setRue(resultatRequete.getString("c_rue"));
            c.setCopos(resultatRequete.getString("c_copos"));
            c.setVille(resultatRequete.getString("c_ville"));
            
        }

        ArrayList<Pompier> lesPompiers = DaoCaserne.getPompiersByCaserneId(cnx, idCaserne);
        c.setLesPompiers(lesPompiers);
        
    }
    catch (SQLException e){
        System.out.println("La requête de getCaserneById a généré une erreur");
    }
    return c ;
}
     public static ArrayList<Pompier> getPompiersByCaserneId(Connection cnx, int idCaserne){
        
        ArrayList<Pompier> lesPompiers = new ArrayList<Pompier>();
        Pompier p = null;
        
        try{
            requeteSql = cnx.prepareStatement ("SELECT id,nom FROM `pompier` WHERE caserne_id = ?;");
            requeteSql.setInt(1, idCaserne);
            resultatRequete = requeteSql.executeQuery();
        
        while (resultatRequete.next()){
            
            p = new Pompier();
            p.setId(resultatRequete.getInt("p_id"));
            p.setNom(resultatRequete.getString("p_nom"));
            
            lesPompiers.add(p);
            }
        }
        
        
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getPompierById  a généré une erreur");
        }
        return lesPompiers;
    }
}

