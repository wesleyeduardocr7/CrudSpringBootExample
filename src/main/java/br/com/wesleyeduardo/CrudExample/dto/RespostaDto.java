package br.com.wesleyeduardo.CrudExample.dto;

import br.com.wesleyeduardo.CrudExample.modelo.Resposta;

import java.time.LocalDateTime;

public class RespostaDto {

    private  Long id;
    private  String mensagem;
    private LocalDateTime dataCriação;
    private  String nomeAutor;

    public RespostaDto(Resposta resposta){
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCriação = resposta.getDataCriacao();
        this.nomeAutor  = resposta.getAutor().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriação() {
        return dataCriação;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}
