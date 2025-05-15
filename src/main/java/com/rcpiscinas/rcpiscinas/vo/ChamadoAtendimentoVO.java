package com.rcpiscinas.rcpiscinas.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rcpiscinas.rcpiscinas.entidade.ChamadoAtendimento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChamadoAtendimentoVO {

    private Long id;
    private UsuarioVO usuario;
    private Integer idade;
    private String endereco;
    private Date dataAtendimento;
    private Date dataInicio;
    private Date dataFim;

    public ChamadoAtendimentoVO(ChamadoAtendimento chamadoAtendimento) {
        this.id = chamadoAtendimento.getId();
        this.usuario = new UsuarioVO(chamadoAtendimento.getUsuario());
        this.idade = chamadoAtendimento.getIdade();
        this.endereco = chamadoAtendimento.getEndereco();
        this.dataAtendimento = chamadoAtendimento.getDataAtendimento();
        this.dataInicio = chamadoAtendimento.getDataInicio();
        this.dataFim = chamadoAtendimento.getDataFim();
    }
}
