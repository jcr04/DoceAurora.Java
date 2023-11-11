package com.projetos.doceaurora.infra.exeptions.pedidos;

public class PedidoNotFoundException extends RuntimeException {

    public PedidoNotFoundException(Long id) {
        super("Pedido não encontrado com ID: " + id);
    }
}