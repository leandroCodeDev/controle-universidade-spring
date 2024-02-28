package com.api.universidadecontroler.models;

public class Curso {

    private static int contador = 1;
    private int id;
    private String nome;
    private String descricao;
    private int vargaHoraria;

    private static int  gerarIdAluno(){
        return contador++;
    }

    public Curso(String nome, String descricao, int vargaHoraria) {
        this.id = contador;
        this.nome = nome;
        this.descricao = descricao;
        this.vargaHoraria = vargaHoraria;
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

    public int getVargaHoraria() {
        return vargaHoraria;
    }

    public void setVargaHoraria(int vargaHoraria) {
        this.vargaHoraria = vargaHoraria;
    }
}
