/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.Grade;
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
        
        Grade grade1 = new Grade();
        grade1.setId(1);
        grade1.setLibelle("Commandant");
        
        Grade grade2 = new Grade();
        grade2.setId(2);
        grade2.setLibelle("Capitaine");
        
        surgrade1.addUnGrade(grade1);
        surgrade1.addUnGrade(grade2);
        
        System.out.println("Le Surgrade " + surgrade1.getLibelle() + " contient les grades suivants :");
        for (Grade g : surgrade1.getLesGrades()) {
            System.out.println("- n°" + g.getId() + " : " + g.getLibelle());
        }
        
    }
    
}
