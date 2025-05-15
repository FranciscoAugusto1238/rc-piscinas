package com.rcpiscinas.rcpiscinas.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcpiscinas.rcpiscinas.entidade.ChamadoEquipe;
import com.rcpiscinas.rcpiscinas.entidade.ChamadoAtendimento;
import com.rcpiscinas.rcpiscinas.entidade.Equipe;
import com.rcpiscinas.rcpiscinas.entidade.Usuario;
import com.rcpiscinas.rcpiscinas.repository.ChamadoEquipeRepository;
import com.rcpiscinas.rcpiscinas.repository.ChamadoAtendimentoRepository;
import com.rcpiscinas.rcpiscinas.repository.EquipeRepository;
import com.rcpiscinas.rcpiscinas.repository.UsuarioRepository;

@Service
public class ChamadoEquipeService {

    @Autowired
    private ChamadoEquipeRepository chamadoEquipeRepository;

    @Autowired
    private ChamadoAtendimentoRepository chamadoAtendimentoRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ChamadoEquipe criarChamadoEquipe(ChamadoEquipe chamadoEquipe) {
        ChamadoAtendimento chamado = chamadoAtendimentoRepository.findById(chamadoEquipe.getChamado().getId())
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        Equipe equipe = equipeRepository.findById(chamadoEquipe.getEquipe().getId())
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        Usuario usuario = usuarioRepository.findById(chamadoEquipe.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        chamadoEquipe.setChamado(chamado);
        chamadoEquipe.setEquipe(equipe);
        chamadoEquipe.setUsuario(usuario);
        chamadoEquipe.setDataInicio(new Date());
        chamadoEquipe.setDataFim(null);

        return chamadoEquipeRepository.save(chamadoEquipe);
    }

    public List<ChamadoEquipe> listarChamadosEquipeAtivos() {
        return chamadoEquipeRepository.findByDataFimIsNull();
    }

    public ChamadoEquipe finalizarChamadoEquipe(Long id) {
        ChamadoEquipe chamadoEquipe = chamadoEquipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ChamadoEquipe não encontrado"));
        chamadoEquipe.setDataFim(new Date());
        return chamadoEquipeRepository.save(chamadoEquipe);
    }

    public ChamadoEquipe buscarPorId(Long id) {
        return chamadoEquipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ChamadoEquipe não encontrado"));
    }
}
