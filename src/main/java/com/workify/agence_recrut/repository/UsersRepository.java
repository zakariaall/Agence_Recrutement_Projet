package com.workify.agence_recrut.repository;
import com.workify.agence_recrut.entites.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    boolean existsByEmail(String email);
    Users findByEmail(String email);

}
