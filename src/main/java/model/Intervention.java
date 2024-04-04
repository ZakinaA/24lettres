/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author zakina
 */
public class Intervention {
    
    private int id;
    private String lieu ;
    private LocalDate date;
    private String heureAppel;
    private String heureArrivee;
    private String duree;
    private ArrayList<Pompier> lesPompiers ;

    public Intervention() {
    }

    public Intervention(int id){
        this.id = id;
    }
    
    public Intervention (int id, String lieu, LocalDate date, String heureAppel, String heureArrivee, String Duree, ArrayList<Pompier> lesPompiers){
        this.id = id;
        this.lieu = lieu;
        this.date = date;
        this.heureAppel = heureAppel;
        this.heureArrivee = heureArrivee;
        this.duree = duree;
        this.lesPompiers = lesPompiers;
    }
    
    public int getId() {
        return id;
    }

    public String getLieu() {
        return lieu;
    }

    public String getHeureAppel() {
        return heureAppel;
    }

    public String getHeureArrivee() {
        return heureArrivee;
    }

    public String getDuree() {
        return duree;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setHeureAppel(String heureAppel) {
        this.heureAppel = heureAppel;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public ArrayList<Pompier> getLesPompiers() {
        return lesPompiers;
    }

    public void setLesPompiers(ArrayList<Pompier> lesPompiers) {
        this.lesPompiers = lesPompiers;
    }
    
    public void addPompier(Pompier p){
        if (lesPompiers == null){
            lesPompiers = new ArrayList<Pompier>();
        }
        lesPompiers.add(p);
    }
    
}
