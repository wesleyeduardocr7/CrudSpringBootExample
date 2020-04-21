package br.com.wesleyeduardo.CrudExample.repository;

import br.com.wesleyeduardo.CrudExample.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {

    Curso findByNome(String nome);

}
