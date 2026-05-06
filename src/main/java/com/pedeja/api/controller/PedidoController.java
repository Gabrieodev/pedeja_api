package com.pedeja.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pedeja.api.model.Pedido;
import com.pedeja.api.model.Cliente;
import com.pedeja.api.repository.PedidoRepository;
import com.pedeja.api.repository.ClienteRepository;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    // 🔹 GET
    @GetMapping
    public List<Pedido> listar() {
        return repository.findAll();
    }

    // 🔹 POST (CORRIGIDO)
    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido) {

        if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
            throw new RuntimeException("Cliente ID não informado");
        }

        Long clienteId = pedido.getCliente().getId();

        System.out.println("ID recebido: " + clienteId); // DEBUG

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        pedido.setCliente(cliente);

        return repository.save(pedido);
    }
}