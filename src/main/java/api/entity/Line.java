package api.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Linha")
public class Line implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "line",cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();

    public Line() {}

    public Line(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCat(List<Category> categories) {
        this.categories = categories;
    }
}