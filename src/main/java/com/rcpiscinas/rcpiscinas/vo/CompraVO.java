package com.rcpiscinas.rcpiscinas.vo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rcpiscinas.rcpiscinas.entidade.Compra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompraVO {

    private Long id;
    private UsuarioVO usuario;
    private List<CompraProdutoVO> produtos;
    private Date dataCompra;
    private String statusCompra;
    private Date dataInicio;
    private Date dataFim;

    public CompraVO(Compra compra) {
        this.id = compra.getId();
        this.usuario = new UsuarioVO(compra.getUsuario());
        this.produtos = compra.getProdutos().stream()
                               .map(CompraProdutoVO::new)
                               .collect(Collectors.toList());
        this.dataCompra = compra.getDataCompra();
        this.statusCompra = compra.getStatusCompra();
        this.dataInicio = compra.getDataInicio();
        this.dataFim = compra.getDataFim();
    }
}
