package api.service;

import api.dto.CategoryDTO;
import api.dto.ModelDTO;
import api.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryDTO> getCatDTO(){

        return repository.findAll().
                stream().
                map(u -> new CategoryDTO(
                u.getId(),
                u.getName(),
                        u.getModel().stream().map(model -> new ModelDTO(
                                model.getId(),
                                model.getName()
                        )).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}