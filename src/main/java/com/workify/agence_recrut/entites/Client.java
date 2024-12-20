package com.workify.agence_recrut.entites;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Client extends Users {


    private String adresse;
    private String telephone;
    private String email;
    private String password;
    private String photo;
    private String ville;

}
