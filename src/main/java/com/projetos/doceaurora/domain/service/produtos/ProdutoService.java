package com.projetos.doceaurora.domain.service.produtos;

import com.projetos.doceaurora.domain.dto.ProdutoDTO;
import com.projetos.doceaurora.domain.entity.Produto;
import com.projetos.doceaurora.infra.repository.ProdutoRepository;
import com.projetos.doceaurora.infra.exeptions.produtos.ProdutoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional(readOnly = true)
    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public List<Produto> listarTodosOsProdutos() {
        return produtoRepository.findAll();
    }

    @Transactional
    public Produto criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Produto produtoExistente = buscarProdutoPorId(id);
        return produtoRepository.save(produtoExistente);
    }

    @Transactional
    public void deletarProduto(Long id) {
        buscarProdutoPorId(id);
        produtoRepository.deleteById(id);
    }

}
