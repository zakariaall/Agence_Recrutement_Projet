package com.workify.agence_recrut.entites;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.*;
@Entity

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("DmdEmp")

public class DmdEmp extends Client{
    @NotNull(message = "Le Nom est obligatoire")
    private String nom;
    @NotNull(message = "Le prenom est obligatoire")
    private String prenom;
    private String experience;
    private String nomEntreExp;
    private String fonction;
    private String cv;
    private String lettreMotivation;
    private String motivation;
    private String filiere;
    private String diplome;
    private int nbrAnneeExperiences;
    private double salaireSouhaite;

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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getNomEntreExp() {
        return nomEntreExp;
    }

    public void setNomEntreExp(String nomEntreExp) {
        this.nomEntreExp = nomEntreExp;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLettreMotivation() {
        return lettreMotivation;
    }

    public void setLettreMotivation(String lettreMotivation) {
        this.lettreMotivation = lettreMotivation;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public int getNbrAnneeExperiences() {
        return nbrAnneeExperiences;
    }

    public void setNbrAnneeExperiences(int nbrAnneeExperiences) {
        this.nbrAnneeExperiences = nbrAnneeExperiences;
    }

    public double getSalaireSouhaite() {
        return salaireSouhaite;
    }

    public void setSalaireSouhaite(double salaireSouhaite) {
        this.salaireSouhaite = salaireSouhaite;
    }
}
