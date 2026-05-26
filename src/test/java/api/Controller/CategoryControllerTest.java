package api.Controller;

import api.dto.CategoryDTO;
import api.dto.ModelDTO;
import api.service.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = CategoryController.class)
public class CategoryControllerTest {

    CategoryController controller;

    CategoryService service;

    @Before
    public void setUp() {

        service = mock(CategoryService.class);

        controller = new CategoryController();

        controller.categoryService = service;
    }

    @Test
    public void getCategoryTest() {

        ModelDTO model = new ModelDTO();
        model.setName("MODELO TESTE");
        ModelDTO model2 = new ModelDTO();
        model2.setName("MODELO TESTE 2");
        CategoryDTO category = new CategoryDTO();
        category.setName("CATEGORIA TESTE");
        category.setModels(Collections.singletonList(model));
        CategoryDTO category2 = new CategoryDTO();
        category2.setName("CATEGORIA TESTE 2");
        category2.setModels(Collections.singletonList(model2));
        List<CategoryDTO> fakecategory = new ArrayList<>();
        fakecategory.add(category);
        fakecategory.add(category2);

        when(service.getCategories()).thenReturn(fakecategory);
        controller.getCategories();

        assertEquals(fakecategory.toString(), service.getCategories().toString());
    }
}