package com.rcpiscinas.rcpiscinas.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rcpiscinas.rcpiscinas.entidade.Usuario;
import com.rcpiscinas.rcpiscinas.repository.UsuarioRepository;
import com.rcpiscinas.rcpiscinas.vo.UsuarioVO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
	
	 @Autowired
	 private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(UsuarioVO usuarioVO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioVO.getNome());
        usuario.setCpf(usuarioVO.getCpf());
        usuario.setUf(usuarioVO.getUf());
        usuario.setMunicipio(usuarioVO.getMunicipio());
        usuario.setPermissao(usuarioVO.getPermissao());
        usuario.setDataNascimento(usuarioVO.getDataNascimento());
        usuario.setAtivo(true);
        String senhaCriptografada = passwordEncoder.encode(usuarioVO.getSenha());
        usuario.setSenha(senhaCriptografada);
        usuario.setDataInicio(new Date());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findByDataFimIsNull();
    }

    public Usuario deletarUsuario(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setDataFim(new Date());
            usuario.setAtivo(false);
            return usuarioRepository.save(usuario);
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id " + id));
    }

   
    public List<Usuario> listarUsuariosPorFiltro(String nome, Long cpf) {
        return usuarioRepository.findByNomeAndCpf(nome, cpf);
    }
}
