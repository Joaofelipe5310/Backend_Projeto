package api.service;

import api.entity.Category;
import api.entity.Model;
import api.repository.CategoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = CategoryService.class)
public class CategoryServiceTest {

    CategoryRepository repository;

    CategoryService service;

    @Before
    public void setUp() {
        repository = mock(CategoryRepository.class);
        service = new CategoryService();

        service.repository = repository;
    }

    @Test
    public void getLinesTest() {
        Model model = new Model();
        Model model2 = new Model();

        model.setName("MODELO TESTE");
        model2.setName("MODELO TESTE 2");

        Category category = new Category();
        Category category2 = new Category();

        category.setId(1);
        category.setName("CATEGORIA TESTE");
        category.setModel(Collections.singletonList(model));

        category2.setId(2);
        category2.setName("CATEGORIA TESTE 2");
        category2.setModel(Collections.singletonList(model2));

        List<Integer> idsfake = repository.findAllIds();
        idsfake.add(1);
        idsfake.add(2);
        List<Category> categoriesfake = repository.findAllById(idsfake);
        categoriesfake.add(category);
        categoriesfake.add(category2);

        when(repository.findAllIds()).thenReturn(idsfake);
        when(repository.findAllById(idsfake)).thenReturn(categoriesfake);

        assertEquals("CATEGORIA TESTE", service.getCategories().get(0).getName());
    }
}