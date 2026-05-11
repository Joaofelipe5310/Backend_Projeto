package api.repository;

import api.entity.Line;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepository extends JpaRepository<Line, Integer> {

    @Query("SELECT l.id FROM Line l")
    List<Integer> findAllIds();
}
