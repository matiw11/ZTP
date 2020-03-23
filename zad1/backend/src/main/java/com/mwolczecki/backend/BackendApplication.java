package com.mwolczecki.backend;

import com.mwolczecki.backend.controller.FileController;
import com.mwolczecki.backend.entity.Person;
import com.mwolczecki.backend.entity.Virus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.*;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BackendApplication.class, args);
       /* FileController bean = run.getBean(FileController.class);
        Virus virus = new Virus();
        Person person = new Person();
        person.name = "Mateusz";
        virus.name = "korona";
        virus.people.add(person);

        Virus virus2 = new Virus();
        virus2.name = "sars";
        Person person1 = new Person();
        person1.name = "Anderzej";
        virus2.people.add(person);
        virus2.people.add(person1);

        try {
            FileOutputStream file = new FileOutputStream("file.ser");
            ObjectOutputStream out = null;
            out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(List.of(virus, virus2));
            out.close();
            file.close();
            FileInputStream file1 = new FileInputStream("file.ser");
            ObjectInputStream in = new ObjectInputStream(file1);

            // Method for deserialization of object
            List<Virus> object1 = (List<Virus>)in.readObject();
            System.out.println(object1);
            in.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

*/


    }

}
