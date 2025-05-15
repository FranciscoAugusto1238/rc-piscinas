package com.rcpiscinas.rcpiscinas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcpiscinas.rcpiscinas.entidade.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNomeAndCpf(String nome, Long cpf);

    List<Usuario> findByDataFimIsNull();
}
