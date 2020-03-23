package com.mwolczecki.backend.repository;

import com.mwolczecki.backend.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDBRepository extends CrudRepository<Person, Integer> {
}
