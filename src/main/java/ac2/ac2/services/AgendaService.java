package ac2.ac2.services;

import java.time.LocalDate;
import java.util.List;

import ac2.ac2.dtos.AgendaDTO;
import ac2.ac2.dtos.DadosAgendaDTO;
import ac2.ac2.dtos.ResumoDTO;

public interface AgendaService {
    void inserir(AgendaDTO dto);
    List<DadosAgendaDTO> obterTodos();
    List<DadosAgendaDTO> agendaProfessorPorData(Long id, LocalDate data);
    List<DadosAgendaDTO> agendasProfessor(Long id);
    void adicionarResumo(ResumoDTO dto, Long id);
}
