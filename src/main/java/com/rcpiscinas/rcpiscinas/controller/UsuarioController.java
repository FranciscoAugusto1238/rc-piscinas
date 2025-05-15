package com.rcpiscinas.rcpiscinas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rcpiscinas.rcpiscinas.entidade.Usuario;
import com.rcpiscinas.rcpiscinas.service.UsuarioService;
import com.rcpiscinas.rcpiscinas.vo.UsuarioVO;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS })@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioVO criarUsuario(@RequestBody UsuarioVO usuarioVO) {
        Usuario usuario = usuarioService.criarUsuario(usuarioVO);
        return new UsuarioVO(usuario);
    }

    @GetMapping
    public List<UsuarioVO> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return usuarios.stream()
                .map(UsuarioVO::new)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public UsuarioVO finalizarUsuario(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.deletarUsuario(id);
        return new UsuarioVO(usuario);
    }

    @GetMapping("/filtro")
    public List<UsuarioVO> listarUsuariosPorFiltro(@RequestParam(required = false) String nome,
                                                   @RequestParam(required = false) Long cpf) {
        List<Usuario> usuarios = usuarioService.listarUsuariosPorFiltro(nome, cpf);
        return usuarios.stream()
                .map(UsuarioVO::new)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public UsuarioVO buscarUsuarioPorId(@PathVariable("id") Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        return new UsuarioVO(usuario);
    }

}
