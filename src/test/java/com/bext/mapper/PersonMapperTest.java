package com.bext.mapper;

import com.bext.dto.PersonDto;
import com.bext.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class PersonMapperTest {

    @Test
    void personDtoToPersonNullsTest() {
        //given
        PersonDto personDto = new PersonDto(null, null, null, null);
        //when
        Person person = PersonMapper.INSTANCE.personDtoToPerson(personDto);
        //then
        log.info("personDto: {}", personDto);
        log.info("person: {}", person);
        Assertions.assertEquals(1,1,"Not yet implemented");
    }

    @Test
    void personDtoToPersonTest() {
        //given
        Person person = new Person(3L, "Jose Alberto", "Martinez", 51);
        //when
        PersonDto personDto = PersonMapper.INSTANCE.personToDto(person);
        //then
        log.info("person: {}", person);
        log.info("personDto: {}", personDto);
    }

    @Test
    void updatePersonFromDtoTest() {
    }

}