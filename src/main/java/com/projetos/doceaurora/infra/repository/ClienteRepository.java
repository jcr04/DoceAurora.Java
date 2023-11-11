package com.projetos.doceaurora.infra.repository;

import com.projetos.doceaurora.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findById(Long id);

    List<Cliente> findByNome(String nome);

    Optional<Cliente> findByEmail(String email);
}
