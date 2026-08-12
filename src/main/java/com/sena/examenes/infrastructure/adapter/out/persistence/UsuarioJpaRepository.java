package com.sena.examenes.infrastructure.adapter.out.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByUsernameIgnoreCase(String username);
    List<UsuarioEntity> findByActivoTrue();
    boolean existsByUsernameIgnoreCase(String username);
}
