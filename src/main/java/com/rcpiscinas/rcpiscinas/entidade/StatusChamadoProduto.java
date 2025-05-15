package com.rcpiscinas.rcpiscinas.entidade;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "status_chamado_produto")
public class StatusChamadoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_status_chamado_produto")
    private Long id;

    @Column(name = "status")
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "seq_status_chamado", nullable = false)
    private StatusChamadoEquipe statusChamado;

    @ManyToOne
    @JoinColumn(name = "seq_produto", nullable = false)
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fim")
	private Date dataFim;
}
