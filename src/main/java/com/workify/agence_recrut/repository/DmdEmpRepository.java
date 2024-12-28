package com.workify.agence_recrut.repository;

import com.workify.agence_recrut.entites.DmdEmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DmdEmpRepository extends JpaRepository<DmdEmp, Long> {

    boolean existsByEmail(String email);
    DmdEmp findByEmail(String email);
}
