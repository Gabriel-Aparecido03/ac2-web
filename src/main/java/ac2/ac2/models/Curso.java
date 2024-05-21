package ac2.ac2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String descricao;
    @Column(nullable = false)
    private String cargaHoraria;
    @Column(nullable = false, length = 300)
    private String objetivo;
    @Column(nullable = false, length = 400)
    private String ementa;
    @ManyToMany(mappedBy = "cursos")
    private List<Professor> professores;
    @OneToMany(mappedBy = "curso")
    private List<Agenda> agendas;
}