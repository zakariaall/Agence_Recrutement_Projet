package repository;

import com.workify.agence_recrut.entites.DmdEmp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DmdEmpRepository extends JpaRepository<DmdEmp, Long> {

    boolean existsByEmail(String email);
    DmdEmp findByEmail(String email);
}
