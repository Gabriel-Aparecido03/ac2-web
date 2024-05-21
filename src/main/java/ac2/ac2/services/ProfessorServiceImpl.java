package ac2.ac2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2.ac2.dtos.DadosProfessorDTO;
import ac2.ac2.dtos.ProfessorDTO;
import ac2.ac2.models.Curso;
import ac2.ac2.models.Professor;
import ac2.ac2.repositories.CursoRepository;
import ac2.ac2.repositories.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService{
    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    CursoRepository cursoRepository;
    @Override
    public void inserir(ProfessorDTO dto) {

        List<Curso> cursos = dto.getCursosId().stream().map(l -> cursoRepository.findById(l).orElseThrow()).collect(Collectors.toList());
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setCpf(dto.getCpf());
        professor.setEndereco(dto.getEndereco());
        professor.setTelefone(dto.getTelefone());
        professorRepository.save(professor);
        professor = professorRepository.findById(professor.getId()).orElseThrow();
        professor.setCursos(cursos);
        professorRepository.save(professor);
    }

    @Override
    public List<DadosProfessorDTO> obterTodos() {
        List<DadosProfessorDTO> professor = professorRepository.findAll()
                .stream().map( p -> {
                    return DadosProfessorDTO.builder()
                            .id(p.getId())
                            .nome(p.getNome())
                            .cpf(p.getCpf())
                            .endereco(p.getEndereco())
                            .telefone(p.getTelefone())
                            .build();
                }).collect(Collectors.toList());
        return professor;
    }
}