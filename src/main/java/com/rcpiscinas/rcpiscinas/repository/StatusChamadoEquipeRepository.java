package com.rcpiscinas.rcpiscinas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcpiscinas.rcpiscinas.entidade.StatusChamadoEquipe;

@Repository
public interface StatusChamadoEquipeRepository extends JpaRepository<StatusChamadoEquipe, Long> {
}
