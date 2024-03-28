/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class TypeVehicule {
    
    private int id;
    private String nom;
    private String caracteristique;
    private ArrayList<Vehicule> lesVehicules;
    public TypeVehicule() {  
    }

    public TypeVehicule(int id, String nom, String caracteristique) {
        this.id = id;
        this.nom = nom;
        this.caracteristique = caracteristique;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

       public ArrayList<Vehicule> getLesVehicules() {
        return lesVehicules;
    }

    public void setLesVehicules(ArrayList<Vehicule> lesVehicules) {
        this.lesVehicules = lesVehicules;
    }
    
    public void addUnVehicule(Vehicule unVehicule) {
        if (lesVehicules == null) {
            lesVehicules = new ArrayList<Vehicule>();
        }
        
        lesVehicules.add(unVehicule);

    }}