package api.service;

import api.dto.CategoryDTO;
import api.dto.ModelDTO;
import api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryDTO> getCategories() {

        return repository.findAll().
                stream().
                map(c -> new CategoryDTO.Builder()
                        .id(c.getId())
                        .name(c.getName())
                        .models(c.getModel()
                                .stream()
                                .map(m -> new ModelDTO.Builder()
                                .id(m.getId())
                                        .name(m.getName())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }
}