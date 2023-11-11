package com.projetos.doceaurora.infra.exeptions.clientes;

public class ClienteNotFoundException extends RuntimeException {

    public ClienteNotFoundException(Long id) {
        super("Cliente não encontrado com ID: " + id);
    }

    public ClienteNotFoundException(String email) {
        super("Cliente não encontrado com e-mail: " + email);
    }
}
