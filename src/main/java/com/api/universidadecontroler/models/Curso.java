package com.api.universidadecontroler.models;

public class Curso {

    private static int contador = 1;
    private int id;
    private String nome;
    private String descricao;
    private int cargaHoraria;

    private static int  gerarIdAluno(){
        return contador++;
    }

    public Curso(String nome, String descricao, int cargaHoraria) {
        this.id = contador;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
