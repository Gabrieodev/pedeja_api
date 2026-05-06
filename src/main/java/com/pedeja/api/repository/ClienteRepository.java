package com.pedeja.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pedeja.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
