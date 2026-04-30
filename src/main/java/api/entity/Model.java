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

    public String getName() {return name;}

    public Category getCategories() {
        return categories;
    }

}