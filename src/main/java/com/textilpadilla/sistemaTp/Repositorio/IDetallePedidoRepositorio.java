package com.textilpadilla.sistemaTp.Repositorio;

import com.textilpadilla.sistemaTp.Modelo.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetallePedidoRepositorio extends JpaRepository<DetallePedido, Integer> {
}
