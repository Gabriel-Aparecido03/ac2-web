package ac2.ac2.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac2.ac2.dtos.AgendaDTO;
import ac2.ac2.dtos.DadosAgendaDTO;
import ac2.ac2.dtos.ResumoDTO;
import ac2.ac2.services.AgendaServiceImpl;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    @Autowired
    AgendaServiceImpl service;

    @PostMapping
    public void inserir(@RequestBody AgendaDTO agenda){
        service.inserir(agenda);
    }

    @GetMapping
    public List<DadosAgendaDTO> obterTodos(){
        return service.obterTodos();
    }

    /* Irá pegar agenda pelo id do professor e pela */
    @GetMapping("{id}/{data}")
    public List<DadosAgendaDTO> agendasProfessorPorData(@PathVariable Long id, @PathVariable LocalDate data){
        return service.agendaProfessorPorData(id, data);
    }


    /* Irá pegar agenda pelo id do professor */
    @GetMapping("{id}")
    public List<DadosAgendaDTO> agendasProfessor(@PathVariable Long id){
        return service.agendasProfessor(id);
    }

    @PutMapping({"{id}"})
    public void adicionarResumo(@PathVariable Long id,@RequestBody ResumoDTO resumoDTO){
        service.adicionarResumo(resumoDTO,id);
    }
}