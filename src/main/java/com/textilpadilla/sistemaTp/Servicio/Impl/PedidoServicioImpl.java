package com.textilpadilla.sistemaTp.Servicio.Impl;

import com.textilpadilla.sistemaTp.Modelo.Pedido;
import com.textilpadilla.sistemaTp.Repositorio.IPedidoRepositorio;
import com.textilpadilla.sistemaTp.Servicio.IPedidoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServicioImpl implements IPedidoServicio {

    private final IPedidoRepositorio repositorioPedido;

    @Override
    public Pedido insertarPedido(Pedido nuevoPedido) {
        try {
            repositorioPedido.save(nuevoPedido); // JPA guarda en cascada si está bien configurado
        } catch (Exception e) {
            System.out.println("Error al insertar pedido" + e.getMessage());
        }

        return nuevoPedido;
    }

    @Override
    public Pedido modificarPedido(Pedido actualizaPedido) {
        try {
            repositorioPedido.save(actualizaPedido);
        } catch (Exception e) {
            System.out.println("Error al modificar pedido" + e.getMessage());
        }
        return actualizaPedido;
    }

    @Override
    public void eliminarPedido(int id) {
        try {
            repositorioPedido.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar pedido" + e.getMessage());
        }
    }

    @Override
    public List<Pedido> listarPedidos() {
        try {
            return repositorioPedido.findAll();

        } catch (Exception e) {
            System.out.println("Error al listar pedidos" + e.getMessage());
        }
        return List.of();
    }
}
