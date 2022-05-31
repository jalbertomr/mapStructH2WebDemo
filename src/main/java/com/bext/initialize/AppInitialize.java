package com.bext.initialize;

import com.bext.repository.PersonRepo;
import com.bext.dto.PersonDto;
import com.bext.entity.Person;
import com.bext.mapper.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Profile("h2initbycodedata")
@Component
public class AppInitialize {
    @Autowired
    private PersonRepo repository;

    @Autowired
    private PersonMapper personMapper;

    @EventListener(ApplicationReadyEvent.class)
    public void initialize(){
        repository.deleteAll();
        Person savedPerson = repository.save(new Person(null, "Jose", "ApplicationReadyEvent", 51));
        log.info("savedPerson: {}", savedPerson);
        PersonDto savedPersonDto = personMapper.personToDto(savedPerson);
        savedPersonDto.setFirstNameDto(null);
        savedPersonDto.setAgeDto(1234);
        log.info("savedPersonDto:{}", savedPersonDto);
        Person person = personMapper.updatePersonFromDto(savedPersonDto, savedPerson);
        log.info("person:{}", person);
        repository.save(person);
        log.info("byId:{}", repository.findById( 1L).get());
    }

}
