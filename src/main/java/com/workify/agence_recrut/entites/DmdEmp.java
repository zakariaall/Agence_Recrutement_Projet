package com.workify.agence_recrut.entites;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("DmdEmp")


public class DmdEmp extends Client{

    private String nom;
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



}
