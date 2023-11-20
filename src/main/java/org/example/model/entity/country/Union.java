package org.example.model.entity.country;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="unions")
public class Union {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="u_id")
    private int id;
    private String title;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinTable(name = "country_union", joinColumns = @JoinColumn(name = "u_id"),inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Country> authors;

    public Union(String title) {
        this.title = title;
    }

    public Union() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Country> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Country> authors) {
        this.authors = authors;
    }
}
