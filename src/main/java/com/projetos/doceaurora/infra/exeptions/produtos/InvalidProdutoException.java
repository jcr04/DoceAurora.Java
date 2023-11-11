package com.projetos.doceaurora.infra.exeptions.produtos;

public class InvalidProdutoException extends RuntimeException {

    public InvalidProdutoException(String message) {
        super("Dados inválidos para o produto: " + message);
    }
}