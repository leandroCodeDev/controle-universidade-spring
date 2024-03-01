package com.api.universidadecontroler.dtos;

public class CursoDto {
    public int id;
    public String nome;
    public String descricao;
    public int cargaHoraria;


    public CursoDto() {}
    public CursoDto(String nome, String descricao, int cargaHoraria) {

        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }
    public CursoDto(int id, String nome, String descricao, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }
}
