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

import com.br.myfitness.model.Treino;
import com.br.myfitness.service.TreinoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/treino")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TreinoController {

	@Autowired
	TreinoService tService;
	
	@PostMapping("/cadastro")
	@ResponseBody
	public String cadastrarAtualizar(@RequestBody Treino treino) {
		return tService.saveUpdate(treino);
	}
	
	@PostMapping("/deletar")
	@ResponseBody
	public String deletar(@RequestParam Long idTreino) {
		return tService.delete(idTreino);
	}
	
	
	@GetMapping("/all")
	public List<Treino> findAllAtivos(@RequestParam("idAluno") Long idAluno) {
		return tService.findAllAtivos(idAluno);
	}
}
