package com.rcpiscinas.rcpiscinas.entidade;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "compra_produto")
public class CompraProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_compra_produto")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seq_compra", nullable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "seq_produto", nullable = false)
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valor_unitario")
    private Double valorUnitario;
}
