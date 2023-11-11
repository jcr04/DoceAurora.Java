package com.projetos.doceaurora.domain.service.pedidos;

import com.projetos.doceaurora.domain.dto.PedidoDTO;
import com.projetos.doceaurora.domain.entity.Pedido;
import com.projetos.doceaurora.infra.repository.PedidoRepository;
import com.projetos.doceaurora.infra.exeptions.pedidos.PedidoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional(readOnly = true)
    public Pedido buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Pedido> listarTodosOsPedidos() {
        return pedidoRepository.findAll();
    }

    @Transactional
    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public Pedido atualizarPedido(Long id, PedidoDTO pedidoDTO) {
        Pedido pedidoExistente = buscarPedidoPorId(id);
        return pedidoRepository.save(pedidoExistente);
    }

    @Transactional
    public void deletarPedido(Long id) {
        buscarPedidoPorId(id);
        pedidoRepository.deleteById(id);
    }



}
