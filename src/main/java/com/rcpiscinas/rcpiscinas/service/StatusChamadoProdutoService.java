package com.rcpiscinas.rcpiscinas.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcpiscinas.rcpiscinas.entidade.StatusChamadoProduto;
import com.rcpiscinas.rcpiscinas.repository.StatusChamadoProdutoRepository;

@Service
public class StatusChamadoProdutoService {

    @Autowired
    private StatusChamadoProdutoRepository statusChamadoProdutoRepository;

    public StatusChamadoProduto criarStatusChamadoProduto(StatusChamadoProduto statusChamadoProduto) {
        statusChamadoProduto.setDataInicio(new Date());
        statusChamadoProduto.setDataFim(null); // não preencher dataFim ao criar

        return statusChamadoProdutoRepository.save(statusChamadoProduto);
    }

    public List<StatusChamadoProduto> listarStatusChamadoProdutoAtivos() {
        return statusChamadoProdutoRepository.findAll(); // Altere aqui para filtro conforme necessário
    }

    public StatusChamadoProduto finalizarStatusChamadoProduto(Long id) {
        StatusChamadoProduto statusChamadoProduto = statusChamadoProdutoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StatusChamadoProduto não encontrado"));
        statusChamadoProduto.setDataFim(new Date()); // Preenche dataFim
        return statusChamadoProdutoRepository.save(statusChamadoProduto);
    }
}
