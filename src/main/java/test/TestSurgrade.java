/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.Surgrade;

/**
 *
 * @author ts1sio
 */
public class TestSurgrade {
    
    public static void main (String args[]) {
        
        Surgrade surgrade1 = new Surgrade();
        surgrade1.setId(1);
        surgrade1.setLibelle("Officier");
        
        System.out.println("Le Surgrade n°" + surgrade1.getId() + " est le grade " + surgrade1.getLibelle());
        
    }
    
}
