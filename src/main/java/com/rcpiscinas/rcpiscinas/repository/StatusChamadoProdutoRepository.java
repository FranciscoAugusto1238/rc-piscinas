package com.rcpiscinas.rcpiscinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcpiscinas.rcpiscinas.entidade.StatusChamadoProduto;

@Repository
public interface StatusChamadoProdutoRepository extends JpaRepository<StatusChamadoProduto, Long> {
}
