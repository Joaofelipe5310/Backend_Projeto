package api.Controller;

import api.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import api.service.CategoryService;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    protected CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryDTO> getCategories() {
        return categoryService.getCategories();
    }
}