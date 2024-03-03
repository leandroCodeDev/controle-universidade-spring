package com.api.universidadecontroler.services;

import com.api.universidadecontroler.dtos.AlunoDto;
import com.api.universidadecontroler.helpers.DataHelper;
import com.api.universidadecontroler.models.Aluno;
import com.api.universidadecontroler.models.Curso;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Service
public class AlunoService {

    private CursoService cursoService;

    public void setCursoService(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    public AlunoDto cadastrar(AlunoDto dto) throws Exception {
        if (alunoJaCadastrado(dto)) {
            throw new Exception("aluno ja cadastrado na instituição");
        }
        Aluno aluno = new Aluno(dto.nome, DataHelper.converterStringParaData(dto.dataNascimento));
        if (!Aluno.incluirAluno(aluno)) {
            throw new Exception("Ocorreu um erro ao tentar adicionar aluno no \"banco de dados\"");
        }
        return new AlunoDto(aluno.getId(), aluno.getNome(), DataHelper.converterDataParaString(aluno.getDataNascimento()));


    }

    public List<AlunoDto> buscarTodos() {
        ArrayList list = new ArrayList<AlunoDto>();
        for (Aluno aluno : Aluno.getAlunos()) {
            AlunoDto dto = new AlunoDto(aluno.getId(), aluno.getNome(), DataHelper.converterDataParaString(aluno.getDataNascimento()));
            list.add(dto);
        }
        return list;
    }

    public AlunoDto buscarPorId(Integer id) {
        for (Aluno aluno : Aluno.getAlunos()) {
            if (aluno.getId() == id) {
                return new AlunoDto(aluno.getId(), aluno.getNome(), DataHelper.converterDataParaString(aluno.getDataNascimento()));
            }
        }
        return new AlunoDto();
    }

    public Aluno buscarAlunoPorId(Integer id) {
        for (Aluno aluno : Aluno.getAlunos()) {
            if (aluno.getId() == id) {
                return aluno;
            }
        }
        return null;
    }


    public boolean update(Integer id, AlunoDto dto) throws ParseException {
        for (Aluno aluno : Aluno.getAlunos()) {
            if (aluno.getId() == id) {
                if (!dto.nome.isBlank()) {
                    aluno.setNome(dto.nome);
                }
                if (!dto.dataNascimento.isBlank()) {
                    aluno.setDataNascimento(DataHelper.converterStringParaData(dto.dataNascimento));
                }
                return true;
            }
        }
        return false;
    }

    public boolean delete(Integer id){
        Aluno aluno = null;
        for (Aluno a : Aluno.getAlunos()) {
            if (a.getId() == id) {
                aluno = a;
            }
        }
        if(aluno == null){
            return false;
        }
        cursoService.removerAluno(id);

        Aluno.getAlunos().remove(aluno);

        return true;
    }



    private boolean alunoJaCadastrado(AlunoDto dto) {
        for (Aluno a : Aluno.getAlunos()) {
            return (a.getNome().equalsIgnoreCase(dto.nome));
        }
        return false;
    }

}
