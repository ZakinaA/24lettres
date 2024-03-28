/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import database.ConnexionBdd;
import database.DaoFonction;
import java.sql.Connection;
import model.Fonction;

/**
 *
 * @author zakina
 */
public class TestDaoFonction {
    
    public static void main (String args[]){
        
        Connection cnx = ConnexionBdd.ouvrirConnexion();
        System.out.println ("nombre de fonction=" + DaoFonction.getLesFonctions(cnx).size());
        
        System.out.println ("La fonction 2 s'appelle =" + DaoFonction.getFonctionById(cnx,2).getLibelle());
        
        Fonction f = new Fonction();
        f.setLibelle("Sauvetage en hauteur");
        
        f = DaoFonction.addFonction(cnx, f);
        System.out.println("la nouvelle fonction a reçu un id = " + f.getId());
        
        
    }
    
}
