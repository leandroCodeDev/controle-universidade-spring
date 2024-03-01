package com.api.universidadecontroler.services;

import com.api.universidadecontroler.dtos.CursoDto;
import com.api.universidadecontroler.models.Curso;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CursoService {
    public CursoDto cadastrar(CursoDto dto ) throws Exception {
        Curso curso = new Curso(dto.nome, dto.descricao,dto.cargaHoraria);

        if(!Curso.incluirCurso(curso)){
            throw  new Exception("Ocorreu um erro ao tentar adicionar curso no \"banco de dados\"");
        }
        return new CursoDto(curso.getId(),curso.getNome(),curso.getDescricao(),curso.getCargaHoraria());

    }

    public List<CursoDto> buscarTodos(){
        ArrayList list = new ArrayList<CursoDto>();
        for(Curso curso:Curso.getCursos()){
            CursoDto dto = new CursoDto(curso.getId(),curso.getNome(),curso.getDescricao(),curso.getCargaHoraria());
            list.add(dto);
        }
        return list;
    }
    public CursoDto buscarPorId(Integer id){
        for(Curso curso:Curso.getCursos()){
            if(curso.getId() == id){
                return new CursoDto(curso.getId(),curso.getNome(),curso.getDescricao(),curso.getCargaHoraria());
            }
        }
        return new CursoDto();
    }


    public boolean update(Integer id, CursoDto dto) {
        for(Curso curso:Curso.getCursos()){
            if(curso.getId() == id){
                if(!dto.nome.isBlank()){
                    curso.setNome(dto.nome);
                }
                if(!dto.descricao.isBlank()){
                    curso.setNome(dto.descricao);
                }
                if(dto.cargaHoraria != 0){
                    curso.setCargaHoraria(dto.cargaHoraria);
                }
                return true;
            }
        }
        return false;
    }
}
