package com.sena.examenes.application.service;

import com.sena.examenes.application.port.in.UsuarioUseCase;
import com.sena.examenes.application.port.out.UsuarioRepositoryPort;
import com.sena.examenes.domain.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class UsuarioService implements UsuarioUseCase {
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    private final List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario registrar(String username, String email) {
        if (usuarioRepositoryPort.existePorUsername(username)) {
            throw new IllegalStateException("Ya existe un usuario con ese username.");
        }
        Usuario nuevo = new Usuario(username, email);
        return usuarioRepositoryPort.guardar(nuevo);
    }

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarioRepositoryPort.buscarPorUsername(username);
    }

    @Override
    public List<Usuario> listarActivos() {
        return usuarioRepositoryPort.listarActivos();
    }
}

/**   @Override
public void desactivarUsuario(String username) {
Usuario usuario = buscarPorUsername(username)
.orElseThrow(() -> new IllegalArgumentException("No se encontró el usuario con username: " + username));

usuario.desactivar();
}

public int contarUsuarios(){
return usuarios.size();
} */