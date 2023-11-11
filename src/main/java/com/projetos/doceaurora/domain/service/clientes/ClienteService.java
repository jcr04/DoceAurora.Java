package com.projetos.doceaurora.domain.service.clientes;

import com.projetos.doceaurora.domain.dto.ClienteDTO;
import com.projetos.doceaurora.domain.entity.Cliente;
import com.projetos.doceaurora.infra.repository.ClienteRepository;
import com.projetos.doceaurora.infra.exeptions.clientes.ClienteNotFoundException;
import com.projetos.doceaurora.infra.exeptions.clientes.ClienteEmailAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Cliente> listarTodosOsClientes() {
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente criarCliente(ClienteDTO clienteDTO) {
        verificarSeEmailExiste(clienteDTO.getEmail());
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setNotaEspecial(clienteDTO.getNotaEspecial());
        return clienteRepository.save(cliente);
    }



    @Transactional
    public Cliente atualizarCliente(Long id, ClienteDTO clienteDTO) {
        Cliente clienteExistente = buscarClientePorId(id);
        // Atualizar dados do clienteExistente com base em clienteDTO
        return clienteRepository.save(clienteExistente);
    }

    @Transactional
    public void deletarCliente(Long id) {
        buscarClientePorId(id);
        clienteRepository.deleteById(id);
    }

    private void verificarSeEmailExiste(String email) {
        clienteRepository.findByEmail(email).ifPresent(c -> {
            throw new ClienteEmailAlreadyExistsException(email);
        });
    }

}
