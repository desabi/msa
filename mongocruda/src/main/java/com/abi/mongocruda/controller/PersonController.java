package com.abi.mongocruda.controller;

import com.abi.mongocruda.entity.Person;
import com.abi.mongocruda.model.PersonRequest;
import com.abi.mongocruda.service.PersonService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    // create
    @PostMapping("")
    public ResponseEntity<Person> create(@Valid @RequestBody PersonRequest personRequest) {
        Person personSaved = personService.save(personRequest);
        return new ResponseEntity<>(personSaved, HttpStatus.OK) ;
    }

    // read
    @GetMapping
    public ResponseEntity<List<Person>> read() {
        List<Person> all = personService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    // read by id
    @GetMapping("/{id}")
    public ResponseEntity<Person> read(@PathVariable("id") ObjectId id) {
        return personService.findById(id);
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") ObjectId id, @Valid @RequestBody PersonRequest personRequest) {
        return personService.update(id, personRequest);
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") ObjectId id) {
        return personService.delete(id);
    }
}
