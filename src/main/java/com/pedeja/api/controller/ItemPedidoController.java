package com.pedeja.api.controller;

import com.pedeja.api.model.ItemPedido;
import com.pedeja.api.model.Pedido;
import com.pedeja.api.model.Produto;
import com.pedeja.api.repository.ItemPedidoRepository;
import com.pedeja.api.repository.PedidoRepository;
import com.pedeja.api.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository repository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<ItemPedido> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ItemPedido salvar(@RequestBody ItemPedido itemPedido) {

        // BUSCA pedido REAL no banco
        Pedido pedido = pedidoRepository.findById(
                itemPedido.getPedido().getId()
        ).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        // BUSCA produto REAL no banco
        Produto produto = produtoRepository.findById(
                itemPedido.getProduto().getId()
        ).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // SETA objetos completos
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        // CALCULA subtotal automaticamente
        Double subtotal = produto.getPreco() * itemPedido.getQuantidade();

        itemPedido.setSubtotal(subtotal);

        // SE total estiver null, inicia com 0
        if (pedido.getTotal() == null) {
            pedido.setTotal(0.0);
        }

        // SOMA subtotal ao total do pedido
        pedido.setTotal(pedido.getTotal() + subtotal);

        // SALVA pedido atualizado
        pedidoRepository.save(pedido);

        // SALVA item pedido
        return repository.save(itemPedido);
    }
}