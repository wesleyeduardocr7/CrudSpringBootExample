package br.com.wesleyeduardo.CrudExample.dto;

import br.com.wesleyeduardo.CrudExample.modelo.Topico;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TopicoDTO {

   private long id;
   private  String titulo;
   private String mensagem;
   private LocalDateTime dataCriação;

    public TopicoDTO(Topico topico){

        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriação = topico.getDataCriacao();
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriação() {
        return dataCriação;
    }


    public static List<TopicoDTO> converter (List<Topico> topicos ){

        return topicos.stream().map(TopicoDTO::new).collect(Collectors.toList());

    }



}
