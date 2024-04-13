/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

import java.time.LocalDate;


/**
 *
 * @author zakina
 */
public class Pompier {
    
    private int id;
    private String bip;
    private String nom;
    private String prenom ;
    private String sexe;
    private String telephone;
    private LocalDate dateNaissance;
    private Caserne uneCaserne ;
    private Grade unGrade ;
    private ArrayList<Fonction> lesFonctions ;
    private ArrayList<Intervention> lesInterventions ;

    public Pompier() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Pompier(int id, String nom, String prenom, Caserne uneCaserne){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.uneCaserne = uneCaserne;
    }

    public String getBip() {
        return bip;
    }

    public void setBip(String bip) {
        this.bip = bip;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Caserne getUneCaserne() {
        return uneCaserne;
    }

    public void setUneCaserne(Caserne uneCaserne) {
        this.uneCaserne = uneCaserne;
    }
    
    public Grade getUnGrade() {
        return unGrade;
    }

    public void setUnGrade(Grade unGrade) {
        this.unGrade = unGrade;
    }

    public String getSexe() {
        return sexe;
    }

    public String getTelephone() {
        return telephone;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public ArrayList<Fonction> getLesFonctions() {
        return lesFonctions;
    }
    public void setLesFonctions(ArrayList<Fonction> lesFonctions) {
        this.lesFonctions = lesFonctions;
    }

    public ArrayList<Intervention> getLesInterventions() {
        return lesInterventions;
    }
    
    public void setLesInterventions(ArrayList<Intervention> lesInterventions) {
        this.lesInterventions = lesInterventions;
    }
    
    public void addFonction(Fonction f){
        if (lesFonctions == null){
            lesFonctions = new ArrayList<Fonction>();
        }
        lesFonctions.add(f);
    }
    
     public void addIntervention(Intervention i){
        if (lesInterventions == null){
            lesInterventions = new ArrayList<Intervention>();
        }
        lesInterventions.add(i);
    }
}
