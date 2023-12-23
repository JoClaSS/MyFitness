package com.br.myfitness.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.myfitness.model.Usuario;
import com.br.myfitness.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository uDao;
	
	public String saveUpdate(Usuario usuario) {
		try {
			uDao.saveAndFlush(usuario);
			return "Usuario cadastrado com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}	
	}
	
	public Optional<Usuario> findById(Long idUsuario){
		try {
			return uDao.findById(idUsuario);
		} catch (Exception e) {
			return Optional.empty();
		}	
	}
	
	
	public String delete(Long idusuario) {
		Usuario usuario = new Usuario();
		try {
			usuario = uDao.findById(idusuario).orElseThrow();
			usuario.setAtivo(false);
			uDao.saveAndFlush(usuario);
			return "Usuario deletado!";
		} catch (Exception e) {
			return e.getMessage();
		}	
	}
	

}
