package com.rcpiscinas.rcpiscinas.entidade;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "usurio")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_usuario")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private Long cpf;
    
    @Column(name = "UF")
    private String uf;
    
    @Column(name = "municipio")
    private String municipio;
    
    @Column(name = "permissao")
    private String permissao;
    
    @Column(name = "senha")
    private String senha;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    
    @Column(name = "ativo")
    private Boolean ativo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_inicio")
    private Date dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dt_fim")
    private Date dataFim;
}