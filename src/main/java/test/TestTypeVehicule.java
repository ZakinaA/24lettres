/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.time.LocalDate;
import model.TypeVehicule;

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
        
        System.out.println("Le véhicule n°" + typeVehicule1.getId() + " est un " + typeVehicule1.getNom()+ " soit "+ typeVehicule1.getCaracteristique());
        System.out.println("Le véhicule n°" + typeVehicule2.getId() + " est un " + typeVehicule2.getNom()+ " soit "+ typeVehicule2.getCaracteristique());
        System.out.println("Le véhicule n°" + typeVehicule3.getId() + " est un " + typeVehicule3.getNom()+ " soit "+ typeVehicule3.getCaracteristique());
        
    }
    }
    
