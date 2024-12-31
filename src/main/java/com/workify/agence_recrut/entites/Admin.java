package com.workify.agence_recrut.entites;

import jakarta.persistence.*;
import lombok.*;
@Entity
@AllArgsConstructor
@DiscriminatorValue("Admin")


public class Admin extends Users {


}
