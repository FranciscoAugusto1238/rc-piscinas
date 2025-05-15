package com.rcpiscinas.rcpiscinas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcpiscinas.rcpiscinas.entidade.Colaboradores;

@Repository
public interface ColaboradoresRepository extends JpaRepository<Colaboradores, Long> {

    List<Colaboradores> findByNomeAndCpf(String nome, String cpf);

    List<Colaboradores> findByDataFimIsNull();
}
