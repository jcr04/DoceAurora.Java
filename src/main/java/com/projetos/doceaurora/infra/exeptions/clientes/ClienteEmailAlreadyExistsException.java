package com.projetos.doceaurora.infra.exeptions.clientes;

public class ClienteEmailAlreadyExistsException extends RuntimeException {

    public ClienteEmailAlreadyExistsException(String email) {
        super("Já existe um cliente com o e-mail: " + email);
    }
}
