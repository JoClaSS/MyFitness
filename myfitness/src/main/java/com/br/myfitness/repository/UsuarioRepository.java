package com.br.myfitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.myfitness.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>  {

}
