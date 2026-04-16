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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCat(Category categories) {
        this.categories = categories;
    }
}