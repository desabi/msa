package com.abi.mongocruda.service;

import com.abi.mongocruda.entity.Person;
import com.abi.mongocruda.model.PersonRequest;
import com.abi.mongocruda.repository.PersonRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person save(PersonRequest personRequest) {
        log.info("Guardar persona: {}", personRequest);
        Person person = new Person(personRequest);
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        log.info("Obtener todas las personas.");
        return personRepository.findAll();
    }

    @Override
    public ResponseEntity<Person> findById(ObjectId id) {
        log.info("Obtener persona con id: {}", id);
        Optional<Person> personById = personRepository.findById(id);
        try {

            return new ResponseEntity<>(personById.get(), HttpStatus.OK);
        } catch (Exception e) {
            log.info("Error \"{}\" al obtener persona con id: {}", e, id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<Person> update(ObjectId id, PersonRequest personRequest) {
        log.info("Actualizar persona con id: {}", id);
        Optional<Person> personById = personRepository.findById(id);

        try {
            Person personDB = personRepository.findById(id).get();
            //personDB = new Person(personRequest); crea nuevo registro con id diferente
            personDB.setName(personRequest.getName());
            personDB.setAge(personRequest.getAge());
            personDB.setHeight(personRequest.getHeight());
            personDB.setPhone(personRequest.getPhone());
            personRepository.save(personDB);
            return new ResponseEntity<>(personDB, HttpStatus.OK);
        } catch (Exception e) {
            log.info("Error \"{}\" al actualizar persona con id: {}", e, id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> delete(ObjectId id) {
        log.info("Eliminar persona con id: {}", id);
        try {
            personRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.info("Error \"{}\" al eliminar persona con id: {}", e, id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
