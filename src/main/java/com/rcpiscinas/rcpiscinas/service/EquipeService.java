package com.rcpiscinas.rcpiscinas.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcpiscinas.rcpiscinas.entidade.Equipe;
import com.rcpiscinas.rcpiscinas.repository.EquipeRepository;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public Equipe criarEquipe(Equipe equipe) {
        equipe.setDataInicio(new Date());
        equipe.setAtivo(true);
        return equipeRepository.save(equipe);
    }

    public List<Equipe> listarEquipesAtivas() {
        return equipeRepository.findByAtivoTrueAndDataFimIsNull();
    }

    public Equipe buscarPorId(Long id) {
        return equipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));
    }

    public Equipe desativarEquipe(Long id) {
        Optional<Equipe> equipeOpt = equipeRepository.findById(id);
        if (equipeOpt.isPresent()) {
            Equipe equipe = equipeOpt.get();
            equipe.setAtivo(false);
            equipe.setDataFim(new Date());
            return equipeRepository.save(equipe);
        }
        throw new RuntimeException("Equipe não encontrada");
    }

    public Equipe atualizarEquipe(Long id, Equipe novaEquipe) {
        Equipe equipe = buscarPorId(id);
        equipe.setNome(novaEquipe.getNome());
        equipe.setColaboradores(novaEquipe.getColaboradores());
        return equipeRepository.save(equipe);
    }
}
