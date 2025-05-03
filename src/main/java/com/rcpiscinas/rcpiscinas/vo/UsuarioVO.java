package com.rcpiscinas.rcpiscinas.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rcpiscinas.rcpiscinas.entidade.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioVO {
	
	private Long id;
	private String nome;
	private Long cpf;
	private String uf;
	private String municipio;
	private Date dataNascimento;
	private Boolean ativo;
	
	public UsuarioVO(Usuario usuario) {
		
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.uf = usuario.getUf();
		this.municipio = usuario.getMunicipio();
		this.dataNascimento = usuario.getDataNascimento();
		this.ativo = usuario.getAtivo();
		
	}

}