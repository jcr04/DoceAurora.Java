package com.projetos.doceaurora.infra.exeptions.produtos;

public class ProdutoNotFoundException extends RuntimeException {

    public ProdutoNotFoundException(Long id) {
        super("Produto não encontrado com ID: " + id);
    }

    public ProdutoNotFoundException(String nome) {
        super("Produto não encontrado com o nome: " + nome);
    }
}
