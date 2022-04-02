package com.abi.mongocruda.service;

import com.abi.mongocruda.entity.Person;
import com.abi.mongocruda.model.PersonRequest;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    Person save(PersonRequest personRequest); //create
    List<Person> findAll(); // read
    ResponseEntity<Person> findById(ObjectId id); // read by id
    ResponseEntity<Person> update(ObjectId id, PersonRequest personRequest);// update: se usa findById y save
    ResponseEntity<HttpStatus> delete(ObjectId id);// delete by id
}
