package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.workify.agence_recrut.entites.*;
import org.springframework.stereotype.Repository;


@Repository

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
    boolean existsByEmail(String email);
    Entreprise findByEmail(String email);
}
