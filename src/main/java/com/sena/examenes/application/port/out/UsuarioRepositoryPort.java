package com.sena.examenes.application.port.out;
import com.sena.examenes.domain.model.Usuario;
import java.util.List;
import java.util.Optional;
public interface UsuarioRepositoryPort {
    Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPorUsername(String username);
    List<Usuario> listarActivos();
    boolean existePorUsername(String username);
}