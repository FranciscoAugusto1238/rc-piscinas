package com.rcpiscinas.rcpiscinas.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcpiscinas.rcpiscinas.entidade.Compra;
import com.rcpiscinas.rcpiscinas.entidade.CompraProduto;
import com.rcpiscinas.rcpiscinas.repository.CompraProdutoRepository;
import com.rcpiscinas.rcpiscinas.repository.CompraRepository;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CompraProdutoRepository compraProdutoRepository;

    public Compra criarCompra(Compra compra) {
        compra.setDataCompra(new Date());
        compra.setDataInicio(new Date());

        if (compra.getProdutos() != null) {
            for (CompraProduto produto : compra.getProdutos()) {
                produto.setCompra(compra);
            }
        }

        return compraRepository.save(compra);
    }


    public List<Compra> listarCompras() {
        return compraRepository.findByDataFimIsNull();
    }

    public Compra buscarCompraPorId(Long id) {
        return compraRepository.findById(id).orElseThrow(() -> new RuntimeException("Compra não encontrada"));
    }

    public Compra excluirCompra(Long id) {
        Optional<Compra> compraOptional = compraRepository.findById(id);
        if (compraOptional.isPresent()) {
            Compra compra = compraOptional.get();
            compra.setDataFim(new Date());
            return compraRepository.save(compra);
        }
        throw new RuntimeException("Compra não encontrada");
    }

    public List<CompraProduto> listarProdutosPorCompra(Long compraId) {
        return compraProdutoRepository.findByCompraId(compraId);
    }
}
