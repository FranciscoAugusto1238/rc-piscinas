package com.rcpiscinas.rcpiscinas.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RestController;

import com.rcpiscinas.rcpiscinas.entidade.Compra;
import com.rcpiscinas.rcpiscinas.entidade.CompraProduto;
import com.rcpiscinas.rcpiscinas.entidade.Produto;
import com.rcpiscinas.rcpiscinas.service.CompraProdutoService;
import com.rcpiscinas.rcpiscinas.vo.CompraProdutoVO;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS })
@RestController
@RequestMapping("/compra-produto")
public class CompraProdutoController {

    @Autowired
    private CompraProdutoService compraProdutoService;

    @PostMapping
    public List<CompraProdutoVO> criarCompraEProdutos(@RequestBody List<CompraProdutoVO> listaVO) {
        List<CompraProduto> listaEntidade = listaVO.stream()
            .map(this::converterVoParaEntidade)
            .collect(Collectors.toList());

        List<CompraProduto> listaSalva = compraProdutoService.criarCompraEProdutos(listaEntidade);

        return listaSalva.stream()
            .map(CompraProdutoVO::new)
            .collect(Collectors.toList());
    }


    @GetMapping("/compra/{compraId}")
    public List<CompraProdutoVO> listarPorCompra(@PathVariable("compraId") Long compraId) {
        return compraProdutoService.listarPorCompra(compraId)
                .stream()
                .map(CompraProdutoVO::new)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public CompraProdutoVO atualizarProduto(@PathVariable("id") Long id, @RequestBody CompraProdutoVO vo) {
        CompraProduto entidade = converterVoParaEntidade(vo);
        CompraProduto atualizado = compraProdutoService.atualizarProduto(id, entidade);
        return new CompraProdutoVO(atualizado);
    }

    @DeleteMapping("/{id}")
    public void removerProduto(@PathVariable("id") Long id) {
        compraProdutoService.deletarProduto(id);
    }

    private CompraProduto converterVoParaEntidade(CompraProdutoVO vo) {
        CompraProduto cp = new CompraProduto();

        if (vo.getId() != null) {
            cp.setId(vo.getId());
        }

        if (vo.getCompra() != null && vo.getCompra().getId() != null) {
            Compra compra = new Compra();
            compra.setId(vo.getCompra().getId());
            cp.setCompra(compra);
        }

        if (vo.getProduto() != null && vo.getProduto().getId() != null) {
            Produto produto = new Produto();
            produto.setId(vo.getProduto().getId());
            cp.setProduto(produto);
        }

        cp.setQuantidade(vo.getQuantidade());
        cp.setValorUnitario(vo.getValorUnitario());

        return cp;
    }
}
