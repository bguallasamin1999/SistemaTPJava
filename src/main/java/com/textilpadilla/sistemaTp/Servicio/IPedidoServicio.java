package com.textilpadilla.sistemaTp.Servicio;

import com.textilpadilla.sistemaTp.Modelo.Pedido;

import java.util.List;

public interface IPedidoServicio {
    public Pedido insertarPedido(Pedido nuevoPedido);

    public Pedido modificarPedido(Pedido actualizaPedido);

    public void eliminarPedido(int id);

    public List<Pedido> listarPedidos();
}
