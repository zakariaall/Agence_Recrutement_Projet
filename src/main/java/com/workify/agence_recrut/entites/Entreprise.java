package com.workify.agence_recrut.entites;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("Entreprise")

public class Entreprise extends Client {

    private String nomEntreprise;
    private String raisonSocial;
    private String description;

}
