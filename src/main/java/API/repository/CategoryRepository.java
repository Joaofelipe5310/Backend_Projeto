package API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import API.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}