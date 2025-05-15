package com.rcpiscinas.rcpiscinas.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcpiscinas.rcpiscinas.entidade.Produto;
import com.rcpiscinas.rcpiscinas.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto criarProduto(Produto produto) {
		produto.setDataInicio(new Date());
		return produtoRepository.save(produto);
	}

	public List<Produto> listarProdutos() {
		return produtoRepository.findByDataFimIsNull();
	}

	public Produto deletarProduto(Long id) {
		Optional<Produto> produtoOptional = produtoRepository.findById(id);
		if (produtoOptional.isPresent()) {
			Produto produto = produtoOptional.get();
			produto.setDataFim(new Date());
			produto.setAtivo(false);
			return produtoRepository.save(produto);
		}
		throw new RuntimeException("Produto não encontrado");
	}

	public Produto buscarProdutoPorId(Long id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
	}

	public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
		Produto produtoExistente = produtoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));

		produtoExistente.setNome(produtoAtualizado.getNome());
		produtoExistente.setCodigoProduto(produtoAtualizado.getCodigoProduto());
		produtoExistente.setTipoProduto(produtoAtualizado.getTipoProduto());
		produtoExistente.setValorProduto(produtoAtualizado.getValorProduto());
		produtoExistente.setImagemBase64(produtoAtualizado.getImagemBase64().toString());
		produtoExistente.setAtivo(true);
		return produtoRepository.save(produtoExistente);
	}

	public List<Produto> listarProdutosPorFiltro(String nome, String codigoProduto) {
		return produtoRepository.findByNomeAndCodigoProduto(nome, codigoProduto);
	}
}
