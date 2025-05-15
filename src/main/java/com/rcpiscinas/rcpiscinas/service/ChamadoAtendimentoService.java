package com.rcpiscinas.rcpiscinas.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcpiscinas.rcpiscinas.entidade.ChamadoAtendimento;
import com.rcpiscinas.rcpiscinas.entidade.Usuario;
import com.rcpiscinas.rcpiscinas.repository.ChamadoAtendimentoRepository;
import com.rcpiscinas.rcpiscinas.repository.UsuarioRepository;
import com.rcpiscinas.rcpiscinas.vo.ChamadoAtendimentoVO;

@Service
public class ChamadoAtendimentoService {

    @Autowired
    private ChamadoAtendimentoRepository chamadoAtendimentoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ChamadoAtendimento criarChamado(ChamadoAtendimentoVO chamadoVO) {
        Usuario usuario = usuarioRepository.findById(chamadoVO.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        ChamadoAtendimento chamado = new ChamadoAtendimento();
        chamado.setUsuario(usuario);
        chamado.setDataInicio(new Date());
        chamado.setDataAtendimento(chamadoVO.getDataAtendimento());
        chamado.setIdade(chamadoVO.getIdade());
        chamado.setEndereco(chamadoVO.getEndereco());
        chamado.setDataFim(null);
        return chamadoAtendimentoRepository.save(chamado);
    }

    public List<ChamadoAtendimento> listarChamadosAtivos() {
        return chamadoAtendimentoRepository.findByDataFimIsNull();
    }

    public ChamadoAtendimento buscarPorId(Long id) {
        return chamadoAtendimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
    }

    public ChamadoAtendimento finalizarChamado(Long id) {
        ChamadoAtendimento chamado = buscarPorId(id);
        chamado.setDataFim(new Date());
        return chamadoAtendimentoRepository.save(chamado);
    }

    public ChamadoAtendimento atualizarChamado(Long id, ChamadoAtendimentoVO chamadoVO) {
        ChamadoAtendimento chamado = buscarPorId(id);

        chamado.setEndereco(chamadoVO.getEndereco());
        chamado.setIdade(chamadoVO.getIdade());
        chamado.setDataAtendimento(chamadoVO.getDataAtendimento());

        if (chamadoVO.getUsuario() != null && chamadoVO.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(chamadoVO.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            chamado.setUsuario(usuario);
        }

        return chamadoAtendimentoRepository.save(chamado);
    }

    public List<ChamadoAtendimento> listarChamadosPorFiltro(String endereco, Integer idade) {
        List<ChamadoAtendimento> todosChamados = chamadoAtendimentoRepository.findAll();

        return todosChamados.stream()
                .filter(c -> (endereco == null || c.getEndereco() != null && c.getEndereco().contains(endereco)) &&
                             (idade == null || c.getIdade() != null && c.getIdade().equals(idade)))
                .collect(Collectors.toList());
    }
}
