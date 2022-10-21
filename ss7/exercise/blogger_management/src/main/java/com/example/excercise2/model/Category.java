package com.example.excercise2.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Bloger> blogers;

    public Category() {
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

    public Set<Bloger> getBlogers() {
        return blogers;
    }

    public void setBlogers(Set<Bloger> blogers) {
        this.blogers = blogers;
    }
}
