/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.Vehicule;

/**
 *
 * @author ts1sio
 */
public class TestVehicule {
    
    public static void main (String args[]) {
        
        Vehicule vehicule1 = new Vehicule();
        vehicule1.setId(1);
        vehicule1.setLibelle("EPA");
        
        System.out.println("Le véhicule n°" + vehicule1.getId() + " est un " + vehicule1.getLibelle());
        
    }
    
}
