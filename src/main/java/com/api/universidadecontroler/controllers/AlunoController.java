package com.api.universidadecontroler.controllers;

import com.api.universidadecontroler.dtos.AlunoDto;
import com.api.universidadecontroler.services.AlunoService;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }



    @GetMapping
    public List<AlunoDto> get() {
        return alunoService.buscarTodos();
    }



    @GetMapping("{id}")
    public AlunoDto getId(@PathVariable Integer id){
        return alunoService.buscarPorId(id);
    }

    @GetMapping("{id}")
    public boolean update(@PathVariable Integer id,@RequestBody AlunoDto dto) throws ParseException {
        return alunoService.update(id,dto);
    }


    @PostMapping("")
    public AlunoDto create(@RequestBody AlunoDto dto) throws Exception {
        return alunoService.cadastrar(dto);
    }


}
