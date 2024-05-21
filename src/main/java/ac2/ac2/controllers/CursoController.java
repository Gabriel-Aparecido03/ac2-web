package ac2.ac2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ac2.ac2.dtos.CursoDTO;
import ac2.ac2.dtos.DadosCursoDTO;
import ac2.ac2.dtos.DadosProfessorDTO;
import ac2.ac2.services.CursoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    CursoServiceImpl service;

    @PostMapping
    public void inserir(@RequestBody CursoDTO curso) {
        service.inserir(curso);
    }

    @GetMapping
    public List<DadosCursoDTO> obterTodos() {
        return service.obterTodos();
    }

    @GetMapping("{id}")
    public List<DadosProfessorDTO> professoresDoCurso(@PathVariable Long id) {
        return service.obterProfessoresPorCurso(id);
    }

}