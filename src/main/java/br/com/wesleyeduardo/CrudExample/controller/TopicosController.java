package br.com.wesleyeduardo.CrudExample.controller;
import br.com.wesleyeduardo.CrudExample.form.TopicoForm;
import br.com.wesleyeduardo.CrudExample.modelo.Topico;
import br.com.wesleyeduardo.CrudExample.dto.TopicoDTO;
import br.com.wesleyeduardo.CrudExample.repository.CursoRepository;
import br.com.wesleyeduardo.CrudExample.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDTO> lista(String nomeCurso){

        if(nomeCurso == null){
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDTO.converter(topicos);
        }else{
            List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);
            return TopicoDTO.converter(topicos);
        }
    }


    @PostMapping
    public void cadastrar(@RequestBody TopicoForm topicoForm){

       Topico topico = topicoForm.converter(cursoRepository);

       topicoRepository.save(topico);
    }



}
