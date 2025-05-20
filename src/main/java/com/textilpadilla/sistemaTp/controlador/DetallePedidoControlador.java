package com.textilpadilla.sistemaTp.controlador;

import com.textilpadilla.sistemaTp.Modelo.DetallePedido;
import com.textilpadilla.sistemaTp.Servicio.Impl.DetallePedidoServicioImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallePedidos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DetallePedidoControlador {
    private final DetallePedidoServicioImpl servicioDetallePedido;

    @GetMapping
    public List<DetallePedido> obtenerDetallePedidos() {
        return servicioDetallePedido.listarDetallePedido();
    }

    @PostMapping
    public DetallePedido guardarDetallePedido(@RequestBody DetallePedido detallePedido) {
        return servicioDetallePedido.insertarDetallePedido(detallePedido);
    }

    @PutMapping("/{idDetallePedido}")
    public DetallePedido actualizarDetallePedido(@RequestBody DetallePedido detallePedido) {
        return servicioDetallePedido.editarDetallePedido(detallePedido);
    }

    @DeleteMapping("/{idDetallePedido}")
    public void deleteDetallePedido(@PathVariable int idDetallePedido) {
        servicioDetallePedido.eliminarDetallePedido(idDetallePedido);
    }
}
