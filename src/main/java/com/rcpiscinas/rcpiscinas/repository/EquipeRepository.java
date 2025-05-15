package com.rcpiscinas.rcpiscinas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcpiscinas.rcpiscinas.entidade.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    List<Equipe> findByAtivoTrueAndDataFimIsNull();
}
