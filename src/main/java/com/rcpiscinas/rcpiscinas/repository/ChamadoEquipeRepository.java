package com.rcpiscinas.rcpiscinas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcpiscinas.rcpiscinas.entidade.ChamadoEquipe;

@Repository
public interface ChamadoEquipeRepository extends JpaRepository<ChamadoEquipe, Long> {
    List<ChamadoEquipe> findByDataFimIsNull();
}
