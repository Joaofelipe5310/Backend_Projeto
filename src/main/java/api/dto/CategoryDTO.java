package api.dto;

import java.util.List;

public class CategoryDTO {

    private int id;
    private String name;
    private List<ModelDTO> models;

    public CategoryDTO() {
    }

    public CategoryDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.models = builder.models;
    }

    public static class Builder {
        private int id;
        private String name;
        private List<ModelDTO> models;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder models(List<ModelDTO> models) {
            this.models = models;
            return this;
        }

        public CategoryDTO build() {
            return new CategoryDTO(this);
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public List<ModelDTO> getModels() { return models; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModels(List<ModelDTO> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return name;
    }
}