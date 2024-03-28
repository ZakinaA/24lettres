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
    private LocalDate dateOrigine;
    private LocalDate dateRevision;
    
    public Vehicule() {  
    }

    public Vehicule(int id, String immat, LocalDate dateOrigine, LocalDate dateRevision) {
        this.id = id;
        this.immat = immat;
        this.dateOrigine = dateOrigine;
        this.dateRevision = dateRevision;
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
    
}
