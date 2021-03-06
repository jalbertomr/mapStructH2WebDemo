package com.bext.mapper;

import com.bext.dto.PersonDto;
import com.bext.entity.Person;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source="idDto", target="id")
    @Mapping(source="firstNameDto", target="firstName")
    @Mapping(source="lastNameDto", target="lastName")
    @Mapping(source="ageDto", target="age")
    public Person personDtoToPerson(PersonDto personDto);

    @InheritInverseConfiguration(name="personDtoToPerson")
    public PersonDto personToDto(Person person);

    @Mapping(source="idDto", target="id")
    @Mapping(source="firstNameDto", target="firstName", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source="lastNameDto", target="lastName", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source="ageDto", target="age", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public Person updatePersonFromDto(PersonDto personDto, @MappingTarget Person person);

}
