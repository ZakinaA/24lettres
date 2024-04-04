/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author mahdi.ashuri
 */
public class Grade {
    
    private int id;
    private String libelle;
    private Surgrade surgrade;
    private ArrayList<Pompier> lesPompiers ;
    
    public Grade() {
    }
    
    public Grade(int id) {
        this.id = id;
    }
    
    public Grade(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    public Surgrade getSurgrade() {
        return surgrade;
    }
    
    public void setSurgrade(Surgrade surgrade) {
        this.surgrade = surgrade;
    }

    public ArrayList<Pompier> getLesPompiers() {
        return lesPompiers;
    }
    
    public void setLesPompiers(ArrayList<Pompier> lesPompiers) {
        this.lesPompiers = lesPompiers;
    }
    
}
