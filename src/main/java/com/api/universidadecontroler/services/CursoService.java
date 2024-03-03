package com.api.universidadecontroler.services;

import com.api.universidadecontroler.dtos.AlunoDto;
import com.api.universidadecontroler.dtos.CursoDto;
import com.api.universidadecontroler.dtos.MatriculaDTO;
import com.api.universidadecontroler.helpers.DataHelper;
import com.api.universidadecontroler.models.Aluno;
import com.api.universidadecontroler.models.Curso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CursoService {

    private AlunoService alunoService;

    public void setAlunoService(AlunoService alunoService){
        this.alunoService = alunoService;
    }


    public CursoDto cadastrar(CursoDto dto) throws Exception {
        if(cursoJaCadastrado(dto)){
            throw new Exception("Curso ja cadastrado na instituição");
        }
        Curso curso = new Curso(dto.nome, dto.descricao, dto.cargaHoraria);

        if (!Curso.incluirCurso(curso)) {
            throw new Exception("Ocorreu um erro ao tentar adicionar curso no \"banco de dados\"");
        }
        return new CursoDto(curso.getId(), curso.getNome(), curso.getDescricao(), curso.getCargaHoraria());

    }

    public List<CursoDto> buscarTodos() {
        ArrayList<CursoDto> list = new ArrayList<>();
        for (Curso curso : Curso.getCursos()) {
            CursoDto dto = new CursoDto(curso.getId(), curso.getNome(), curso.getDescricao(), curso.getCargaHoraria());
            for(Aluno a: curso.getAlunos()){
                AlunoDto dtoAluno = new AlunoDto(a.getId(),a.getNome(), DataHelper.converterDataParaString(a.getDataNascimento()));
                dto.alunos.add(dtoAluno);
            }
            list.add(dto);
        }
        return list;
    }

    public CursoDto buscarPorId(Integer id) {
        for (Curso curso : Curso.getCursos()) {
            if (curso.getId() == id) {
                CursoDto dto = new CursoDto(curso.getId(), curso.getNome(), curso.getDescricao(), curso.getCargaHoraria());
                for(Aluno a: curso.getAlunos()){
                    AlunoDto dtoAluno = new AlunoDto(a.getId(),a.getNome(), DataHelper.converterDataParaString(a.getDataNascimento()));
                    dto.alunos.add(dtoAluno);
                }
                return dto;
            }
        }
        return new CursoDto();
    }


    public boolean update(Integer id, CursoDto dto) {
        for (Curso curso : Curso.getCursos()) {
            if (curso.getId() == id) {
                if (!dto.nome.isBlank()) {
                    curso.setNome(dto.nome);
                }
                if (!dto.descricao.isBlank()) {
                    curso.setNome(dto.descricao);
                }
                if (dto.cargaHoraria != 0) {
                    curso.setCargaHoraria(dto.cargaHoraria);
                }
                return true;
            }
        }
        return false;
    }


    public boolean delete(Integer id) {
        Curso curso = null;
        for (Curso c : Curso.getCursos()) {
            if (c.getId() == id) {
                curso = c;
            }
        }
        if(curso == null){
            return false;
        }
        return Curso.getCursos().remove(curso);
    }

    public boolean matricularAluno(Integer idCurso, MatriculaDTO matriculaDTO) throws Exception {
        Curso curso = null;
        Aluno aluno = null;
        for (Curso c : Curso.getCursos()) {
            if (c.getId() == idCurso) {
                curso = c;
            }
        }

        aluno = alunoService.buscarAlunoPorId(matriculaDTO.getIdAluno());

        if (aluno == null || curso == null) {
            return false;
        }

        if(alunoJaMatriculado(curso,aluno)){
            throw new Exception("aluno ja cadastrado no curso da instituição");
        }

        return curso.matricularAluno(aluno);
    }

    public void removerAluno(Integer idAluno){
        Curso.removerAluno(idAluno);
    }


    private boolean alunoJaMatriculado(Curso curso, Aluno aluno) {
        for (Aluno a : curso.getAlunos()) {
            return (a.getId() == aluno.getId());
        }
        return false;
    }



    private boolean cursoJaCadastrado(CursoDto dto) {
        for (Curso c : Curso.getCursos()) {
            return (c.getNome().equalsIgnoreCase(dto.nome));
        }
        return false;
    }


}
