package api.dto;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CategoryDTOTest {

    @Test
    public void testConstructor() {

        int id = 1;
        String name = "cattest";
        List<ModelDTO> modelslist = new ArrayList<>();
        ModelDTO model = new ModelDTO();
        model.setId(1);
        model.setName("modeltest");
        ModelDTO model2 = new ModelDTO();
        model.setId(2);
        model.setName("modeltest2");
        modelslist.add(model);
        modelslist.add(model2);

        CategoryDTO categorydto = new CategoryDTO.Builder().id(id).name(name).models(modelslist).build();

        assertNotNull(categorydto);
        assertEquals(id, categorydto.getId());
        assertEquals(name, categorydto.getName());
        assertEquals(modelslist, categorydto.getModels());
    }
}