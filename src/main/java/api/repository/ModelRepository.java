package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}