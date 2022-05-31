package com.bext;

import com.bext.entity.Person;
import com.bext.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepo repository;

    public Iterable<Person> getPersons(){
        return repository.findAll();
    }

    public Optional<Person> getPerson(Long id){
        return repository.findById( id);
    }

    public Person addPerson( Person person){
        return repository.save( person);
    }

    public void deletePerson( long id){
        repository.deleteById( id);
    }
}
