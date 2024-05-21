package ac2.ac2.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosProfessorDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
}