package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

        @Query("SELECT l.id FROM Category l")
        List<Integer> findAllIds();
}