package com.example.CCE_backend.repository;

import com.example.CCE_backend.entity.Commercant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommercantRepository extends JpaRepository<Commercant, Integer> {
    // باش تلقى commercant حسب username
    Commercant findByUsername(String username);
    Commercant findByEmail(String email);
}
