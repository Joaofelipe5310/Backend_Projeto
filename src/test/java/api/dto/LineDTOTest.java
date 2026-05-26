package api.dto;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class LineDTOTest {

    @Test
    public void testConstructor() {

        int id = 1;
        String name = "linetest";
        List<CategoryDTO> listcategories = new ArrayList<>();
        CategoryDTO category = new CategoryDTO();
        category.setId(1);
        category.setName("cattest");
        CategoryDTO category2 = new CategoryDTO();
        category.setId(2);
        category.setName("cattest2");
        listcategories.add(category);
        listcategories.add(category2);

        LineDTO linedto = new LineDTO.Builder().id(id).name(name).categories(listcategories).build();

        assertNotNull(linedto);
        assertEquals(id, linedto.getId());
        assertEquals(name, linedto.getName());
        assertEquals(listcategories, linedto.getCategories());
    }
}