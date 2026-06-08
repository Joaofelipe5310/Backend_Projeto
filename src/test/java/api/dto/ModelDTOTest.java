package api.dto;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModelDTOTest {

    ModelDTO model;

    @Before
    public void setUp() {
        model = new ModelDTO();
    }

    @Test
    public void setIdTest() {
        model.setId(1);

        assertEquals(1, model.getId());
    }

    @Test
    public void getIdTest() {
        model.setId(2);

        assertEquals(2, model.getId());
    }

    @Test
    public void setNameTest() {
        model.setName("modelTest");

        assertEquals("modelTest", model.getName());
    }

    @Test
    public void getNameTest() {
        model.setName("modelTest");

        assertEquals("modelTest", model.getName());
    }

    @Test
    public void toStringTest() {
        model.setName("modelTest");

        assertEquals("modelTest", model.toString());
    }

    @Test
    public void builderTest() {
        ModelDTO model = ModelDTO.Builder.builder().name("modelbuilder").id(1).build();

        assertEquals("modelbuilder", model.getName());
        assertEquals(1, model.getId());
    }
}