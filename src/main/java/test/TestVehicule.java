/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.time.LocalDate;
import model.Vehicule;
import model.TypeVehicule;

/**
 *
 * @author ts1sio
 */
public class TestVehicule {
    
    public static void main (String args[]) {
        
        Vehicule vehicule1 = new Vehicule();
        vehicule1.setId(1);
        vehicule1.setImmat("EPA");
        vehicule1.setDateOrigine(LocalDate.of(1995, 12, 5));
        vehicule1.setDateRevision(LocalDate.of(2022, 1, 3));
        
        
        
        TypeVehicule typeVehicule1 = new TypeVehicule();
        typeVehicule1.setId(1);
        typeVehicule1.setNom("VSAV");
        typeVehicule1.setCaracteristique("véhicule de secours aux victimes");
        
        vehicule1.setTypeVehicule(typeVehicule1);
        
        System.out.println("Le véhicule n°" + vehicule1.getId() + " est un " + vehicule1.getImmat()+ ", existe depuis " + vehicule1.getDateOrigine() + " et doit faire une révision en " + vehicule1.getDateRevision() + ", son type de véhicule est "+ vehicule1.getTypeVehicule().getNom());
        
    }
    }
    
