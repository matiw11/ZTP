package com.mwolczecki.backend;

import com.mwolczecki.backend.entity.Virus;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class VirusDAO {
    final String fileName = "file.ser";
    public List<Virus> readAll() throws Exception {

        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);

        // Method for deserialization of object
        List<Virus> object1 = (List<Virus>)in.readObject();
        System.out.println(object1);
        in.close();
        file.close();
        return object1;
    }

    public void save(List<Virus> viruses) throws Exception {
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);

        System.out.println("SAving viruses" + viruses);
        // Method for serialization of object
        out.writeObject(viruses);
        out.close();
        file.close();
    }
}
