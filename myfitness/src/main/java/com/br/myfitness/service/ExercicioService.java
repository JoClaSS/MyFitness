package com.br.myfitness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.myfitness.model.Exercicio;
import com.br.myfitness.repository.ExercicioRepository;

@Service
public class ExercicioService {
	
	@Autowired
	private ExercicioRepository eDao;
	
	public String saveUpdate(Exercicio exercicio) {
		try {
			eDao.saveAndFlush(exercicio);
			return "Exercicio cadastrado com sucesso!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String delete(Long idExercicio) {	
		try {
			eDao.deleteById(idExercicio);
			return "Exercicio deletado";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public List<Exercicio> findByTreino(Long idTreino) {	
		try {			
			return eDao.findByTreino(idTreino);
		} catch (Exception e) {
			return null;
		}
	}

}
