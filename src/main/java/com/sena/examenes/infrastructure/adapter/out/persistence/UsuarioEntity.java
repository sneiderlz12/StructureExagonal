package com.sena.examenes.infrastructure.adapter.out.persistence;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private boolean activo;
    public UsuarioEntity() {
// Constructor vacio: lo exige Hibernate para reconstruir objetos
    }
    public UsuarioEntity(Long id, String username, String email, boolean activo) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.activo = activo;
    }
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public boolean isActivo() { return activo; }
}