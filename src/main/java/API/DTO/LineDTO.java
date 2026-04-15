package API.DTO;

import java.util.List;
import java.util.stream.Collector;

public class LineDTO {

    private int id;
    private String name;
    private List<CategoryDTO> cat;

    public LineDTO(){

    }

    public LineDTO(int  id, String name,  List<CategoryDTO> cat) {
        this.id = id;
        this.name = name;
        this.cat = cat;

    }

    public int getId(){return id; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }

    public List<CategoryDTO> getCat() { return cat;}

}