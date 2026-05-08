package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api.entity.Model;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

    List<Model> findByNameIsNotNull();
}