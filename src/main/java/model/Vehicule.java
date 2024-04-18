/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ts1sio
 */
public class Vehicule {
    
    private int id;
    private String immat;
    private LocalDate dateOrigine;
    private LocalDate dateRevision;
    private TypeVehicule typeVehicule;
    private ArrayList<Intervention> lesInterventions ;
    
    public Vehicule() {  
    }

    public Vehicule(int id, String immat, LocalDate dateOrigine, LocalDate dateRevision, TypeVehicule typeVehicule) {
        this.id = id;
        this.immat = immat;
        this.dateOrigine = dateOrigine;
        this.dateRevision = dateRevision;
    }
    
    public Vehicule (int id, String immat){
        this.id = id;
        this.immat = immat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public void setDateOrigine(LocalDate dateOrigine) {
        this.dateOrigine = dateOrigine;
    }

    public void setDateRevision(LocalDate dateRevision) {
        this.dateRevision = dateRevision;
    }

    public LocalDate getDateOrigine() {
        return dateOrigine;
    }

    public LocalDate getDateRevision() {
        return dateRevision;
    }
    
     public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }
    
    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public ArrayList<Intervention> getLesInterventions() {
        return lesInterventions;
    }

    public void setLesInterventions(ArrayList<Intervention> lesInterventions) {
        this.lesInterventions = lesInterventions;
    }
    
}
