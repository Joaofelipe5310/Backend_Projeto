package api.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categoria")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Linha_id")
    private Line line;

    @OneToMany(mappedBy = "categories",cascade = CascadeType.ALL)
    private List<Model> model = new ArrayList<>();

    public Category() {}

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Line getLine() {return line;}

    public List<Model> getModel() {
        return model;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public void setModel(List<Model> model) {
        this.model = model;
    }
}