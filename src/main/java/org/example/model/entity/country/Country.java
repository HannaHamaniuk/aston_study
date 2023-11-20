package org.example.model.entity.country;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="c_id")
    private int id;
    private String name;
    private String president;
    private String capital;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinTable(name="country_union", joinColumns = @JoinColumn(name = "c_id"), inverseJoinColumns = @JoinColumn(name="u_id"))
    private List<Union> unions;

    public Country() {
    }

    public Country(String name, String president, String capital) {
        this.name = name;
        this.president = president;
        this.capital = capital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public List<Union> getUnions() {
        return unions;
    }

    public void setUnions(List<Union> unions) {
        this.unions = unions;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
