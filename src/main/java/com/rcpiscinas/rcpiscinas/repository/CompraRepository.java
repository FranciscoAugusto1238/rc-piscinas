package com.rcpiscinas.rcpiscinas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcpiscinas.rcpiscinas.entidade.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findByDataFimIsNull();
}
