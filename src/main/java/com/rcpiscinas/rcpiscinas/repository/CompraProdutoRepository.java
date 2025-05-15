package com.rcpiscinas.rcpiscinas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcpiscinas.rcpiscinas.entidade.CompraProduto;

@Repository
public interface CompraProdutoRepository extends JpaRepository<CompraProduto, Long> {
    List<CompraProduto> findByCompraId(Long compraId);
}
