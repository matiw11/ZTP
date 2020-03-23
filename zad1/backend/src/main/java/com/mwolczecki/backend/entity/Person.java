package com.mwolczecki.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person implements Serializable {

    @Id
    public String name;
    @ManyToMany
    @JoinTable(
            name = "virus_people",
            joinColumns = {@JoinColumn(name = "person_name")},
            inverseJoinColumns = {@JoinColumn(name = "virus_name")}
    )
    public List<Virus> viruses = new ArrayList<>();

    public int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
