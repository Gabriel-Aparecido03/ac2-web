package ac2.ac2.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private List<Long> cursosId;
    private List<Long> agendaId;
}