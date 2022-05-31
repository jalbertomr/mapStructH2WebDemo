package com.bext.mapper;

import com.bext.repository.PersonRepo;
import com.bext.dto.PersonDto;
import com.bext.entity.Person;
import com.github.database.rider.junit5.DBUnitExtension;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@Slf4j
@ExtendWith(DBUnitExtension.class)
@SpringBootTest
//@ActiveProfiles("TestRepo")
public class PersonRepositoryTest {

    @Autowired
    PersonRepo repository;

    @Autowired
    PersonMapper personMapper;

    @Test
    void personsaveTest(){
        repository.deleteAll();
        Person save = repository.save(new Person(null, "Jose Alberto", "Martinez", 51));
        ArrayList<Person> persons = Lists.newArrayList(repository.findAll());
        Assertions.assertEquals(1, persons.size());
    }

    @Test
    void personMapperRepoTest() {
        repository.deleteAll();
        Person person = new Person(null, "Jose Alberto", "Martinez", 51);
        Person savedPerson = repository.save(person);
        log.info("#-----savedPerson: {}", savedPerson);
        PersonDto savedPersonDto = personMapper.personToDto(savedPerson);
        savedPersonDto.setFirstNameDto(null);
        savedPersonDto.setAgeDto(1234);
        log.info("#-----savedPersonDto: {}", savedPersonDto);
        Person personUpdatedFromDto = personMapper.updatePersonFromDto(savedPersonDto, savedPerson);
        repository.save(personUpdatedFromDto);
        Person personFromDb = repository.findById(1L).get();
        log.info("#-----findById(1L): {}", personFromDb);
        Assertions.assertEquals( savedPersonDto.getIdDto(), personFromDb.getId());
        Assertions.assertEquals( person.getFirstName(),personFromDb.getFirstName());
        Assertions.assertEquals( personFromDb.getAge(), 1234);
    }
}
