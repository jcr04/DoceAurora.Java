package com.projetos.doceaurora.application.controller.pedidos;

import com.projetos.doceaurora.domain.dto.PedidoDTO;
import com.projetos.doceaurora.domain.entity.Pedido;
import com.projetos.doceaurora.domain.service.pedidos.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodos() {
        List<Pedido> pedidos = pedidoService.listarTodosOsPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        Pedido pedido = pedidoService.buscarPedidoPorId(id);
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> criar(@Valid @RequestBody PedidoDTO pedidoDTO) {
        Pedido novoPedido = pedidoService.criarPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @Valid @RequestBody PedidoDTO pedidoDTO) {
        Pedido pedidoAtualizado = pedidoService.atualizarPedido(id, pedidoDTO);
        return ResponseEntity.ok(pedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

}
