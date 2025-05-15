package com.rcpiscinas.rcpiscinas.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq_produto")
	private Long id;
	
	@Column(name = "nome")
    private String nome;
	
	@Column(name = "cd_produto")
    private String codigoProduto;
	
	@Column(name = "tipo_produto")
    private String tipoProduto;
	
	@Column(name = "valor_produto")
    private Double valorProduto;

	@Column(name = "ativo")
	private Boolean ativo;
	
	@Column(name = "imagem_base64", columnDefinition = "TEXT")
	private String imagemBase64;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_inicio")
	private Date dataInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_fim")
	private Date dataFim;
}
