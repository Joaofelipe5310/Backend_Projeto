package api.Controller;

import api.dto.CategoryDTO;
import api.dto.LineDTO;
import api.dto.ModelDTO;
import api.service.LineService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = LineController.class)
public class LineControllerTest {

    LineController controller;

    LineService service;

    @Before
    public void setUp() {

        service = mock(LineService.class);

        controller = new LineController();

        controller.lineService = service;

    }

    @Test
    public void getLinesSucessTest() {

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
        LineDTO line = new LineDTO();
        line.setName("LINHA TESTE");
        line.setCategories(Collections.singletonList(category));
        LineDTO line2 = new LineDTO();
        line2.setName("LINHA TESTE 2");
        line2.setCategories(Collections.singletonList(category2));
        List<LineDTO> fakelines = new ArrayList<>();
        fakelines.add(line);
        fakelines.add(line2);

        when(service.getLines()).thenReturn(fakelines);
        controller.getLines();

        assertEquals(fakelines.toString(), service.getLines().toString());

    }
}