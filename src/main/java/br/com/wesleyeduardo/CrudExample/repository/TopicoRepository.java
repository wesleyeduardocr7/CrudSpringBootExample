package br.com.wesleyeduardo.CrudExample.repository;

import br.com.wesleyeduardo.CrudExample.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TopicoRepository extends JpaRepository<Topico,Long> {


    Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);

}
