package com.workify.agence_recrut.entites;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Entreprise")

public class Entreprise extends Client {

    @NotNull(message = "Le rôle est obligatoire")
    private String nomEntreprise;
    private String raisonSocial;
    private String description;
    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
