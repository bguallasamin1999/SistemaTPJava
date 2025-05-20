package com.textilpadilla.sistemaTp.Servicio.Impl;

import com.textilpadilla.sistemaTp.Modelo.Usuario;
import com.textilpadilla.sistemaTp.Repositorio.IUsuarioRepositorio;
import com.textilpadilla.sistemaTp.Servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {
    @Autowired
    private IUsuarioRepositorio repositorioUsuario;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario guardarUsuario(Usuario usuario) {
        if (usuario.getIdUsuario() == null || !usuario.getPassword().isEmpty()) {
            // Encriptar la contraseña solo si es nueva o fue modificada
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        } else {
            // Si está en blanco (en edición), cargar la contraseña anterior desde DB
            Usuario existente = repositorioUsuario.findById(usuario.getIdUsuario()).orElseThrow();
            usuario.setPassword(existente.getPassword());
        }

        return repositorioUsuario.save(usuario);
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public List<Usuario> listarUsuarios() {
        try {
            return repositorioUsuario.findAll();
        } catch (Exception e) {
            return Collections.emptyList();
        }

    }

    @Override
    public Usuario buscarPorId(int id) {
        try {
            return repositorioUsuario.findById(id).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        try {
            repositorioUsuario.delete(usuario);
        } catch (Exception e) {
            System.out.println("Error al eliminar el usuario" + e.getMessage());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repositorioUsuario.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new User(
                usuario.getUsername(),
                usuario.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + usuario.getRole()))
        );
    }
}
