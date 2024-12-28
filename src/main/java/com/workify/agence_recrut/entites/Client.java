package com.workify.agence_recrut.entites;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Client")

public class Client extends Users {


    private String adresse;
    @NotNull(message = "Numero de telephone est obligatoire")
    @Column(unique = true)
    private String telephone;
    private String photo;
    private String ville;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
