package com.workify.agence_recrut.entites;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@DiscriminatorValue("Admin")

public class Admin extends Users {


}
