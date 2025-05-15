package com.rcpiscinas.rcpiscinas.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rcpiscinas.rcpiscinas.entidade.StatusChamadoProduto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusChamadoProdutoVO {

    private Long id;
    private String statusChamado;
    private ProdutoVO produto;
    private Integer quantidade;
    private Date dataInicio;
    private Date dataFim;

    public StatusChamadoProdutoVO(StatusChamadoProduto statusChamadoProduto) {
        this.id = statusChamadoProduto.getId();
        this.statusChamado = statusChamadoProduto.getStatus();
        this.produto = new ProdutoVO(statusChamadoProduto.getProduto());
        this.quantidade = statusChamadoProduto.getQuantidade();
        this.dataInicio = statusChamadoProduto.getDataInicio();
        this.dataFim = statusChamadoProduto.getDataFim();
    }
}
