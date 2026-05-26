package api.dto;

import org.junit.Test;
import static org.junit.Assert.*;

public class ModelDTOTest {

    @Test
    public void testConstructor() {

        int id = 1;
        String name = "modeltest";

        ModelDTO modeldto = new ModelDTO.Builder().id(id).name(name).build();

        assertNotNull(modeldto);
        assertEquals(id, modeldto.getId());
        assertEquals(name, modeldto.getName());
    }
}