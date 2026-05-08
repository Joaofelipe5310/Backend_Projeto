package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

        List<Category> findByNameIsNotNull();

}