package com.workify.agence_recrut.entites;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Edition {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEdition;
    private int numEdition;
    private Date dateParrution;

}
