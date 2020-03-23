package com.mwolczecki.backend.entity;

import java.io.Serializable;
import java.util.List;

public class Problem implements Serializable {
    List<Virus> viruses;

    @Override
    public String toString() {
        return "Problem{" +
                "viruses=" + viruses +
                '}';
    }
}
