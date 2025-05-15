package com.rcpiscinas.rcpiscinas.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rcpiscinas.rcpiscinas.entidade.CompraProduto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompraProdutoVO {

    private Long id;
    private CompraVO compra;
    private ProdutoVO produto;
    private Integer quantidade;
    private Double valorUnitario;

    public CompraProdutoVO(CompraProduto compraProduto) {
        this.id = compraProduto.getId();
        this.compra = new CompraVO(compraProduto.getCompra());
        this.produto = new ProdutoVO(compraProduto.getProduto());
        this.quantidade = compraProduto.getQuantidade();
        this.valorUnitario = compraProduto.getValorUnitario();
    }
}
