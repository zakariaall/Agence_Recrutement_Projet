package com.workify.agence_recrut.entites;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor

@DiscriminatorValue("Client")

public class Client extends Users {


    private String adresse;
    private String telephone;
    private String photo;
    private String ville;

}
