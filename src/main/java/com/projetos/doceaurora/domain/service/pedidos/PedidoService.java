package com.projetos.doceaurora.domain.service.pedidos;

import com.projetos.doceaurora.domain.dto.PedidoDTO;
import com.projetos.doceaurora.domain.entity.Cliente;
import com.projetos.doceaurora.domain.entity.Pedido;
import com.projetos.doceaurora.domain.entity.Produto;
import com.projetos.doceaurora.infra.exeptions.clientes.ClienteNotFoundException;
import com.projetos.doceaurora.infra.exeptions.produtos.ProdutoNotFoundException;
import com.projetos.doceaurora.infra.repository.ClienteRepository;
import com.projetos.doceaurora.infra.repository.PedidoRepository;
import com.projetos.doceaurora.infra.exeptions.pedidos.PedidoNotFoundException;
import com.projetos.doceaurora.infra.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
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
        Produto produto = produtoRepository.findById(pedidoDTO.getIdProduto())
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado com ID: " + pedidoDTO.getIdProduto()));

        Cliente cliente = clienteRepository.findById(pedidoDTO.getClienteId())
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado com ID: " + pedidoDTO.getClienteId()));

        Pedido pedido = new Pedido();
        pedido.setIdProduto(pedidoDTO.getIdProduto());
        pedido.setQuantidade(pedidoDTO.getQuantidade());
        pedido.setPrecoTotal(produto.getPreco() * pedidoDTO.getQuantidade());
        pedido.setCliente(cliente);
        pedido.setStatus(pedidoDTO.getStatus());

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
