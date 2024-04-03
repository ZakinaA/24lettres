/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import static database.ConnexionBdd.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TypeVehicule;

/**
 *
 * @author zakina
 */
public class DaoTypeVehicule {

    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    public static ArrayList<TypeVehicule> getLesTypeVehicules(Connection cnx){

    ArrayList<TypeVehicule> lesTypeVehicules = new ArrayList<TypeVehicule>();
    try{
        requeteSql = cnx.prepareStatement("SELECT type_vehicule.id AS t_id, type_vehicule.nom AS t_nom, type_vehicule.caracteristique AS t_caracteristique FROM type_vehicule;");
        resultatRequete = requeteSql.executeQuery();

        while (resultatRequete.next()){

            TypeVehicule t = new TypeVehicule();
            t.setId(resultatRequete.getInt("t_id"));
            t.setNom(resultatRequete.getString("t_nom"));
            t.setCaracteristique(resultatRequete.getString("t_caracteristique"));

            lesTypeVehicules.add(t);
        }

    }
    catch (SQLException e){
        e.printStackTrace();
        System.out.println("La requête de getLesVehicules a généré une erreur");
    }
    return lesTypeVehicules;
}

public static TypeVehicule getTypeVehiculeById(Connection cnx, int idTypeVehicule){

    TypeVehicule t = null ;
    try{
        requeteSql = cnx.prepareStatement("SELECT type_vehicule.id AS t_id, type_vehicule.nom AS t_nom, type_vehicule.caracteristique AS t_caracteristique FROM type_vehicule where type_vehicule.id= ? ;");
        requeteSql.setInt(1, idTypeVehicule);
        resultatRequete = requeteSql.executeQuery();

        if (resultatRequete.next()){

            t = new TypeVehicule();
            t.setId(resultatRequete.getInt("t_id"));
            t.setNom(resultatRequete.getString("t_nom"));
            t.setCaracteristique(resultatRequete.getString("t_caracteristique"));
        }

    }
    catch (SQLException e){
        e.printStackTrace();
        System.out.println("La requête de getTypeVehiculeById a généré une erreur");
    }
    return t ;
}

public static TypeVehicule addTypeVehicule(Connection connection, TypeVehicule t) {
    int idGenere = -1;
    try {
        requeteSql = connection.prepareStatement("INSERT INTO type_vehicule (nom, caracteristique) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        requeteSql.setString(1, t.getNom());
        requeteSql.setString(2, t.getCaracteristique());
        requeteSql.executeUpdate();

        resultatRequete = requeteSql.getGeneratedKeys();
        if (resultatRequete.next()) {
            idGenere = resultatRequete.getInt(1);
            t.setId(idGenere);
        } else {
            System.err.println("Aucun ID généré trouvé après l'insertion du type de vehicule");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return t;
}
}
