package ac2.ac2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ac2.ac2.models.Agenda;
import ac2.ac2.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
  @Query("select a from Agenda a where a.professor.id = :id")
  Optional<List<Agenda>> agendasDoProfessor(@Param("id") Long id);
}