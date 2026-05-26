package api.entity;
import javax.persistence.*;

@Entity
@Table(name = "Modelo")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Categoria_id")
    private Category categories;

    public Model() {}

    public Model(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {return name;}

    public Category getCategories() {
        return categories;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }
}