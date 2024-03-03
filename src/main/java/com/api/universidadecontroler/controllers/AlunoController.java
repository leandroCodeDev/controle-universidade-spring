package com.api.universidadecontroler.controllers;

import com.api.universidadecontroler.dtos.AlunoDto;
import com.api.universidadecontroler.services.AlunoService;
import com.api.universidadecontroler.services.CursoService;
import com.api.universidadecontroler.services.MainService;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(MainService mainService) {

        this.alunoService = mainService.getAlunoService();
        this.alunoService.setCursoService(mainService.getCursoService());
    }



    @GetMapping
    public List<AlunoDto> get() {
        return alunoService.buscarTodos();
    }



    @GetMapping("{id}")
    public AlunoDto getId(@PathVariable Integer id){
        return alunoService.buscarPorId(id);
    }

    @PutMapping("{id}")
    public boolean update(@PathVariable Integer id,@RequestBody AlunoDto dto) throws ParseException {
        return alunoService.update(id,dto);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id) throws ParseException {
        return alunoService.delete(id);
    }


    @PostMapping("")
    public AlunoDto create(@RequestBody AlunoDto dto) throws Exception {
        return alunoService.cadastrar(dto);
    }


}
