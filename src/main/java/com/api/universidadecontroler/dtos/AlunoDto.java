package com.api.universidadecontroler.dtos;

public class AlunoDto {
    public Integer id;
    public String nome;
    public String dataNascimento;


    public AlunoDto() {}
    public AlunoDto(Integer id, String nome, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    public AlunoDto(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}
