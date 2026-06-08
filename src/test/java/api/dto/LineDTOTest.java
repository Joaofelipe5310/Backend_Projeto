package api.dto;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class LineDTOTest {

    LineDTO line;
    List<CategoryDTO> categories;

    @Before
    public void setUp() {
        line = new LineDTO();
        categories = new ArrayList<>();
    }

    @Test
    public void setIdTest() {
        line.setId(1);

        assertEquals(1, line.getId());
    }

    @Test
    public void getIdTest() {
        line.setId(2);

        assertEquals(2, line.getId());
    }

    @Test
    public void setNameTest() {
        line.setName("setLineTest");

        assertEquals("setLineTest", line.getName());
    }

    @Test
    public void getNameTest() {
        line.setName("getLineTest");

        assertEquals("getLineTest", line.getName());
    }

    @Test
    public void setCategoriesTest() {
        line.setCategories(categories);

        assertEquals(categories, line.getCategories());
    }

    @Test
    public void getCategoriesTest() {
        line.setCategories(categories);

        assertEquals(categories, line.getCategories());
    }

    @Test
    public void toStringTest() {
        line.setName("lineTest");

        assertEquals("lineTest", line.toString());
    }

    @Test
    public void builderTest() {
        categories.add(new CategoryDTO());
        LineDTO line = LineDTO.Builder.builder().id(1).name("linebuilder").categories(categories).build();

        assertEquals(1, line.getId());
        assertEquals("linebuilder", line.getName());
        assertEquals(CategoryDTO.class, line.getCategories().get(0).getClass());
    }
}