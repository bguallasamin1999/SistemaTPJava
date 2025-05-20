package com.textilpadilla.sistemaTp.Servicio;

import com.textilpadilla.sistemaTp.Modelo.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUsuarioServicio extends UserDetailsService {


    Usuario guardarUsuario(Usuario usuario);

    Optional<Usuario> findByUsername(String username);

    List<Usuario> listarUsuarios();

    Usuario buscarPorId(int id);

    void eliminarUsuario(Usuario usuario);
}
