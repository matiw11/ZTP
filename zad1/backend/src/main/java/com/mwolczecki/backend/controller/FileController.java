package com.mwolczecki.backend.controller;

import com.mwolczecki.backend.DBModel;
import com.mwolczecki.backend.FileModel;
import com.mwolczecki.backend.entity.Problem;
import com.mwolczecki.backend.entity.Virus;
import com.mwolczecki.backend.repository.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class FileController {

    @Autowired
    FileModel fileModel;

    @Autowired
    DBModel dbModel;

    @RequestMapping("/getProblem/{type}")
    public List<Virus> getDataSet(@PathVariable String type){
        System.out.println(type);
        if(type.equals(Constants.FILE)){
            List<Virus> viri = fileModel.readViruses();
            return viri;
        }else{
            return dbModel.readViruses();
        }

    }

    @RequestMapping("/saveProblem/{type}")
    public void saveData(@PathVariable String type, @RequestBody List<Virus> viruses){
        if(type.equals(Constants.FILE)){
           fileModel.saveViruses(viruses);
        }else{
            dbModel.saveViruses(viruses);
        }
    }

    @RequestMapping("/synchronizeDBWithFile")
    public void synchronizeDBWithFile(){
        List<Virus> dataSet = getDataSet(Constants.FILE);
        saveData(Constants.DATABASE, dataSet);
    }
    @RequestMapping("/synchronizeFileWithDB")
    public void synchronizeFIleWithDB(){
        List<Virus> dataSet = getDataSet(Constants.DATABASE);
        saveData(Constants.FILE, dataSet);
    }
}
