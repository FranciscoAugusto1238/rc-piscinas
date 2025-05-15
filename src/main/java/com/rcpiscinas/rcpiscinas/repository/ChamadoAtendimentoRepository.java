package com.rcpiscinas.rcpiscinas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcpiscinas.rcpiscinas.entidade.ChamadoAtendimento;

@Repository
public interface ChamadoAtendimentoRepository extends JpaRepository<ChamadoAtendimento, Long> {
    List<ChamadoAtendimento> findByDataFimIsNull();
}
