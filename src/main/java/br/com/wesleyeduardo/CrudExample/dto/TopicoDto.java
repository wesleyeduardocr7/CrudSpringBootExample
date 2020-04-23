package br.com.wesleyeduardo.CrudExample.dto;

import br.com.wesleyeduardo.CrudExample.modelo.Topico;
import java.time.LocalDateTime;
import org.springframework.data.domain.Page;

public class TopicoDto {

   private long id;
   private  String titulo;
   private String mensagem;
   private LocalDateTime dataCriação;

    public TopicoDto(Topico topico){

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


    public static Page<TopicoDto> converter(Page<Topico> topicos) {
        return topicos.map(TopicoDto::new);
    }



}
