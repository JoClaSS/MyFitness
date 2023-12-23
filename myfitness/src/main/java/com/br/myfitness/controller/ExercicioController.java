package com.br.myfitness.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.myfitness.model.Exercicio;
import com.br.myfitness.service.ExercicioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/exercicio")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExercicioController {

	@Autowired
	ExercicioService eService;
	
	@PostMapping("/cadastro")
	@ResponseBody
	public String cadastrarAtualizar(@RequestBody Exercicio exercicio) throws Exception {
		return eService.saveUpdate(exercicio);
	}
	
	@PostMapping("/deletar")
	@ResponseBody
	public String deletar(@RequestBody Long idExercicio) throws Exception {
		return eService.delete(idExercicio);
	}
	
	@GetMapping("/all")
	public List<Exercicio> findByTreino(@RequestParam("idTreino") Long idTreino) throws Exception {
		return eService.findByTreino(idTreino);
	}
}
