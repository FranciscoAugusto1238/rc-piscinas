package com.rcpiscinas.rcpiscinas.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "chamado_atendimento")
public class ChamadoAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_chamado")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seq_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "endereco")
    private String endereco;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_atendimento")
    private Date dataAtendimento;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fim")
	private Date dataFim;
}

