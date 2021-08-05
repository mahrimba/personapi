package com.dio.personapi.service;

import com.dio.personapi.dto.response.MessageResponseDTO;
import com.dio.personapi.entity.Person;
import com.dio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created Person with Id " + savedPerson.getId())
                .build();
    }
}
