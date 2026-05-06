package com.pedeja.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pedeja.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
