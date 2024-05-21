package ac2.ac2.services;


import java.util.List;

import ac2.ac2.dtos.DadosProfessorDTO;
import ac2.ac2.dtos.ProfessorDTO;

public interface ProfessorService {
    void inserir(ProfessorDTO dto);
    List<DadosProfessorDTO> obterTodos();
}