package com.workify.agence_recrut.repository;

import com.workify.agence_recrut.entites.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal,Long> {
    Journal findByNom(String nom);
}
