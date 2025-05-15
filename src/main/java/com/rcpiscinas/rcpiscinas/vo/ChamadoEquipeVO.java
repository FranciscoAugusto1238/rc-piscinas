package com.rcpiscinas.rcpiscinas.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rcpiscinas.rcpiscinas.entidade.ChamadoEquipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChamadoEquipeVO {

    private Long id;
    private ChamadoAtendimentoVO chamado;
    private EquipeVO equipe;
    private UsuarioVO usuario;
    private Date dataInicio;
    private Date dataFim;

    public ChamadoEquipeVO(ChamadoEquipe chamadoEquipe) {
        this.id = chamadoEquipe.getId();
        this.chamado = new ChamadoAtendimentoVO(chamadoEquipe.getChamado());
        this.equipe = new EquipeVO(chamadoEquipe.getEquipe());
        this.usuario = new UsuarioVO(chamadoEquipe.getUsuario());
        this.dataInicio = chamadoEquipe.getDataInicio();
        this.dataFim = chamadoEquipe.getDataFim();
    }
}
