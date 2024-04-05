/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import database.ConnexionBdd;
import database.DaoPompier;
import java.sql.Connection;
import java.time.LocalDate;
import model.Caserne;
import model.Grade;
import model.Pompier;

/**
 *
 * @author zakina
 */
public class TestDaoPompier {
    
    public static void main (String args[]){
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        System.out.println ("nombre de pomipiers=" + DaoPompier.getLesPompiers(cnx).size());
        
        System.out.println ("Le pompier 1 s'appelle =" + DaoPompier.getPompierById(cnx,1).getNom());
        
        Pompier p = new Pompier();
        p.setNom("testAddNom");
        p.setSexe("aaaa");
        p.setTelephone("00000000");
        p.setUneCaserne(new Caserne(1));
        LocalDate dateNaiss = LocalDate.parse("2000-05-18");
        p.setDateNaissance(dateNaiss);
        p.setPrenom("testAddPrenom");
        p.setUnGrade(new Grade(2));
        p.setBip("BIP7882");
        
        
        p = DaoPompier.addPompier(cnx, p);
        System.out.println("le nouveau pompier a reçu l id = " + p.getId());
        
        
    }
    
}