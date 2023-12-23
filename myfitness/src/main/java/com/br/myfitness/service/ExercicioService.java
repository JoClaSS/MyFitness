package com.br.myfitness.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.myfitness.exception.UnsuportedException;
import com.br.myfitness.model.Exercicio;
import com.br.myfitness.repository.ExercicioRepository;

@Service
public class ExercicioService {
	
	@Autowired
	private ExercicioRepository eDao;
	
	public String saveUpdate(Exercicio exercicio) throws Exception{
		try {
			eDao.saveAndFlush(exercicio);
			return "Exercicio cadastrado com sucesso!";
		} catch (Exception e) {
			throw new UnsuportedException(e.getMessage());
		}
	}
	
	public String delete(Long idExercicio) throws Exception {	
		try {
			eDao.deleteById(idExercicio);
			return "Exercicio deletado";
		} catch (Exception e) {
			throw new UnsuportedException(e.getMessage());
		}
	}
	
	public List<Exercicio> findByTreino(Long idTreino) throws Exception{	
		try {			
			return eDao.findByTreino(idTreino);
		} catch (Exception e) {
			throw new UnsuportedException(e.getMessage());
		}
	}

}
