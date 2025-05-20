package com.textilpadilla.sistemaTp.Servicio;

import com.textilpadilla.sistemaTp.Modelo.DetallePedido;

import java.util.List;

public interface IDetallePedidoServicio {
    public DetallePedido insertarDetallePedido(DetallePedido nuevoDetallePedido);

    public DetallePedido editarDetallePedido(DetallePedido actualizaDetallePedido);

    public void eliminarDetallePedido(int id);

    public List<DetallePedido> listarDetallePedido();
}
