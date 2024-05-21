package ac2.ac2.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosAgendaDTO {
  private Long id;
  private LocalDate dataInicial;
  private LocalDate dataFinal;
  private LocalTime horarioInicial;
  private LocalTime horarioFinal;
  private String professor;
  private String cidade;
  private String estado;
  private String cep;
  private String curso;
  private String resumo;
}
