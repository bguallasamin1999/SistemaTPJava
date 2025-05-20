package com.textilpadilla.sistemaTp.Modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedidoDetalle;
    private String producto;
    private int cantidad;
    private double precio;
    @ManyToOne
    @JoinColumn(name = "pedido_id",nullable = false)
    private Pedido pedido;
}
