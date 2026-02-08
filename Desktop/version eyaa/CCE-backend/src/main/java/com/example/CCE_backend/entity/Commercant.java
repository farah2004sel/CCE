package com.example.CCE_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "commercant")
public class Commercant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;  // ✅ حقل جديد

    @Column(nullable = false)
    private String password;

    @Column(name = "nom_societe")
    private String nomSociete;

    private String nationalite;


    // ========================
    // Getters and Setters
    // ========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {   // ✅ Getter الجديد
        return username;
    }

    public void setUsername(String username) {  // ✅ Setter الجديد
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }



}
