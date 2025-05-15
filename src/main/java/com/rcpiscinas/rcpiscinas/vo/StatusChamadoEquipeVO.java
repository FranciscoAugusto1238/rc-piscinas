package com.rcpiscinas.rcpiscinas.vo;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rcpiscinas.rcpiscinas.entidade.StatusChamadoEquipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusChamadoEquipeVO {

    private Long id;
    private ChamadoEquipeVO chamadoEquipe;
    private String statusChamado;
    private String descricaoChamado;
    private Date horarioInicioChamado;
    private Date horarioFimChamado;
    private List<StatusChamadoProdutoVO> produtosUtilizados;
    private ColaboradoresVO colaborador;
    private Date dataInicio;
    private Date dataFim;

    public StatusChamadoEquipeVO(StatusChamadoEquipe statusChamadoEquipe) {
        this.id = statusChamadoEquipe.getId();
        this.chamadoEquipe = new ChamadoEquipeVO(statusChamadoEquipe.getChamadoEquipe());
        this.statusChamado = statusChamadoEquipe.getStatusChamado();
        this.descricaoChamado = statusChamadoEquipe.getDescricaoChamado();
        this.horarioInicioChamado = statusChamadoEquipe.getHorarioInicioChamado();
        this.horarioFimChamado = statusChamadoEquipe.getHorarioFimChamado();
        this.colaborador = new ColaboradoresVO(statusChamadoEquipe.getColaborador());
        this.dataInicio = statusChamadoEquipe.getDataInicio();
        this.dataFim = statusChamadoEquipe.getDataFim();
        this.produtosUtilizados = statusChamadoEquipe.getProdutosUtilizados()
                .stream()
                .map(StatusChamadoProdutoVO::new)
                .collect(Collectors.toList());
    }
}
