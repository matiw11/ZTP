package com.mwolczecki.backend.repository;

import com.mwolczecki.backend.entity.Virus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface VirusDBRepository extends CrudRepository<Virus, Integer> {
}
