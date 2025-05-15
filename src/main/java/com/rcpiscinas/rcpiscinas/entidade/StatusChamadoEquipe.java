package com.rcpiscinas.rcpiscinas.entidade;

import java.util.Date;
import java.util.List;

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
@Table(name = "status_chamado_equipe")
public class StatusChamadoEquipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_status_chamado")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seq_chamado_equipe", nullable = false)
    private ChamadoEquipe chamadoEquipe;

    @Column(name = "status_chamado")
    private String statusChamado;

    @Column(name = "descricao_chamado", columnDefinition = "TEXT")
    private String descricaoChamado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "horario_inicio_chamado")
    private Date horarioInicioChamado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "horario_fim_chamado")
    private Date horarioFimChamado;

    @OneToMany(mappedBy = "statusChamado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StatusChamadoProduto> produtosUtilizados;
    
    @ManyToOne
    @JoinColumn(name = "seq_colaborador", nullable = false)
    private Colaboradores colaborador;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fim")
	private Date dataFim;

}
