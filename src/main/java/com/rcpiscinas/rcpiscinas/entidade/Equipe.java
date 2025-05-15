package com.rcpiscinas.rcpiscinas.entidade;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "equipe")
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_equipe")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "seq_usuario_criador", nullable = false)
	private Usuario usuarioCriador;

	// Na entidade Equipe
	@OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore // impede que isso seja serializado
	private List<Colaboradores> colaboradores;


	@Column(name = "ativo")
	private Boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fim")
	private Date dataFim;
}
