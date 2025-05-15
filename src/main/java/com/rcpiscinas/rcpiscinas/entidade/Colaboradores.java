package com.rcpiscinas.rcpiscinas.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "colaboradores")
public class Colaboradores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_colaboradores")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "seq_equipe", nullable = false)
	private Equipe equipe;

	@Column(name = "nome")
    private String nome;
	
	@Column(name = "telefone")
    private String telefone;
	
	@Column(name = "cpf")
    private String cpf;
	
	@Column(name = "data_nascimento")
    private String dataNascimento;

	@Column(name = "ativo")
	private Boolean ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fim")
	private Date dataFim;

}
