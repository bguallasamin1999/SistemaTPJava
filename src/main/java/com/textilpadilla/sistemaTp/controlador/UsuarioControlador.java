package com.textilpadilla.sistemaTp.controlador;

import com.textilpadilla.sistemaTp.Modelo.Usuario;
import com.textilpadilla.sistemaTp.Servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {
    @Autowired
    private IUsuarioServicio servicioUsuario;

    @GetMapping
    public String mostrarUsuarios(Model model) {
        model.addAttribute("usuarios",servicioUsuario.listarUsuarios());
        return "usuarios/listar";
    }

    @GetMapping("/nuevo")
    public String nuevoUsuario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuarios/formulario";
    }

    @PostMapping("/guardar")
    public String guardaUsuario(@ModelAttribute("usuario") Usuario usuario) {
        servicioUsuario.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") int id, Model model) {
        Usuario usuario = servicioUsuario.buscarPorId(id);
        model.addAttribute("usuario", usuario);
        return "usuarios/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminaUsuario(@PathVariable("id") int id) {
        Usuario usuario = servicioUsuario.buscarPorId(id);
        servicioUsuario.eliminarUsuario(usuario);
        return "redirect:/usuarios";
    }
}
