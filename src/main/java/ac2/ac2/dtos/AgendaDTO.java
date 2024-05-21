package ac2.ac2.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgendaDTO {
    private Long id;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalTime horarioInicial;
    private LocalTime horarioFinal;
    private Long professorId;
    private String cidade;
    private String estado;
    private String cep;
    private Long cursoId;
    private String resumo;
}