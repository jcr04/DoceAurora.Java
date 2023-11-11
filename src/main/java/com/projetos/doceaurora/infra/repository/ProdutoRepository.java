package com.projetos.doceaurora.infra.repository;

import com.projetos.doceaurora.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Encontra um produto pelo ID
    Optional<Produto> findById(Long id);

    // Encontra produtos pelo nome
    List<Produto> findByNomeContaining(String nome);

    // Encontra produtos dentro de uma faixa de preço
    List<Produto> findByPrecoBetween(double min, double max);
}
