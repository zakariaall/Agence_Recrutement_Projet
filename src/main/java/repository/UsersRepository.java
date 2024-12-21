package repository;
import com.workify.agence_recrut.entites.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    boolean existsByEmail(String email);
    Users findByEmail(String email);

}
