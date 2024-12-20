package com.workify.agence_recrut.entites;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Users {
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY )
    protected long userId;
    protected Roles roles;
}
