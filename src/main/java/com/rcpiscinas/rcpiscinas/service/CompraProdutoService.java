package com.rcpiscinas.rcpiscinas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcpiscinas.rcpiscinas.entidade.Compra;
import com.rcpiscinas.rcpiscinas.entidade.CompraProduto;
import com.rcpiscinas.rcpiscinas.entidade.Produto;
import com.rcpiscinas.rcpiscinas.repository.CompraProdutoRepository;
import com.rcpiscinas.rcpiscinas.repository.CompraRepository;
import com.rcpiscinas.rcpiscinas.repository.ProdutoRepository;
import com.rcpiscinas.rcpiscinas.repository.UsuarioRepository;

@Service
public class CompraProdutoService {

    @Autowired
    private CompraProdutoRepository compraProdutoRepository;

    @Autowired
    private CompraRepository compraRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<CompraProduto> criarCompraEProdutos(List<CompraProduto> produtos) {
        Compra compra = new Compra();
        compra.setUsuario(usuarioRepository.findById(1L).orElseThrow(() -> new RuntimeException("Usuário não encontrado")));
        compra.setDataCompra(new Date());
        compra.setDataInicio(new Date());
        compra.setStatusCompra("aguardando confirmação");
        Compra compraSalva = compraRepository.save(compra);

        List<CompraProduto> produtosSalvos = new ArrayList<>();

        for (CompraProduto cp : produtos) {
            cp.setCompra(compraSalva);

            Produto produto = produtoRepository.findById(cp.getProduto().getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado com id " + cp.getProduto().getId()));
            cp.setProduto(produto);

            CompraProduto salvo = compraProdutoRepository.save(cp);
            produtosSalvos.add(salvo);
        }

        return produtosSalvos; // Retorna a lista já salva, sem buscar de novo no banco
    }

    public List<CompraProduto> listarPorCompra(Long compraId) {
        return compraProdutoRepository.findByCompraId(compraId);
    }

    public CompraProduto atualizarProduto(Long id, CompraProduto compraProdutoAtualizado) {
        CompraProduto existente = compraProdutoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto da compra não encontrado com id " + id));

        Produto produto = produtoRepository.findById(compraProdutoAtualizado.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id " + compraProdutoAtualizado.getProduto().getId()));

        existente.setProduto(produto);
        existente.setQuantidade(compraProdutoAtualizado.getQuantidade());
        existente.setValorUnitario(compraProdutoAtualizado.getValorUnitario());

        return compraProdutoRepository.save(existente);
    }

    public void deletarProduto(Long id) {
        CompraProduto compraProduto = compraProdutoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CompraProduto não encontrado com id " + id));

        compraProdutoRepository.delete(compraProduto);
    }
}

