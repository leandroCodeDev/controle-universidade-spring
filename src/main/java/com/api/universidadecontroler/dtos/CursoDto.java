package com.api.universidadecontroler.dtos;

import java.util.ArrayList;

public class CursoDto {
    public Integer id;
    public String nome;
    public String descricao;
    public Integer cargaHoraria;
    public ArrayList<AlunoDto> alunos = new ArrayList<>();


    public CursoDto() {}
    public CursoDto(String nome, String descricao, Integer cargaHoraria) {

        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }
    public CursoDto(Integer id, String nome, String descricao, Integer cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }
    public CursoDto(Integer id, String nome, String descricao, Integer cargaHoraria,ArrayList<AlunoDto> alunos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.alunos =alunos;
    }
}
