package com.sena.examenes;

import com.sena.examenes.application.port.in.UsuarioUseCase;
import com.sena.examenes.application.service.UsuarioService;
import com.sena.examenes.domain.model.Usuario;
public class MainUsuarios {
    public static void main(String[] args) {
        UsuarioUseCase usuarioUseCase = new UsuarioService();
        usuarioUseCase.contarUsuarios();
        usuarioUseCase.registrar("cbarrientos", "cbarrientos@sena.edu.co");
        usuarioUseCase.registrar("lgomez", "lgomez@sena.edu.co");
        System.out.println("--- ESTADO INICIAL ---");
        System.out.println("Usuarios activos: " + usuarioUseCase.listarActivos().size()); // Imprime: 2

        // 2. Probar desactivación de un usuario existente
        System.out.println("\n--- DESACTIVANDO USUARIO 'lgomez' ---");
        usuarioUseCase.desactivarUsuario("lgomez");

        System.out.println("Usuarios activos tras desactivar: " + usuarioUseCase.listarActivos().size()); // Imprime: 1

        try {
            usuarioUseCase.registrar("cbarrientos", "otro@correo.com");
        } catch (IllegalStateException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        usuarioUseCase.buscarPorUsername("lgomez")
                .ifPresent(u -> System.out.println("Encontrado: " + u.getEmail()));
        int totalActivos = usuarioUseCase.listarActivos().size();
        System.out.println("Usuarios activos: " + totalActivos);


    }
}
