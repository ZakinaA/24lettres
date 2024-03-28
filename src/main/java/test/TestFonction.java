/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.Fonction;

/**
 *
 * @author ts1sio
 */
public class TestFonction {
     public static void main (String args[]){
        
        Fonction f = new Fonction();
        f.setId(1);
        f.setLibelle("Fonction1");
        
         System.out.println ("La fonction numéro " + f.getId() + " correspond à " + f.getLibelle());
    }
}
