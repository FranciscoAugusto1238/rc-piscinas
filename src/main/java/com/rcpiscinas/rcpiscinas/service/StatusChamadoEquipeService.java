package com.rcpiscinas.rcpiscinas.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcpiscinas.rcpiscinas.entidade.StatusChamadoEquipe;
import com.rcpiscinas.rcpiscinas.repository.StatusChamadoEquipeRepository;
import com.rcpiscinas.rcpiscinas.repository.StatusChamadoProdutoRepository;

@Service
public class StatusChamadoEquipeService {

    @Autowired
    private StatusChamadoEquipeRepository statusChamadoEquipeRepository;

    @Autowired
    private StatusChamadoProdutoRepository statusChamadoProdutoRepository;

    public StatusChamadoEquipe criarStatusChamadoEquipe(StatusChamadoEquipe statusChamadoEquipe) {
        statusChamadoEquipe.setDataInicio(new Date());
        statusChamadoEquipe.setDataFim(null); // não preencher dataFim ao criar

        return statusChamadoEquipeRepository.save(statusChamadoEquipe);
    }

    public List<StatusChamadoEquipe> listarStatusChamadoEquipeAtivos() {
        return statusChamadoEquipeRepository.findAll(); // Altere aqui para filtro conforme necessário
    }

    public StatusChamadoEquipe finalizarStatusChamadoEquipe(Long id) {
        StatusChamadoEquipe statusChamadoEquipe = statusChamadoEquipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StatusChamadoEquipe não encontrado"));
        statusChamadoEquipe.setDataFim(new Date()); // Preenche dataFim
        return statusChamadoEquipeRepository.save(statusChamadoEquipe);
    }
}
