package API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import API.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}