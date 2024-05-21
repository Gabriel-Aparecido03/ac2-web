package ac2.ac2.services;


import ac2.ac2.dtos.CursoDTO;
import ac2.ac2.dtos.DadosCursoDTO;
import ac2.ac2.dtos.DadosProfessorDTO;

import java.util.List;

public interface CursoService {
    void inserir(CursoDTO cursoDto);
    List<DadosCursoDTO> obterTodos();
    List<DadosProfessorDTO> obterProfessoresPorCurso(Long id);
}