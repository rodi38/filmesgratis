package br.com.ada.filmesgratis.model;

import java.time.format.DateTimeFormatter;

public class Filme {
    private Integer id;
    private String titulo;
    private String genero;
    private DateTimeFormatter duracao;
    private String sinopse;
    private String imdb;
    private String imagem;
    private Integer like = 1;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public DateTimeFormatter getDuracao() {
        return duracao;
    }

    public void setDuracao(DateTimeFormatter duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
