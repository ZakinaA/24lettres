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
            v.setDateOrigine(resultatRequete.getString("v_dateOrigine"));
            v.setDateRevision(resultatRequete.getString("v_dateRevision"));
            

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
        requeteSql = cnx.prepareStatement("SELECT vehicule.id AS v_id, vehicule.immat AS v_immat, vehicule.dateOrigine AS v_dateOrigine, vehicule.dateRevision AS v_dateRevision, vehicule_type.nom AS vt_nom FROM vehicule INNER JOIN type_vehicule ON type_vehicule.id = vehicule.type_vehicule_id where vehicule.id= ? ;");
        requeteSql.setInt(1, idVehicule);
        resultatRequete = requeteSql.executeQuery();

        if (resultatRequete.next()){

            v = new Vehicule();
            v.setId(resultatRequete.getInt("v_id"));
            v.setImmat(resultatRequete.getString("v_immat"));
            v.setDateOrigine(resultatRequete.getString("v_dateOrigine"));
            v.setDateRevision(resultatRequete.getString("v_dateRevision"));
            
            
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
