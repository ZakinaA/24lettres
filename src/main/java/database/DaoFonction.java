/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Fonction;
import model.Pompier;

/**
 *
 * @author zakina
 */
public class DaoFonction {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Fonction> getLesFonctions(Connection cnx){
        
        ArrayList<Fonction> lesFonctions = new ArrayList<Fonction>();
        try{
            requeteSql = cnx.prepareStatement("SELECT fonction.id AS f_id, fonction.libelle AS f_libelle, fonction.description AS f_description "
                                            + "FROM fonction;");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Fonction f = new Fonction();
                    f.setId(resultatRequete.getInt("f_id"));
                    f.setLibelle(resultatRequete.getString("f_libelle"));
                    f.setDescription(resultatRequete.getString("f_description"));
                    
                lesFonctions.add(f);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesFonctions e généré une erreur");
        }
        return lesFonctions;
    }
    
    public static Fonction getFonctionById(Connection cnx, int idFonction){
        
        Fonction f = null ;
        try{
            requeteSql = cnx.prepareStatement("SELECT fonction.id AS f_id, fonction.libelle AS f_libelle, pompier.id AS p_id, pompier.nom AS p_nom, pompier.prenom AS p_prenom "
                                                + "FROM fonction "
                                                + "INNER JOIN pompier_fonction "
                                                + "ON fonction.id = pompier_fonction.fonction_id "
                                                + "INNER JOIN pompier "
                                                + "ON pompier.id = pompier_fonction.pompier_id "
                                                + "where fonction.id= ? ");
            requeteSql.setInt(1, idFonction);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                    f = new Fonction();
                    f.setId(resultatRequete.getInt("f_id"));
                    f.setLibelle(resultatRequete.getString("f_libelle"));
                 
             
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getFonctionById  a généré une erreur");
        }
        return f ;
    }
    
    public static ArrayList<Pompier> getLesPompiersByFonction(Connection cnx, int idFonction){
        
        ArrayList<Pompier> lesPompiers = new ArrayList<Pompier>();
        Pompier p = null;
        
        try{
            requeteSql = cnx.prepareStatement ("SELECT pompier.id AS p_id, pompier.nom AS p_nom, pompier.prenom AS p_prenom FROM pompier INNER JOIN pompier_fonction ON pompier.id = pompier_fonction.pompier_id WHERE pompier_fonction.fonction_id = ?;");
            requeteSql.setInt(1, idFonction);
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
    
    
    public static Fonction getNomFonctionById(Connection cnx, int idFonction){
        
        Fonction n = null;
        
        try{
            requeteSql = cnx.prepareStatement("SELECT fonction.id AS f_id, fonction.libelle AS f_libelle "
                    + "FROM fonction "
                    + "WHERE fonction.id = ?;");
            requeteSql.setInt(1, idFonction);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                n = new Fonction();
                n.setId(resultatRequete.getInt("f_id"));
                n.setLibelle(resultatRequete.getString("f_libelle"));
            }
        }
          catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return n ;    
    }
    
    public static Fonction addFonction(Connection connection, Fonction f){      
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requeteSql=connection.prepareStatement("INSERT INTO fonction (libelle)\n" +
                    "VALUES (?)", requeteSql.RETURN_GENERATED_KEYS );
            requeteSql.setString(1, f.getLibelle());

           /* Exécution de la requête */
            requeteSql.executeUpdate();
            
             // Récupération de id auto-généré par la bdd dans la table client
            resultatRequete = requeteSql.getGeneratedKeys();
            while ( resultatRequete.next() ) {
                idGenere = resultatRequete.getInt( 1 );
                f.setId(idGenere);
                
                f = DaoFonction.getFonctionById(connection, f.getId());
            }
            
         
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return f ;    
    }
    
}