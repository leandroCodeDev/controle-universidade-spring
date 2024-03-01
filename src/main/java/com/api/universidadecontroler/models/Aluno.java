package com.api.universidadecontroler.models;

import com.api.universidadecontroler.dtos.AlunoDto;
import com.api.universidadecontroler.helpers.DataHelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
public class Aluno {

    private static ArrayList<Aluno> alunos = new ArrayList<>();
    private static Integer contador = 1;
    private Integer id;
    private String nome;
    private Date dataNascimento;

    private static Integer  gerarIdAluno(){
        return contador++;
    }

    public Aluno(String nome, Date dataNascimento) {
        this.id = gerarIdAluno();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public static boolean incluirAluno(Aluno aluno) {
        return alunos.add(aluno);
    }

    public static ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date data_nascimento) {
        this.dataNascimento = data_nascimento;
    }
}
