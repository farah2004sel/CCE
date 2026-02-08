package com.example.CCE_backend.controller;

import com.example.CCE_backend.entity.Commercant;
import com.example.CCE_backend.repository.CommercantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commercants")
@CrossOrigin(origins = "http://localhost:4200")
public class CommercantController {

    private final CommercantRepository commercantRepository;

    public CommercantController(CommercantRepository commercantRepository) {
        this.commercantRepository = commercantRepository;
    }

    // =========================
    // Register
    // =========================
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Commercant commercant) {

        // تحقق إذا البريد فارغ
        if (commercant.getEmail() == null || commercant.getEmail().isEmpty()) {
            return new ResponseEntity<>("Email is required", HttpStatus.BAD_REQUEST);
        }

        // تحقق إذا البريد موجود مسبقًا
        Commercant existing = commercantRepository.findByEmail(commercant.getEmail());
        if (existing != null) {
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }

        Commercant saved = commercantRepository.save(commercant);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // =========================
    // Login
    // =========================
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Commercant commercant) {

        if (commercant.getEmail() == null || commercant.getPassword() == null) {
            return new ResponseEntity<>("Email and password are required", HttpStatus.BAD_REQUEST);
        }

        Commercant user = commercantRepository.findByEmail(commercant.getEmail());

        if (user != null && user.getPassword().equals(commercant.getPassword())) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }
    }

    // =========================
    // Get all commercants
    // =========================
    @GetMapping
    public ResponseEntity<List<Commercant>> getAll() {
        List<Commercant> list = commercantRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
