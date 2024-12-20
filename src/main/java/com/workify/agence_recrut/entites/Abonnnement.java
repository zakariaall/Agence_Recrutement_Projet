package com.workify.agence_recrut.entites;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Abonnnement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idAbonnement;
    private Date dateDebut;
    private Date dateExpiration;
    private boolean etat;




}
