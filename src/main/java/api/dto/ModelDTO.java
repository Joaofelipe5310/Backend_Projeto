package api.dto;

public class ModelDTO {

    private int id;
    private String name;

    public ModelDTO() {

    }

    public ModelDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class Builder {
        private int id;
        private String name;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public ModelDTO build() {
            return new ModelDTO(this);
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}