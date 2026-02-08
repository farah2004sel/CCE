package com.example.CCE_backend.service;

import com.example.CCE_backend.entity.Commercant;
import com.example.CCE_backend.repository.CommercantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class commercantService {

    @Autowired
    private CommercantRepository repository;

    // =========================
    // تسجيل جديد (Signup)
    // =========================
    public Commercant signup(Commercant commercant) {
        // تحقق إذا username موجود
        Commercant existing = repository.findByUsername(commercant.getUsername());
        if (existing != null) {
            throw new RuntimeException("Username already exists");
        }
        return repository.save(commercant);
    }

    // =========================
    // تسجيل دخول (Login)
    // =========================
    public Optional<Commercant> login(String username, String password) {
        Commercant commercant = repository.findByUsername(username);
        if (commercant != null && commercant.getPassword().equals(password)) {
            return Optional.of(commercant);
        }
        return Optional.empty();
    }

    // =========================
    // جلب كل التجار (Get all)
    // =========================
    public Iterable<Commercant> getAll() {
        return repository.findAll();
    }
}
