package com.textilpadilla.sistemaTp.controlador;

import com.textilpadilla.sistemaTp.Modelo.Pedido;
import com.textilpadilla.sistemaTp.Servicio.Impl.PedidoServicioImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PedidoControlador {
    private final PedidoServicioImpl pedidoServicio;

    @GetMapping
    public List<Pedido> obtenerPedidos(){
        return pedidoServicio.listarPedidos();
    }
    @PostMapping
    public Pedido guardarPedido(@RequestBody Pedido pedido){
        return pedidoServicio.insertarPedido(pedido);
    }

    @PutMapping("/{idPedido}")
    public Pedido editarPedido(@RequestBody Pedido pedido){
        return pedidoServicio.modificarPedido(pedido);
    }
    @DeleteMapping("/{idPedido}")
    public void eliminarPedido(@PathVariable("idPedido") int idPedido){
        pedidoServicio.eliminarPedido(idPedido);
    }

}
