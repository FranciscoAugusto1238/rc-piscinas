package com.rcpiscinas.rcpiscinas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcpiscinas.rcpiscinas.entidade.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeAndCodigoProduto(String nome, String codigoProduto);

    List<Produto> findByDataFimIsNull();
}
