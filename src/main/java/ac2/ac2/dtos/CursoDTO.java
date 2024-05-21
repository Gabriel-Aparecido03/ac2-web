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
public class CursoDTO {
    private Long id;
    private String descricao;
    private String cargaHoraria;
    private String objetivo;
    private String ementa;
    private List<Long> professoresId;
    private List<Long> agendasId;
}