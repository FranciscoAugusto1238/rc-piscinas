package com.rcpiscinas.rcpiscinas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rcpiscinas.rcpiscinas.entidade.Produto;
import com.rcpiscinas.rcpiscinas.service.ProdutoService;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS })
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }


    @GetMapping("/filtro")
    public List<Produto> listarProdutosPorFiltro(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String codigoProduto) {
        return produtoService.listarProdutosPorFiltro(nome, codigoProduto);
    }
    
    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable("id") Long id) {
        return produtoService.buscarProdutoPorId(id);
    }
    
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable("id") Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }


}
