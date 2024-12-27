package com.workify.agence_recrut.entites;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)

public class Users {
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY )
    protected long userId;
    @NotNull(message = "Le rôle est obligatoire")
    @Enumerated(EnumType.STRING)
    protected Roles roles;
    @NotNull(message = "L'email est obligatoire")
    @Email(message = "Veuillez fournir une adresse email valide")
    @Column(unique = true)
    private String email;
    @NotNull(message = "Le mot de passe est obligatoire")
    @Size(min = 6, message = "Le mot de passe doit comporter au moins 6 caractères")
    private String password;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
