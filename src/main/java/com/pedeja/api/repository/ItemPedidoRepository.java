package com.pedeja.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pedeja.api.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}