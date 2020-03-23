package com.mwolczecki.backend;

import com.mwolczecki.backend.entity.Person;
import com.mwolczecki.backend.entity.Virus;
import com.mwolczecki.backend.repository.PersonDBRepository;
import com.mwolczecki.backend.repository.VirusDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBModel {

    @Autowired
    VirusDBRepository virusDBRepository;
    @Autowired
    PersonDBRepository personDBRepository;

    public List<Virus> readViruses(){
        ArrayList<Virus> viri = new ArrayList<>();
        virusDBRepository.findAll().forEach(vir -> {
            vir.people.forEach(person -> person.viruses = null);
            viri.add(vir);
        });
        return viri;
    }

    public void saveViruses(List<Virus> viruses) {
        virusDBRepository.deleteAll();
        personDBRepository.deleteAll();
        viruses.forEach(virus ->{
            virus.people.forEach(person -> personDBRepository.save(person));
        });
        virusDBRepository.saveAll(viruses);
        /*viruses.forEach(virus ->{
            ArrayList<Person> peopleCopy = new ArrayList<>(virus.people);
            virus.people = null;
            Virus save = virusDBRepository.save(virus);
            virus.people = peopleCopy;
        });
        */
    }
}
