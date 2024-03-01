package com.api.universidadecontroler.models;

import java.util.ArrayList;

public class Curso {

    private static ArrayList<Curso> cursos = new ArrayList<>();

    private static Integer contador = 1;
    private Integer id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    private ArrayList<Aluno> alunos = new ArrayList<>();

    private static Integer  gerarIdAluno(){
        return contador++;
    }

    public Curso(String nome, String descricao, Integer cargaHoraria) {
        this.id = contador;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getId() {
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

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public static boolean incluirCurso(Curso Curso) {
        return cursos.add(Curso);
    }
    public static ArrayList<Curso> getCursos() {
        return cursos;
    }
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public boolean matricularAluno(Aluno aluno){
        return alunos.add(aluno);
    }
}
