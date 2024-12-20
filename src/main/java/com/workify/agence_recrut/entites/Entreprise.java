package com.workify.agence_recrut.entites;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("Entreprise")

public class Entreprise extends Users {

    private String nomEntreprise;
    private String raisonSocial;
    private String description;

}
