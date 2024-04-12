/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import static database.ConnexionBdd.rs;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Intervention;
import model.TypeVehicule;
import model.Vehicule;

/**
 *
 * @author zakina
 */
public class DaoVehicule {

    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    public static ArrayList<Vehicule> getLesVehicules(Connection cnx){

    ArrayList<Vehicule> lesVehicules = new ArrayList<Vehicule>();
    try{
        requeteSql = cnx.prepareStatement("SELECT vehicule.id AS v_id, vehicule.immat AS v_immat, vehicule.dateOrigine AS v_dateOrigine, vehicule.dateRevision AS v_dateRevision, type_vehicule.nom AS vt_nom FROM vehicule INNER JOIN type_vehicule ON type_vehicule.id = vehicule.type_vehicule_id;");
        resultatRequete = requeteSql.executeQuery();

        while (resultatRequete.next()){

            Vehicule v = new Vehicule();
            v.setId(resultatRequete.getInt("v_id"));
            v.setImmat(resultatRequete.getString("v_immat"));
            
            Date dateOrigine = resultatRequete.getDate("v_dateOrigine");
            v.setDateOrigine(dateOrigine.toLocalDate());
            Date dateRevision = resultatRequete.getDate("v_dateRevision");
            v.setDateRevision(dateRevision.toLocalDate());
            
            TypeVehicule type = new TypeVehicule();
            type.setNom(resultatRequete.getString("vt_nom"));
            v.setTypeVehicule(type);
            lesVehicules.add(v);
        }

    }
    catch (SQLException e){
        e.printStackTrace();
        System.out.println("La requête de getLesVehicules a généré une erreur");
    }
    return lesVehicules;
}

public static Vehicule getVehiculeById(Connection cnx, int idVehicule){

    Vehicule v = null ;
    try{
        requeteSql = cnx.prepareStatement("SELECT vehicule.id AS v_id, vehicule.immat AS v_immat, vehicule.dateOrigine AS v_dateOrigine, vehicule.dateRevision AS v_dateRevision, vehicule_type.nom AS vt_nom, intervention.id AS i_id, intervention.lieu AS i_lieu, intervention.date AS i_date "
                + "FROM vehicule "
                + "INNER JOIN type_vehicule "
                + "ON type_vehicule.id = vehicule.type_vehicule_id "
                + "INNER JOIN intervention "
                + "ON intervention.id = intervention_vehicule.intervention_id"
                + "where vehicule.id= ? ;");
        requeteSql.setInt(1, idVehicule);
        resultatRequete = requeteSql.executeQuery();

        while (resultatRequete.next()){

            v = new Vehicule();
            v.setId(resultatRequete.getInt("v_id"));
            v.setImmat(resultatRequete.getString("v_immat"));
            Date dateOrigine = resultatRequete.getDate("v_dateOrigine");
            v.setDateOrigine(dateOrigine.toLocalDate());
            Date dateRevision = resultatRequete.getDate("v_dateRevision");
            v.setDateRevision(dateRevision.toLocalDate());
            
            TypeVehicule type = new TypeVehicule();
            type.setNom(resultatRequete.getString("vt_nom"));
            v.setTypeVehicule(type);
          
        }

    }
    catch (SQLException e){
        e.printStackTrace();
        System.out.println("La requête de getFonctionById a généré une erreur");
    }
    return v ;
}
public static ArrayList<Intervention> getLesInterventionsByVehicule(Connection cnx, int idFonction){
        
        ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>();
        Intervention i = null;
        
        try{
            requeteSql = cnx.prepareStatement ("SELECT intervention.id AS i_id, intervention.lieu AS i_lieu, intervention.date AS i_date "
                    + "FROM intervention "
                    + "INNER JOIN intervention_vehicule ON intervention.id = intervention_vehicule.intervention_id "
                    + "WHERE intervention_vehicule.vehicule_id = ?;");
            requeteSql.setInt(1, idFonction);
            resultatRequete = requeteSql.executeQuery();
        
        while (resultatRequete.next()){
            
            i = new Intervention();
            i.setId(resultatRequete.getInt("i_id"));
            i.setLieu(resultatRequete.getString("i_lieu"));
            Date dateInter = resultatRequete.getDate("i_date");
            i.setDate(dateInter.toLocalDate());
            
            lesInterventions.add(i);
            }
        }
        
        
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesInterventionsByVehicule a généré une erreur");
        }
        return lesInterventions;
    }

public static Vehicule getNomVehiculeById(Connection cnx, int idVehicule){
        
        Vehicule n = null;
        
        try{
            requeteSql = cnx.prepareStatement("SELECT vehicule.id AS v_id, vehicule.immat AS v_immat "
                    + "FROM vehicule "
                    + "WHERE vehicule.id = ?;");
            requeteSql.setInt(1, idVehicule);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                n = new Vehicule();
                n.setId(resultatRequete.getInt("v_id"));
                n.setImmat(resultatRequete.getString("v_immat"));
            }
        }
          catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return n ;    
    }

public static Vehicule addVehicule(Connection connection, Vehicule v) {
    int idGenere = -1;
    try {
        requeteSql = connection.prepareStatement("INSERT INTO vehicule (immat, dateOrigine, dateRevision) VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        requeteSql.setString(1, v.getImmat());
        requeteSql.setDate(2, Date.valueOf(v.getDateOrigine()));
        requeteSql.setDate(3, Date.valueOf(v.getDateRevision()));
        requeteSql.executeUpdate();

        resultatRequete = requeteSql.getGeneratedKeys();
        if (resultatRequete.next()) {
            idGenere = resultatRequete.getInt(1);
            v.setId(idGenere);
        } else {
            System.err.println("Aucun ID généré trouvé après l'insertion de la fonction");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return v;
}
}
