package com.sena.examenes.infrastructure.adapter.out.persistence;
import com.sena.examenes.domain.model.Usuario;
import org.springframework.stereotype.Component;
@Component
public class UsuarioMapper {
    public UsuarioEntity aEntity(Usuario usuario) {
        return new UsuarioEntity(null, usuario.getUsername(), usuario.getEmail(),
                usuario.isActivo());
    }
    public Usuario aDominio(UsuarioEntity entity) {
        Usuario usuario = new Usuario(entity.getUsername(), entity.getEmail());
        if (!entity.isActivo()) {
            usuario.desactivar();
        }
        return usuario;
    }
}