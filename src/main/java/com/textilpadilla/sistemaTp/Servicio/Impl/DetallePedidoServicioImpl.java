package com.textilpadilla.sistemaTp.Servicio.Impl;

import com.textilpadilla.sistemaTp.Modelo.DetallePedido;
import com.textilpadilla.sistemaTp.Repositorio.IDetallePedidoRepositorio;
import com.textilpadilla.sistemaTp.Servicio.IDetallePedidoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetallePedidoServicioImpl implements IDetallePedidoServicio {
    private final IDetallePedidoRepositorio repositorioDetallePedido;

    @Override
    public DetallePedido insertarDetallePedido(DetallePedido nuevoDetallePedido) {
        try {
            repositorioDetallePedido.save(nuevoDetallePedido);
        } catch (Exception e) {
            System.out.println("Error al insertar el detalle pedido" + e.getMessage());
        }
        return nuevoDetallePedido;
    }

    @Override
    public DetallePedido editarDetallePedido(DetallePedido actualizaDetallePedido) {
        try {
            repositorioDetallePedido.save(actualizaDetallePedido);
        } catch (Exception e) {
            System.out.println("Error al editar el detalle pedido" + e.getMessage());
        }

        return actualizaDetallePedido;
    }

    @Override
    public void eliminarDetallePedido(int id) {
        try {
            repositorioDetallePedido.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar el detalle pedido" + e.getMessage());
        }
    }

    @Override
    public List<DetallePedido> listarDetallePedido() {
        try {
            return repositorioDetallePedido.findAll();
        } catch (Exception e) {
            System.out.println("Error al listar el detalle pedido" + e.getMessage());
        }
        return List.of();
    }
}
