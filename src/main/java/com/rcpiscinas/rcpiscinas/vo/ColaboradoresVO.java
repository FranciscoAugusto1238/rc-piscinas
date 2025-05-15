package com.rcpiscinas.rcpiscinas.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rcpiscinas.rcpiscinas.entidade.Colaboradores;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ColaboradoresVO {

    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private String dataNascimento;
    private Boolean ativo;
    private Date dataInicio;
    private Date dataFim;
    private EquipeVO equipe;

    public ColaboradoresVO(Colaboradores colaborador) {
        this.id = colaborador.getId();
        this.nome = colaborador.getNome();
        this.telefone = colaborador.getTelefone();
        this.cpf = colaborador.getCpf();
        this.dataNascimento = colaborador.getDataNascimento();
        this.ativo = colaborador.getAtivo();
        this.dataInicio = colaborador.getDataInicio();
        this.dataFim = colaborador.getDataFim();
        this.equipe = new EquipeVO(colaborador.getEquipe());

    }
}
