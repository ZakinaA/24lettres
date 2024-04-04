/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author ts1sio
 */
public class Vehicule {
    
    private int id;
    private String immat;
    private String dateOrigine;
    private String dateRevision;
    private TypeVehicule typeVehicule;
    
    public Vehicule() {  
    }

    public Vehicule(int id, String immat, String dateOrigine, String dateRevision, TypeVehicule typeVehicule) {
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

    public void setDateOrigine(String dateOrigine) {
        this.dateOrigine = dateOrigine;
    }

    public void setDateRevision(String dateRevision) {
        this.dateRevision = dateRevision;
    }

    public String getDateOrigine() {
        return dateOrigine;
    }

    public String getDateRevision() {
        return dateRevision;
    }
    
     public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }
    
    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }
}
