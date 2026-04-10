package API.DTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {

    private int id;
    private String name;
    private List<ModelDTO> models;

    public CategoryDTO(int id, String name, List<ModelDTO> models) {
        this.id = id;
        this.name = name;
        this.models = models;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<ModelDTO> getModels() { return models; }
}