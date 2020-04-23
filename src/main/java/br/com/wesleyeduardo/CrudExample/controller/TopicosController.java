package br.com.wesleyeduardo.CrudExample.controller;
import br.com.wesleyeduardo.CrudExample.form.AtualizacaoTopicoForm;
import br.com.wesleyeduardo.CrudExample.dto.DetalhesTopicoDTO;
import br.com.wesleyeduardo.CrudExample.form.TopicoForm;
import br.com.wesleyeduardo.CrudExample.modelo.Topico;
import br.com.wesleyeduardo.CrudExample.dto.TopicoDTO;
import br.com.wesleyeduardo.CrudExample.repository.CursoRepository;
import br.com.wesleyeduardo.CrudExample.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    @Transactional
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriBuilder){

       Topico topico = topicoForm.converter(cursoRepository);

       topicoRepository.save(topico);

       URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

       return ResponseEntity.created(uri).body(new TopicoDTO(topico));

    }


    @GetMapping("/{id}")
    public ResponseEntity<DetalhesTopicoDTO> detalhar(@PathVariable Long id){

        Optional<Topico> topico = topicoRepository.findById(id);

        if(topico.isPresent()){
            return ResponseEntity.ok(new DetalhesTopicoDTO(topico.get()));
        }

        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){

        Optional<Topico> optional = topicoRepository.findById(id);

        if(optional.isPresent()){
            Topico topico =  form.atualizar(id,topicoRepository);
            return ResponseEntity.ok(new TopicoDTO(topico));
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity remover(@PathVariable Long id){

        Optional<Topico> optional = topicoRepository.findById(id);

        if(optional.isPresent()){

            topicoRepository.deleteById(id);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
