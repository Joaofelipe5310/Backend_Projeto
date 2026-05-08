package api.repository;

import api.entity.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepository extends JpaRepository<Line, String> {

    @Query(value = "SELECT * FROM Linha", nativeQuery = true)
    List<Line> findByNameIsNotNull();

    List<Line> findByNameIn(List<String> name);

    @Query("SELECT l FROM Line l")
    List<Line> getAllLines();

}
