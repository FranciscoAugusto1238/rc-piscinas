package com.rcpiscinas.rcpiscinas.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rcpiscinas.rcpiscinas.entidade.Equipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EquipeVO {

	private Long id;
	private String nome;
	private UsuarioVO usuarioCriador;
	private Boolean ativo;
	private Date dataInicio;
	private Date dataFim;

	public EquipeVO(Equipe equipe) {
		this.id = equipe.getId();
		this.nome = equipe.getNome();
		this.usuarioCriador = new UsuarioVO(equipe.getUsuarioCriador());
		this.ativo = equipe.getAtivo();
		this.dataInicio = equipe.getDataInicio();
		this.dataFim = equipe.getDataFim();
	}
}
