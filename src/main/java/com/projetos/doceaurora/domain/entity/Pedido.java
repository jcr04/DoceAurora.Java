package com.projetos.doceaurora.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "preco_total")
    private double precoTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "status")
    private String status;

    public Pedido() {
        this.precoTotal = precoTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getters e Setters
}
