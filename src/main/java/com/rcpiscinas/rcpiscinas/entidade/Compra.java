package com.rcpiscinas.rcpiscinas.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_compra")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seq_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "compra")
    private List<CompraProduto> produtos = new ArrayList<>();


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_compra")
    private Date dataCompra;
    
    @Column(name = "status_compra")
    private String statusCompra;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fim")
	private Date dataFim;
}
