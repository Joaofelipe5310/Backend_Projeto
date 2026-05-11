package api.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Linha")
public class Line {

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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Category> getCategories() {
        return categories;
    }
}