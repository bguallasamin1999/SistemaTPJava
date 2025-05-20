package com.textilpadilla.sistemaTp.Repositorio;

import com.textilpadilla.sistemaTp.Modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepositorio extends JpaRepository<Pedido, Integer> {
}
