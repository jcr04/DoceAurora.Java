package com.projetos.doceaurora.infra.exeptions.pedidos;

public class PedidoStatusException extends RuntimeException {

    public PedidoStatusException(String message) {
        super("Alteração de status inválida para o pedido: " + message);
    }
}
