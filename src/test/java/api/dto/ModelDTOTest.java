package api.dto;

import org.junit.Test;
import static org.junit.Assert.*;

public class ModelDTOTest {

    @Test
    public void SettersGettersTest() {

        ModelDTO model = new ModelDTO();
        model.setName("modeltest");
        model.setId(1);

        assertEquals(1, model.getId());
        assertEquals("modeltest", model.getName());
    }

    @Test
    public void ToStringTest() {

        ModelDTO model = new ModelDTO();
        model.setName("modeltest");

        assertEquals("modeltest", model.toString());
    }

    @Test
    public void BuilderTest() {

        ModelDTO model = ModelDTO.Builder.builder().name("modelbuilder").id(1).build();

        assertEquals("modelbuilder", model.getName());
        assertEquals(1, model.getId());
    }
}