package com.studyproj.banking.services;
import com.studyproj.banking.entities.Person;
import com.studyproj.banking.exceptions.ExceptionMessage;

import java.util.List;


public interface PersonService {
    List<Person> getAll();

    Person getPersonById(long id);

    Person createPerson(Person person) throws ExceptionMessage;
}
