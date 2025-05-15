package com.rcpiscinas.rcpiscinas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rcpiscinas.rcpiscinas.entidade.Equipe;
import com.rcpiscinas.rcpiscinas.service.EquipeService;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    @PostMapping
    public Equipe criarEquipe(@RequestBody Equipe equipe) {
        return equipeService.criarEquipe(equipe);
    }

    @GetMapping
    public List<Equipe> listarEquipesAtivas() {
        return equipeService.listarEquipesAtivas();
    }

    @GetMapping("/{id}")
    public Equipe buscarEquipePorId(@PathVariable("id") Long id) {
        return equipeService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Equipe atualizarEquipe(@PathVariable("id") Long id, @RequestBody Equipe equipe) {
        return equipeService.atualizarEquipe(id, equipe);
    }

    @DeleteMapping("/{id}")
    public Equipe desativarEquipe(@PathVariable("id") Long id) {
        return equipeService.desativarEquipe(id);
    }
}
