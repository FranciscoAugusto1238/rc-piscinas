package com.rcpiscinas.rcpiscinas.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rcpiscinas.rcpiscinas.entidade.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProdutoVO {

    private Long id;
    private String nome;
    private String codigoProduto;
    private String tipoProduto;
    private Double valorProduto;
    private Boolean ativo;
    private Date dataInicio;
    private Date dataFim;
    private String imagemBase64;
    
    public ProdutoVO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.codigoProduto = produto.getCodigoProduto();
        this.tipoProduto = produto.getTipoProduto();
        this.valorProduto = produto.getValorProduto();
        this.ativo = produto.getAtivo();
        this.dataInicio = produto.getDataInicio();
        this.dataFim = produto.getDataFim();
        this.imagemBase64 = produto.getImagemBase64();
    }
}
