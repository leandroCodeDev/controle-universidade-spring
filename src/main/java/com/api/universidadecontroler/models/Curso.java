package com.api.universidadecontroler.models;

import java.util.ArrayList;

public class Curso {

    private static ArrayList<Curso> cursos = new ArrayList<>();

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

    public static boolean incluirCurso(Curso Curso) {
        return cursos.add(Curso);
    }
    public static ArrayList<Curso> getCursos() {
        return cursos;
    }
}
