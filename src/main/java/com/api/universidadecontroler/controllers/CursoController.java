package com.api.universidadecontroler.controllers;

import com.api.universidadecontroler.dtos.AlunoDto;
import com.api.universidadecontroler.dtos.CursoDto;
import com.api.universidadecontroler.dtos.MatriculaDTO;
import com.api.universidadecontroler.services.AlunoService;
import com.api.universidadecontroler.services.CursoService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }


    @GetMapping
    public List<CursoDto> get() {
        return cursoService.buscarTodos();
    }


    /** Busca por ID */
    @GetMapping("{id}")
    public CursoDto getId(@PathVariable Integer id){
        return cursoService.buscarPorId(id);
    }

    @PutMapping("{id}")
    public boolean update(@PathVariable Integer id,@RequestBody CursoDto dto) throws ParseException {
        return cursoService.update(id,dto);
    }


    @PostMapping("")
    public CursoDto create(@RequestBody CursoDto dto) throws Exception {
        return cursoService.cadastrar(dto);
    }

    @PostMapping("{idCurso}")
    public boolean matricularAluno(@PathVariable Integer idCurso, @RequestBody MatriculaDTO matriculaDTO) throws Exception {
        return cursoService.matricularAluno(idCurso,matriculaDTO);
    }



}
