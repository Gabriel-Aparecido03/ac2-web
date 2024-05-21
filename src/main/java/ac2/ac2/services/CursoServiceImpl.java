package ac2.ac2.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac2.ac2.dtos.CursoDTO;
import ac2.ac2.dtos.DadosCursoDTO;
import ac2.ac2.dtos.DadosProfessorDTO;
import ac2.ac2.models.Curso;
import ac2.ac2.repositories.CursoRepository;
import ac2.ac2.repositories.ProfessorRepository;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public void inserir(CursoDTO cursoDto) {
        Curso curso = new Curso();
        curso.setDescricao(cursoDto.getDescricao());
        curso.setCargaHoraria(cursoDto.getCargaHoraria());
        curso.setObjetivo(cursoDto.getObjetivo());
        curso.setEmenta(cursoDto.getEmenta());
        cursoRepository.save(curso);
    }

    @Override
    public List<DadosCursoDTO> obterTodos() {
        List<DadosCursoDTO> cursos = cursoRepository.findAll().stream().map(c -> {
            return DadosCursoDTO.builder()
                    .id(c.getId())
                    .descricao(c.getDescricao())
                    .cargaHoraria(c.getCargaHoraria())
                    .objetivo(c.getObjetivo())
                    .ementa(c.getEmenta())
                    .professores(c.getProfessores().stream().map(p -> {
                        return DadosProfessorDTO.builder()
                                .id(p.getId())
                                .nome(p.getNome())
                                .cpf(p.getCpf())
                                .endereco(p.getEndereco())
                                .telefone(p.getTelefone())
                                .build();
                    }).collect(Collectors.toList()))
                    .agendas(c.getAgendas() == null ? null
                            : c.getAgendas().stream().map(a -> a.getId()).collect(Collectors.toList()))
                    .build();
        }).collect(Collectors.toList());
        return cursos;
    }

    @Override
    public List<DadosProfessorDTO> obterProfessoresPorCurso(Long id) {
        Curso professores = cursoRepository.findCursoByProfessorId(id).orElseThrow();
        return professores.getProfessores().stream().map(p -> {
            return DadosProfessorDTO.builder()
            .id(p.getId())
            .nome(p.getNome())
            .cpf(p.getCpf())
            .endereco(p.getEndereco())
            .telefone(p.getTelefone())
            .build();
        }).collect(Collectors.toList());
    }
}