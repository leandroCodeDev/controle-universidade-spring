package com.api.universidadecontroler.controllers;

import com.api.universidadecontroler.dtos.CursoDto;
import com.api.universidadecontroler.dtos.MatriculaDTO;
import com.api.universidadecontroler.services.AlunoService;
import com.api.universidadecontroler.services.CursoService;
import com.api.universidadecontroler.services.MainService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {


    private final CursoService cursoService;

    public CursoController(MainService mainService) {

        this.cursoService = mainService.getCursoService();
        this.cursoService.setAlunoService(mainService.getAlunoService());
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
    public boolean update(@PathVariable Integer id,@RequestBody CursoDto dto){
        return cursoService.update(id,dto);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id){
        return cursoService.delete(id);
    }

    @PostMapping("")
    public CursoDto create(@RequestBody CursoDto dto) throws Exception {
        return cursoService.cadastrar(dto);
    }

    @PostMapping("{idCurso}/matricular")
    public boolean matricularAluno(@PathVariable Integer idCurso, @RequestBody MatriculaDTO matriculaDTO) throws Exception {
        return cursoService.matricularAluno(idCurso,matriculaDTO);
    }



}
