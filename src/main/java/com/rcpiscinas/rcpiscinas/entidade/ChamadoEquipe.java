package com.rcpiscinas.rcpiscinas.entidade;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "chamado_equipe")
public class ChamadoEquipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_chamado_equipe")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seq_chamado", nullable = false)
    private ChamadoAtendimento chamado;

    @ManyToOne
    @JoinColumn(name = "seq_equipe", nullable = false)
    private Equipe equipe;
    
    @ManyToOne
    @JoinColumn(name = "seq_usuario", nullable = false)
    private Usuario usuario;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fim")
	private Date dataFim;
}
