package ac2.ac2.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate dataInicial;
    @Column(nullable = false)
    private LocalDate dataFinal;
    @Column(nullable = false)
    private LocalTime horarioInicial;
    @Column(nullable = false)
    private LocalTime horarioFinal;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String cep;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @Column(length = 400)
    private String resumo;

}