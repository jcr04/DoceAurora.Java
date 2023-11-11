package com.projetos.doceaurora.infra.exeptions.pedidos;

public class InvalidPedidoException extends RuntimeException {

    public InvalidPedidoException(String message) {
        super("Dados inválidos para o pedido: " + message);
    }
}