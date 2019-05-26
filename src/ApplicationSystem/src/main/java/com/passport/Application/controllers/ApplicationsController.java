package com.passport.Application.controllers;

import com.passport.Application.models.Application;
import com.passport.Application.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applications") //Endpoint for this class
public class ApplicationsController {

    @Autowired
    private ApplicationRepository applicationRepository; //Using jpa repository

    //Get request for all the applications within Database
    //Then shown on frontend
    @GetMapping
    public List<Application> list(){
        return applicationRepository.findAll();
    }

    //Post request application to database
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Application application){ applicationRepository.save(application); }

    //Get request for a single database entry done by id
    @GetMapping("/{id}")
    public Application get(@PathVariable("id") long id){
        return applicationRepository.getOne(id);
    }
}
