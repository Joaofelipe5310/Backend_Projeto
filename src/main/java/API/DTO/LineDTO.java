package API.DTO;

import API.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class LineDTO {

    private int id;
    private String name;
    private List<CategoryDTO> cat;

    public LineDTO(int  id, String name, List<CategoryDTO> cat) {
        this.id = id;
        this.name = name;
        this.cat = cat;

    }

    public int getId(){return id; }

    public String getName() { return name; }

    public List<CategoryDTO> getCat() { return cat;}
}