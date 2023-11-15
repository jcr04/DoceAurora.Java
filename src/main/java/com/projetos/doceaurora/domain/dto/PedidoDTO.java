package com.projetos.doceaurora.domain.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PedidoDTO {
    private Long idProduto;
    private int quantidade;
    private List<Long> idsProdutos;
    private double precoTotal;
    @Getter
    private Long clienteId;
    @Getter
    private String status;

    public PedidoDTO(Long idProduto, int quantidade, List<Long> idsProdutos, double precoTotal, Long clienteId, String status) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.idsProdutos = idsProdutos;
        this.precoTotal = precoTotal;
        this.clienteId = clienteId;
        this.status = status;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setIdsProdutos(List<Long> idsProdutos) {
        this.idsProdutos = idsProdutos;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getters e Setters
}
