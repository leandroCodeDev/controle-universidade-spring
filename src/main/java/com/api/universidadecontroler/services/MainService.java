package com.api.universidadecontroler.services;


import org.springframework.stereotype.Service;

@Service
public class MainService {

    private final CursoService cursoService;
    private final AlunoService alunoService;

    public MainService(CursoService cursoService, AlunoService alunoService) {
        this.cursoService = cursoService;
        this.alunoService = alunoService;
        this.cursoService.setAlunoService(this.alunoService);
        this.alunoService.setCursoService(this.cursoService);


    }

    public CursoService getCursoService() {
        return cursoService;
    }

    public AlunoService getAlunoService() {
        return alunoService;
    }
}
