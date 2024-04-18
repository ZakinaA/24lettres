/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import database.ConnexionBdd;
import database.DaoVehicule;
import java.sql.Connection;
import java.time.LocalDate;
import model.TypeVehicule;
import model.Vehicule;

/**
 *
 * @author zakina
 */
public class TestDaoVehicule {
    
    public static void main (String args[]){
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        System.out.println ("nombre de pomipiers=" + DaoVehicule.getLesVehicules(cnx).size());
        
        System.out.println ("Le pompier 1 s'appelle =" + DaoVehicule.getVehiculeById(cnx,1).getImmat());
        
        Vehicule p = new Vehicule();
        p.setImmat("testAddNom");
        p.setTypeVehicule(new TypeVehicule(2));
        LocalDate dateNaiss = LocalDate.parse("2000-05-18");
        p.setDateOrigine(dateNaiss);
        LocalDate dateNaissance = LocalDate.parse("1500-05-18");
        p.setDateRevision(dateNaissance);
       
        p = DaoVehicule.addVehicule(cnx, p);
        System.out.println("le nouveau véhicule a reçu l id = " + p.getId());
        
        
    }
    
}