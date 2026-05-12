package api.dto;

import java.util.List;

public class LineDTO {

   private static int id;
   private String name;
   private List<CategoryDTO> categories;

  public LineDTO() {
  }

  public LineDTO(Builder builder) {
       this.id = builder.id;
       this.name = builder.name;
       this.categories = builder.categories;
   }

    public static class Builder {
      private int id;
       private String name;
       private List<CategoryDTO> categories;

       public Builder id() {
           this.id = id;
           return this;
       }

       public Builder name(String name) {
           this.name = name;
           return this;
       }

       public Builder categories(List<CategoryDTO> categories) {
           this.categories = categories;
           return this;
       }

       public LineDTO build() {
           return new LineDTO(this);
       }

       public static Builder builder() {
           return new Builder();
       }
  }

    public int getId() {return id; }

    public String getName() { return name; }

    public List<CategoryDTO> getCategories() { return categories;}

    @Override
     public String toString() {
         return name;
     }
}