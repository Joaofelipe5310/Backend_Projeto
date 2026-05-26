package api.Controller;

import api.dto.ModelDTO;
import api.service.ModelService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = ModelController.class)
public class ModelControllerTest {

    ModelController controller;

    ModelService service;

    @Before
    public void setUp() {

        service = mock(ModelService.class);

        controller = new ModelController();

        controller.modelService = service;
    }

    @Test
    public void getModelsSucessTest() {

        ModelDTO model = new ModelDTO();
        model.setName("MODELO TESTE");
        ModelDTO model2 = new ModelDTO();
        model2.setName("MODELO TESTE 2");

        List<ModelDTO> fakemodels = new ArrayList<>();
        fakemodels.add(model);
        fakemodels.add(model2);

        when(service.getModels()).thenReturn(fakemodels);
        controller.getModels();

        assertEquals(fakemodels.toString(), service.getModels().toString());

    }
}