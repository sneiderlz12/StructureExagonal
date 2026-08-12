package com.sena.examenes.infrastructure.adapter.out.persistence;

import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.model.Usuario;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {
    private final UsuarioJpaRepository jpaRepository;
    private final UsuarioMapper mapper;
    public UsuarioRepositoryAdapter(UsuarioJpaRepository jpaRepository,
                                    UsuarioMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }
    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity entity = mapper.aEntity(usuario);
        UsuarioEntity guardado = jpaRepository.save(entity);
        return mapper.aDominio(guardado);
    }
    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return jpaRepository.findByUsernameIgnoreCase(username)
                .map(mapper::aDominio);
    }
    @Override
    public List<Usuario> listarActivos() {
        return jpaRepository.findByActivoTrue().stream()
                .map(mapper::aDominio)
                .toList();
    }
    @Override
    public boolean existePorUsername(String username) {
        return jpaRepository.existsByUsernameIgnoreCase(username);
    }
}