/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.TypeVehicule;
import model.Vehicule;

/**
 *
 * @author ts1sio
 */
public class TestTypeVehicule {
    
    public static void main (String args[]) {
        
        TypeVehicule typeVehicule1 = new TypeVehicule();
        typeVehicule1.setId(1);
        typeVehicule1.setNom("VSAV");
        typeVehicule1.setCaracteristique("véhicule de secours aux victimes");
       
        TypeVehicule typeVehicule2 = new TypeVehicule();
        typeVehicule2.setId(2);
        typeVehicule2.setNom("FPT");
        typeVehicule2.setCaracteristique("fourgon pompe-tonne");
        
        TypeVehicule typeVehicule3 = new TypeVehicule();
        typeVehicule3.setId(3);
        typeVehicule3.setNom("EPA");
        typeVehicule3.setCaracteristique("échelle pivotante automatique");
        
        Vehicule vehicule1 = new Vehicule();
        vehicule1.setId(1);
        vehicule1.setImmat("LM-789-NP");
        
        Vehicule vehicule2 = new Vehicule();
        vehicule2.setId(2);
        vehicule2.setImmat("FZ-456-BG");
        
        Vehicule vehicule3 = new Vehicule();
        vehicule3.setId(3);
        vehicule3.setImmat("AB-123-CD");
        
        
        typeVehicule1.addUnVehicule(vehicule1);
        typeVehicule2.addUnVehicule(vehicule2);
        typeVehicule3.addUnVehicule(vehicule3);
        
       
        
        System.out.println("Le véhicule n°" + typeVehicule1.getId() + " est un " + typeVehicule1.getNom()+ " soit "+ typeVehicule1.getCaracteristique());
        System.out.println("Le véhicule n°" + typeVehicule2.getId() + " est un " + typeVehicule2.getNom()+ " soit "+ typeVehicule2.getCaracteristique());
        System.out.println("Le véhicule n°" + typeVehicule3.getId() + " est un " + typeVehicule3.getNom()+ " soit "+ typeVehicule3.getCaracteristique());
        
        for (Vehicule v : typeVehicule1.getLesVehicules()) {
            System.out.println("- véhicule n°" + v.getId() + " : " + v.getImmat());
        }
        for (Vehicule v : typeVehicule2.getLesVehicules()) {
            System.out.println("- véhicule n°" + v.getId() + " : " + v.getImmat());
        }
        for (Vehicule v : typeVehicule3.getLesVehicules()) {
            System.out.println("- véhicule n°" + v.getId() + " : " + v.getImmat());
        }
    }
    }
    
