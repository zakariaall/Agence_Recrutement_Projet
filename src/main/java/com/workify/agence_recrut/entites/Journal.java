package com.workify.agence_recrut.entites;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Journal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    private String nom;
    private String libelle;
    private String Langues;
    private String imageJournal;
    private String periodicite;


}
