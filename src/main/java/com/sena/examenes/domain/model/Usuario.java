package com.sena.examenes.domain.model;

public class Usuario {
    private String username;
    private String email;
    private boolean activo;
    public Usuario(String username, String email) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("El username no puede estar vacio.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacio.");
        }
        this.username = username;
        this.email = email;
        this.activo = true;
    }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public boolean isActivo() { return activo; }
    public void desactivar() {
        this.activo = false;
    }
}

