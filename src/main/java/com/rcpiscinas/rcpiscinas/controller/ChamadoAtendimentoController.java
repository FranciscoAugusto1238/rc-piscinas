package com.rcpiscinas.rcpiscinas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rcpiscinas.rcpiscinas.entidade.ChamadoAtendimento;
import com.rcpiscinas.rcpiscinas.service.ChamadoAtendimentoService;
import com.rcpiscinas.rcpiscinas.vo.ChamadoAtendimentoVO;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS })
@RestController
@RequestMapping("/chamados")
public class ChamadoAtendimentoController {

    @Autowired
    private ChamadoAtendimentoService chamadoAtendimentoService;

    @PostMapping
    public ChamadoAtendimentoVO criarChamado(@RequestBody ChamadoAtendimentoVO chamadoVO) {
        ChamadoAtendimento chamado = chamadoAtendimentoService.criarChamado(chamadoVO);
        return new ChamadoAtendimentoVO(chamado);
    }

    @GetMapping("/ativos")
    public List<ChamadoAtendimentoVO> listarChamadosAtivos() {
        List<ChamadoAtendimento> chamados = chamadoAtendimentoService.listarChamadosAtivos();
        return chamados.stream()
                .map(ChamadoAtendimentoVO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ChamadoAtendimentoVO buscarPorId(@PathVariable("id") Long id) {
        ChamadoAtendimento chamado = chamadoAtendimentoService.buscarPorId(id);
        return new ChamadoAtendimentoVO(chamado);
    }

    @PutMapping("/{id}/finalizar")
    public ChamadoAtendimentoVO finalizarChamado(@PathVariable("id") Long id) {
        ChamadoAtendimento chamado = chamadoAtendimentoService.finalizarChamado(id);
        return new ChamadoAtendimentoVO(chamado);
    }

    @PutMapping("/{id}")
    public ChamadoAtendimentoVO atualizarChamado(@PathVariable("id") Long id, @RequestBody ChamadoAtendimentoVO chamadoVO) {
        ChamadoAtendimento chamado = chamadoAtendimentoService.atualizarChamado(id, chamadoVO);
        return new ChamadoAtendimentoVO(chamado);
    }
}
