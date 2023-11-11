package com.projetos.doceaurora.infra.exeptions.produtos;

public class ProdutoStockException extends RuntimeException {

    public ProdutoStockException(Long id) {
        super("Estoque insuficiente para o produto com ID: " + id);
    }
}

