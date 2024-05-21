package ac2.ac2.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2.ac2.dtos.AgendaDTO;
import ac2.ac2.dtos.DadosAgendaDTO;
import ac2.ac2.dtos.ResumoDTO;
import ac2.ac2.models.Agenda;
import ac2.ac2.models.Curso;
import ac2.ac2.models.Professor;
import ac2.ac2.repositories.AgendaRepository;
import ac2.ac2.repositories.CursoRepository;
import ac2.ac2.repositories.ProfessorRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendaServiceImpl implements AgendaService{

    @Autowired
    AgendaRepository agendaRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public void inserir(AgendaDTO dto) {
        Professor professor = professorRepository.findById(dto.getProfessorId()).orElseThrow();
        Curso curso = cursoRepository.findById(dto.getCursoId()).orElseThrow();
        Agenda agenda = new Agenda();
        agenda.setDataInicial(dto.getDataInicial());
        agenda.setDataFinal(dto.getDataFinal());
        agenda.setHorarioInicial(dto.getHorarioInicial());
        agenda.setHorarioFinal(dto.getHorarioFinal());
        agenda.setProfessor(professor);
        agenda.setCidade(dto.getCidade());
        agenda.setEstado(dto.getEstado());
        agenda.setCep(dto.getCep());
        agenda.setCurso(curso);
        agenda.setResumo(dto.getResumo());
        agendaRepository.save(agenda);
    }

    @Override
    public List<DadosAgendaDTO> obterTodos() {
        List<DadosAgendaDTO> agendas = agendaRepository.findAll().stream().map(a -> {
            return DadosAgendaDTO.builder()
                    .id(a.getId())
                    .dataInicial(a.getDataInicial())
                    .dataFinal(a.getDataFinal())
                    .horarioInicial(a.getHorarioInicial())
                    .horarioFinal(a.getHorarioFinal())
                    .professor(a.getProfessor() == null ? null :a.getProfessor().getNome())
                    .cidade(a.getCidade())
                    .estado(a.getEstado())
                    .cep(a.getCep())
                    .resumo(a.getResumo())
                    .curso(a.getCurso()== null ? null :a.getCurso().getEmenta())
                    .build();
        }).collect(Collectors.toList());
        return agendas;
    }

    @Override
    public List<DadosAgendaDTO> agendaProfessorPorData(Long id, LocalDate data) {
        List<DadosAgendaDTO> agendas = agendaRepository.agendasProfessorPorData(id, data).stream().map(a -> {
            return DadosAgendaDTO.builder()
                    .id(a.getId())
                    .dataInicial(a.getDataInicial())
                    .dataFinal(a.getDataFinal())
                    .horarioInicial(a.getHorarioInicial())
                    .horarioFinal(a.getHorarioFinal())
                    .professor(a.getProfessor() == null ? null :a.getProfessor().getNome())
                    .cidade(a.getCidade())
                    .estado(a.getEstado())
                    .cep(a.getCep())
                    .curso(a.getCurso().getId() == null ? null :a.getCurso().getEmenta())
                    .resumo(a.getResumo())
                    .build();
        }).collect(Collectors.toList());
        return agendas;
    }

    @Override
    public List<DadosAgendaDTO> agendasProfessor(Long id) {
        List<DadosAgendaDTO> agendas = professorRepository.agendasDoProfessor(id).orElseThrow().stream().map(a -> {
            return DadosAgendaDTO.builder()
                    .id(a.getId())
                    .dataInicial(a.getDataInicial())
                    .dataFinal(a.getDataFinal())
                    .horarioInicial(a.getHorarioInicial())
                    .horarioFinal(a.getHorarioFinal())
                    .professor(a.getProfessor() == null ? null :a.getProfessor().getNome())
                    .cidade(a.getCidade())
                    .estado(a.getEstado())
                    .cep(a.getCep())
                    .curso(a.getCurso().getId() == null ? null :a.getCurso().getEmenta())
                    .resumo(a.getResumo())
                    .build();
        }).collect(Collectors.toList());
        return agendas;
    }

    @Override
    public void adicionarResumo(ResumoDTO dto, Long id) {
        Agenda agenda = agendaRepository.findById(id).orElseThrow();
        agenda.setResumo(dto.getResumo());
        agendaRepository.save(agenda);
    }
}