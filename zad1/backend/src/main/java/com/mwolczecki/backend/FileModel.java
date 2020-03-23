package com.mwolczecki.backend;

import com.mwolczecki.backend.entity.Virus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FileModel {

    @Autowired
    VirusDAO virusDAO;

    public List<Virus> readViruses() {
        try {
            return virusDAO.readAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveViruses(List<Virus> viruses) {
        try {
            virusDAO.save(viruses);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
