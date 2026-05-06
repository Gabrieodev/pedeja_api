package com.pedeja.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pedeja.api.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}