package com.projetos.doceaurora.infra.repository;

import com.projetos.doceaurora.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Encontra pedidos por ID do cliente
    List<Pedido> findByClienteId(Long clienteId);

    // Encontra um pedido pelo ID
    Optional<Pedido> findById(Long id);

    // Encontra pedidos dentro de um intervalo de datas
    List<Pedido> findByDataPedidoBetween(Date dataInicio, Date dataFim);

    // Encontra pedidos por status
    List<Pedido> findByStatus(String status);
}
