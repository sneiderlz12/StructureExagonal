package com.sena.examenes.application.service;

import com.sena.examenes.application.port.in.UsuarioUseCase;
import com.sena.examenes.domain.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class UsuarioService implements UsuarioUseCase {
    private final List<Usuario> usuarios = new ArrayList<>();
    @Override
    public Usuario registrar(String username, String email) {
        boolean existe = usuarios.stream()
                .anyMatch(u -> u.getUsername().equalsIgnoreCase(username));
        if (existe) {
            throw new IllegalStateException("Ya existe un usuario con ese username.");
        }
        Usuario nuevo = new Usuario(username, email);
        usuarios.add(nuevo);
        return nuevo;
    }
    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarios.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }
    @Override
    public List<Usuario> listarActivos() {
        return usuarios.stream()
                .filter(Usuario::isActivo)
                .toList();
    }

    @Override
    public void desactivarUsuario(String username) {
        Usuario usuario = buscarPorUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el usuario con username: " + username));

        usuario.desactivar();
    }

    public int contarUsuarios() {
        return usuarios.size();
    }


}

