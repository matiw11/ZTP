package com.mwolczecki.backend.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Virus implements Serializable {

    @Id
    public String name;
    public int dangerLevel;

    @ManyToMany
    @JoinTable(
            name = "virus_people",
            joinColumns = {@JoinColumn(name = "virus_name")},
            inverseJoinColumns = {@JoinColumn(name = "person_name")}
    )
    public List<Person> people = new ArrayList<>();

    @Override
    public String toString() {
        return "Virus{" +
                ", name='" + name + '\'' +
                ", dangerLevel=" + dangerLevel +
                ", people=" + people +
                '}';
    }
}
