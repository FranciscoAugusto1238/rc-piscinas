package com.rcpiscinas.rcpiscinas.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rcpiscinas.rcpiscinas.entidade.Colaboradores;
import com.rcpiscinas.rcpiscinas.entidade.Equipe;
import com.rcpiscinas.rcpiscinas.repository.ColaboradoresRepository;
import com.rcpiscinas.rcpiscinas.repository.EquipeRepository;
import com.rcpiscinas.rcpiscinas.vo.ColaboradoresVO;

@Service
public class ColaboradoresService {

    @Autowired
    private ColaboradoresRepository colaboradoresRepository;

    @Autowired
    private EquipeRepository equipeRepository;
    
    public Colaboradores criarColaborador(Colaboradores colaborador) {
        colaborador.setDataInicio(new Date());
        return colaboradoresRepository.save(colaborador);
    }
    
    @PostMapping
    public ResponseEntity<ColaboradoresVO> criar(@RequestBody ColaboradoresVO vo) {
    	
        Equipe equipe = equipeRepository.findById(vo.getEquipe().getId())
            .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        Colaboradores colaborador = new Colaboradores();
        colaborador.setNome(vo.getNome());
        colaborador.setTelefone(vo.getTelefone());
        colaborador.setCpf(vo.getCpf());
        colaborador.setDataNascimento(vo.getDataNascimento());
        colaborador.setAtivo(true);
        colaborador.setEquipe(equipe);

        Colaboradores salvo = criarColaborador(colaborador);
        return ResponseEntity.ok(new ColaboradoresVO(salvo));
    }



    public List<Colaboradores> listarColaboradores() {
        return colaboradoresRepository.findByDataFimIsNull();
    }
    
    public ColaboradoresVO buscarColaboradorPorId(Long id) {
        Colaboradores colaborador = colaboradoresRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));
        return new ColaboradoresVO(colaborador);
    }


    public Colaboradores deletarColaborador(Long id) {
        Optional<Colaboradores> colaboradorOptional = colaboradoresRepository.findById(id);
        if (colaboradorOptional.isPresent()) {
            Colaboradores colaborador = colaboradorOptional.get();
            colaborador.setDataFim(new Date());
            colaborador.setAtivo(false);
            return colaboradoresRepository.save(colaborador);
        }
        throw new RuntimeException("Colaborador não encontrado");
    }

    public List<Colaboradores> listarColaboradoresPorFiltro(String nome, String cpf) {
        return colaboradoresRepository.findByNomeAndCpf(nome, cpf);
    }
}
