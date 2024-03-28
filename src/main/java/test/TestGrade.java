/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.Grade;



/**
 *
 * @author mahdi.ashuri
 */
public class TestGrade {
public static void main(String[] args) {
        
        Grade Grade = new Grade();
        Grade.setId(1);
        Grade.setLibelle("Mahdi");
       
        System.out.println("Grade numéro " + Grade.getId() + " se Libelle " + Grade.getLibelle());
    }
}
