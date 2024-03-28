/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author zakina
 */
public class Fonction {
    
    private int id;
    private String libelle ;
    private ArrayList<Fonction> lesFonctions ;

    public Fonction() {
    }

    public Fonction(int id) {
        this.id = id;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<Fonction> getLesFonction() {
        return lesFonctions;
    }

    public void setLesFonctions(ArrayList<Fonction> lesFonctions) {
        this.lesFonctions = lesFonctions;
    }
    
    public void addFonction(Fonction f){
        if (lesFonctions == null){
            lesFonctions = new ArrayList<Fonction>();
        }
        lesFonctions.add(f);
    }
    
}
