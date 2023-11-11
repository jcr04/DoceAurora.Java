package com.projetos.doceaurora.domain.entity;

import jakarta.persistence.*;

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

    // Getters e Setters
}
