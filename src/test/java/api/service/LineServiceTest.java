package api.service;

import api.entity.Category;
import api.entity.Line;
import api.entity.Model;
import api.repository.LineRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = LineService.class)
public class LineServiceTest {

    LineRepository repository;

    LineService service;

    @Before
    public void setUp() {

        repository = mock(LineRepository.class);

        service = new LineService();

        service.repository = repository;
    }

    @Test
    public void getLinesTest() {

        Model model = new Model();
        model.setName("MODELO TESTE");
        Model model2 = new Model();
        model2.setName("MODELO TESTE 2");
        Category category = new Category();
        category.setName("CATEGORIA TESTE");
        category.setModel(Collections.singletonList(model));
        Category category2 = new Category();
        category2.setName("CATEGORIA TESTE 2");
        category2.setModel(Collections.singletonList(model2));
        Line line = new Line();
        line.setId(1);
        line.setName("LINHA TESTE");
        line.setCategories(Collections.singletonList(category));
        Line line2 = new Line();
        line2.setId(2);
        line2.setName("LINHA TESTE 2");
        line2.setCategories(Collections.singletonList(category2));
        List<Integer> idsfake = repository.findAllIds();
        idsfake.add(1);
        idsfake.add(2);
        List<Line> linesfake = repository.findAllById(idsfake);
        linesfake.add(line);
        linesfake.add(line2);

        when(repository.findAllIds()).thenReturn(idsfake);
        when(repository.findAllById(idsfake)).thenReturn(linesfake);
        service.getLines();

        assertEquals(linesfake.get(1).getName(), "LINHA TESTE 2");
        assertEquals(linesfake.get(0).getName(), "LINHA TESTE");
        assertEquals(linesfake.get(0).getCategories().get(0).getName(), "CATEGORIA TESTE");
    }
}