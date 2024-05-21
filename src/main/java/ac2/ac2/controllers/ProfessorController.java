package ac2.ac2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac2.ac2.dtos.DadosProfessorDTO;
import ac2.ac2.dtos.ProfessorDTO;
import ac2.ac2.services.ProfessorServiceImpl;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired
    ProfessorServiceImpl service;

    @PostMapping
    public void inserir(@RequestBody ProfessorDTO professor){
        service.inserir(professor);
    }

    @GetMapping
    public List<DadosProfessorDTO> obterTodos(){
        return service.obterTodos();
    }
}