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
import model.Grade;
import model.Pompier;
import model.Surgrade;

/**
 *
 * @author mahdi.ashuri
 */
public class DaoGrade {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Grade> getLesGrades(Connection cnx){
        
        ArrayList<Grade> lesGrades = new ArrayList<Grade>();
        try{
            requeteSql = cnx.prepareStatement("SELECT grade.id AS g_id,"
                    + " grade.libelle AS g_libelle,"
                    + " grade.surgrade_id AS g_surgradeid,"
                    + " surgrade.id AS s_id,"
                    + " surgrade.libelle AS s_libelle"
                    + " FROM grade"
                    + " INNER JOIN surgrade"
                    + " ON grade.surgrade_id = surgrade.id;");
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Grade g = new Grade();
                    g.setId(resultatRequete.getInt("g_id"));
                    g.setLibelle(resultatRequete.getString("g_libelle"));
                    
                Surgrade s = new Surgrade();
                    s.setId(resultatRequete.getInt("s_id"));
                    s.setLibelle(resultatRequete.getString("s_libelle"));
                    
                g.setSurgrade(s);
                
                lesGrades.add(g);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesGrades e généré une erreur");
        }
        return lesGrades;
    }
    
    
    public static ArrayList<Pompier> getPompiersByGradeId(Connection cnx, int idPompier){
        
        ArrayList<Pompier> lesPompiers = new ArrayList<Pompier>();
        Pompier p = null;
        
        try{
            requeteSql = cnx.prepareStatement("SELECT pompier.id AS p_id, pompier.nom AS p_nom, pompier.prenom AS p_prenom FROM pompier WHERE pompier.grade_id = ?;");
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
            System.out.println("La requête de getFonctionById  a généré une erreur");
        }
        return lesPompiers;
    }
                
    public static Grade getGradeById(Connection cnx, int idGrade){
        
        Grade g = null ;
        try{
            requeteSql = cnx.prepareStatement("SELECT grade.id AS g_id,"
            + "                                 grade.libelle AS g_libelle"
            + "                                 FROM grade"
            + "                                 WHERE grade.id = ?;");
            requeteSql.setInt(1, idGrade);
            resultatRequete = requeteSql.executeQuery();
            
            if (resultatRequete.next()){
                
                    g = new Grade();
                    g.setId(resultatRequete.getInt("g_id"));
                    g.setLibelle(resultatRequete.getString("g_libelle"));
                    
                    ArrayList<Pompier> lesPompiers = DaoGrade.getPompiersByGradeId(cnx, idGrade);
                    g.setLesPompiers(lesPompiers);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getPompierById  a généré une erreur");
        }
        return g ;
    }
    
}
