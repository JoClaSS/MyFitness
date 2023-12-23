package com.br.myfitness.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.myfitness.model.Perfil;
import com.br.myfitness.repository.PerfilRepository;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository pDao;
	
	public String saveUpdate(Perfil perfil) {
		try {
			this.pDao.saveAndFlush(perfil);
			return "Perfil cadastro com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public Optional<Perfil> findById(Long idPerfil) {
		try {
			return this.pDao.findById(idPerfil);
		} catch (Exception e) {
			return Optional.empty();
		}
	}
	public String delete(Long idPerfil) {
		Perfil perfil = new Perfil();
		try {
			perfil = pDao.findById(idPerfil).orElseThrow();
			perfil.setAtivo(false);
			this.pDao.saveAndFlush(perfil);
			return "Perfil removido";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
