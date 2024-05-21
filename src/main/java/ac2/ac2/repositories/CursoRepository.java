package ac2.ac2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ac2.ac2.models.Curso;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    @Query("select c from Curso c left join fetch c.professores p where c.id = :id ")
    Optional<Curso> findCursoByProfessorId(@Param("id") Long id);
}