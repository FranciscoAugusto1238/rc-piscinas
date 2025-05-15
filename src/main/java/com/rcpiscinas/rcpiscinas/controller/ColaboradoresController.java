package com.rcpiscinas.rcpiscinas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rcpiscinas.rcpiscinas.entidade.Colaboradores;
import com.rcpiscinas.rcpiscinas.service.ColaboradoresService;
import com.rcpiscinas.rcpiscinas.vo.ColaboradoresVO;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS })
@RestController
@RequestMapping("/colaboradores")
public class ColaboradoresController {

    @Autowired
    private ColaboradoresService colaboradoresService;

    @PostMapping
    public ResponseEntity<ColaboradoresVO> criar(@RequestBody ColaboradoresVO vo) {
        return colaboradoresService.criar(vo);
    }

    @GetMapping
    public List<Colaboradores> listarColaboradores() {
        return colaboradoresService.listarColaboradores();
    }

    @PutMapping("/{id}")
    public Colaboradores deletarColaborador(@PathVariable Long id) {
        return colaboradoresService.deletarColaborador(id);
    }

    @GetMapping("/filtro")
    public List<Colaboradores> listarPorFiltro(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf) {
        return colaboradoresService.listarColaboradoresPorFiltro(nome, cpf);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ColaboradoresVO> buscarColaboradorPorId(@PathVariable("id") Long id) {
        ColaboradoresVO colaboradorVO = colaboradoresService.buscarColaboradorPorId(id);
        return ResponseEntity.ok(colaboradorVO);
    }


}
