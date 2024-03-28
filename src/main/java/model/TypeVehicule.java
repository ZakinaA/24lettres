/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ts1sio
 */
public class TypeVehicule {
    
    private int id;
    private String nom;
    private String caracteristique;
    
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

    
}
