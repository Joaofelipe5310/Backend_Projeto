package api.service;

import api.entity.Model;
import api.repository.ModelRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = ModelService.class)
public class ModelServiceTest {

    ModelRepository repository;

    ModelService service;

    @Before
    public void setUp() {
        repository = mock(ModelRepository.class);
        service = new ModelService();

        service.repository = repository;
    }

    @Test
    public void getLinesTest() {
        Model model = new Model();
        Model model2 = new Model();

        model.setId(1);
        model.setName("MODELO TESTE");
        model2.setId(2);
        model2.setName("MODELO TESTE 2");

        List<Integer> idsfake = repository.findAllIds();
        idsfake.add(1);
        idsfake.add(2);
        List<Model> modelsfake = repository.findAllById(idsfake);
        modelsfake.add(model);
        modelsfake.add(model2);

        when(repository.findAllIds()).thenReturn(idsfake);
        when(repository.findAllById(idsfake)).thenReturn(modelsfake);

        assertEquals("MODELO TESTE", service.getModels().get(0).getName());
        assertEquals("MODELO TESTE 2", service.getModels().get(1).getName());
    }
}