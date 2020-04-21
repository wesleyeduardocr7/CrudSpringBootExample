package br.com.wesleyeduardo.CrudExample.controller;
import br.com.wesleyeduardo.CrudExample.modelo.Topico;
import br.com.wesleyeduardo.CrudExample.dto.TopicoDTO;
import br.com.wesleyeduardo.CrudExample.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDTO> lista(){

        List<Topico> topicos = topicoRepository.findAll();

        return TopicoDTO.converter(topicos);
    }


}
