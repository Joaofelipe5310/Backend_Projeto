package api.service;

import api.dto.CategoryDTO;
import api.dto.ModelDTO;
import api.entity.Category;
import api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import api.service.ModelService;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<CategoryDTO> getCategories() {


        List<Category> categories = repository.findByNameIsNotNull();

             return categories.
                     stream().
                     map(c -> new CategoryDTO.Builder()
                             .name(c.getName())
                             .models(c.getModel()
                                     .stream()
                                     .map(m -> new ModelDTO.Builder()
                                             .name(m.getName())
                                             .build())
                                     .collect(Collectors.toList()))
                             .build())
                     .collect(Collectors.toList());

    }
}