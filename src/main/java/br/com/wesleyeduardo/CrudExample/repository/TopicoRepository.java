package br.com.wesleyeduardo.CrudExample.repository;

import br.com.wesleyeduardo.CrudExample.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico,Long> {


    public List<Topico> findByCurso_Nome(String nomeCurso);

}
