package API.Controller;

import API.DTO.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import API.service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService catService;

    @GetMapping("/cats")

    public List<CategoryDTO> getCategorys() {
        return catService.getCatDTO();
    }
}