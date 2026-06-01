package api.dto;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class LineDTOTest {

    @Test
    public void SettersGettersTest() {

        LineDTO line = new LineDTO();
        List<CategoryDTO> categories = new ArrayList<>();
        line.setId(1);
        line.setName("linetest");
        line.setCategories(categories);

        assertEquals(1, line.getId());
        assertEquals("linetest", line.getName());
        assertEquals(categories, line.getCategories());
    }

    @Test
    public void ToStringTest() {

        LineDTO line = new LineDTO();
        line.setName("linetest");

        assertEquals("linetest", line.toString());
    }

    @Test
    public void BuilderTest() {

        List<CategoryDTO> listcategories = new ArrayList<>();
        listcategories.add(new CategoryDTO());

        LineDTO line = LineDTO.Builder.builder().id(1).name("linebuilder").categories(listcategories).build();

        assertEquals(1, line.getId());
        assertEquals("linebuilder", line.getName());
        assertEquals(CategoryDTO.class, line.getCategories().get(0).getClass());
    }
}