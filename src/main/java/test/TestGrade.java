/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.Grade;
import model.Surgrade;

/**
 *
 * @author mahdi.ashuri
 */
public class TestGrade {
public static void main(String[] args) {
        
        Grade Grade = new Grade();
        Grade.setId(1);
        Grade.setLibelle("Capitaine");
        
        Grade grade1 = new Grade();
        grade1.setId(2);
        grade1.setLibelle("Commandant");
        
        Surgrade surgrade1 = new Surgrade();
        surgrade1.setId(1);
        surgrade1.setLibelle("Officier");
        
        Grade.setSurgrade(surgrade1);
        grade1.setSurgrade(surgrade1);
       
        System.out.println("Le Grade n°" + Grade.getId() + " est le grade " + Grade.getLibelle() + ". Il appartient au Surgrade " + Grade.getSurgrade().getLibelle() + ".");       
        System.out.println("Le Grade n°" + grade1.getId() + " est le grade " + grade1.getLibelle() + ". Il appartient au Surgrade " + grade1.getSurgrade().getLibelle() + ".");
    }
}
