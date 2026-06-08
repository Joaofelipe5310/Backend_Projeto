package api.dto;

import org.checkerframework.common.value.qual.BottomVal;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CategoryDTOTest {

    CategoryDTO category;
    List<ModelDTO> models;

    @Before
    public void setUp() {
        category = new CategoryDTO();
        models = new ArrayList<>();
    }

    @Test
    public void setIdTest() {
        category.setId(1);

        assertEquals(1, category.getId());
    }

    @Test
    public void getIdTest() {
        category.setId(2);

        assertEquals(2, category.getId());
    }

    @Test
    public void setNameTest() {
        category.setName("categoryTest");

        assertEquals("categoryTest", category.getName());
    }

    @Test
    public void getNameTest() {
        category.setName("categoryTest");

        assertEquals("categoryTest", category.getName());
    }

    @Test
    public void setModelsTest() {
        category.setModels(models);

        assertEquals(models, category.getModels());
    }

    @Test
    public void getModelsTest() {
        category.setModels(models);

        assertEquals(models, category.getModels());
    }

    @Test
    public void toStringTest() {
        category.setName("categoryTest");

        assertEquals("categoryTest", category.toString());
    }

    @Test
    public void builderTest() {
        models.add(new ModelDTO());
        CategoryDTO category = CategoryDTO.Builder.builder().id(1).name("categorybuilder").models(models).build();

        assertEquals(1, category.getId());
        assertEquals("categorybuilder", category.getName());
        assertEquals(ModelDTO.class, category.getModels().get(0).getClass());
    }
}