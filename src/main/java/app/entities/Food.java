package app.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tblFood")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private long price;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="tblFoodCateg",
            joinColumns={@JoinColumn(name="FOOD_ID", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="CATEG_ID", referencedColumnName="id")})
    private List<Category> categories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
