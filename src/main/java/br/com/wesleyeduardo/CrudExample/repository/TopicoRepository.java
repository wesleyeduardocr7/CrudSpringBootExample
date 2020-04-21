package br.com.wesleyeduardo.CrudExample.repository;

import br.com.wesleyeduardo.CrudExample.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {}
