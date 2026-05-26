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
        model.setId(1);
        model.setName("MODELO TESTE");
        Model model2 = new Model();
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
        repository.findAllIds();
        repository.findAllById(idsfake);
        service.getModels();

        assertEquals(modelsfake.get(1).getName(), "MODELO TESTE 2");
        assertEquals(modelsfake.get(0).getName(), "MODELO TESTE");
    }
}