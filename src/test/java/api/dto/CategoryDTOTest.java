package api.dto;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CategoryDTOTest {

    @Test
    public void SettersGettersTest() {

        CategoryDTO category = new CategoryDTO();
        List<ModelDTO> models = new ArrayList<>();
        category.setModels(models);
        category.setName("categorytest");
        category.setId(1);

        assertEquals(1, category.getId());
        assertEquals("categorytest", category.getName());
        assertEquals(models, category.getModels());
    }

    @Test
    public void ToStringTest() {

        CategoryDTO category = new CategoryDTO();
        category.setName("categorytest");

        assertEquals("categorytest", category.toString());
    }

    @Test
    public void BuilderTest() {

        List<ModelDTO> listmodels = new ArrayList<>();
        listmodels.add(new ModelDTO());

        CategoryDTO category = CategoryDTO.Builder.builder().id(1).name("categorybuilder").models(listmodels).build();

        assertEquals(1, category.getId());
        assertEquals("categorybuilder", category.getName());
        assertEquals(ModelDTO.class, category.getModels().get(0).getClass());

    }
}