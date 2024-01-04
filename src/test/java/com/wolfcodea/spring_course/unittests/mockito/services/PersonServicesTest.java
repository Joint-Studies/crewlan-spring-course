package com.wolfcodea.spring_course.unittests.mockito.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.mockito.junit.jupiter.MockitoExtension;

import com.wolfcodea.spring_course.data.vo.v1.PersonVO;
import com.wolfcodea.spring_course.exceptions.RequiredObjectsIsNullException;
import com.wolfcodea.spring_course.model.Person;
import com.wolfcodea.spring_course.repositories.PersonRepository;
import com.wolfcodea.spring_course.services.PersonServices;
import com.wolfcodea.spring_course.unittests.mapper.mocks.MockPerson;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {

    MockPerson input;

    @InjectMocks
    private PersonServices service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        Person entity = input.mockEntity(1);
        Person persisted = entity;
        persisted.setKey(1L);

        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.create(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
        assertEquals("Addres Test1", entity.getAddress());
        assertEquals("First Name Test1", entity.getFirstName());
        assertEquals("Last Name Test1", entity.getLastName());
        assertEquals("Female", entity.getGender());

    }

    @Test
    void testCreateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectsIsNullException.class, () -> {
            service.create(null);
        });
        String expectedMessage = "It is not allowed to persist a null object!";
        String actulMessage = exception.getMessage();

        assertTrue(actulMessage.contains(expectedMessage));

    }

    @Test
    void testUpdateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectsIsNullException.class, () -> {
            service.update(null);
        });
        String expectedMessage = "It is not allowed to persist a null object!";
        String actulMessage = exception.getMessage();

        assertTrue(actulMessage.contains(expectedMessage));

    }

    @Test
    void testDelete() {
        Person entity = input.mockEntity(1);
        entity.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.delete(1L);
    }

    @Test
    void testFindAll() {
        List<Person> entityList = input.mockEntityList();

        when(repository.findAll()).thenReturn(entityList);

        var people = service.findAll();
        assertNotNull(people);
        assertEquals(14, people.size());

        var personOne = people.get(1);
        assertNotNull(personOne);
        assertNotNull(personOne.getKey());
        assertNotNull(personOne.getLinks());

        assertTrue(personOne.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
        assertEquals("Addres Test1", personOne.getAddress());
        assertEquals("First Name Test1", personOne.getFirstName());
        assertEquals("Last Name Test1", personOne.getLastName());
        assertEquals("Female", personOne.getGender());

        var personFour = people.get(4);
        assertNotNull(personFour);
        assertNotNull(personFour.getKey());
        assertNotNull(personFour.getLinks());

        assertTrue(personFour.toString().contains("links: [</api/person/v1/4>;rel=\"self\"]"));
        assertEquals("Addres Test4", personFour.getAddress());
        assertEquals("First Name Test4", personFour.getFirstName());
        assertEquals("Last Name Test4", personFour.getLastName());
        assertEquals("Male", personFour.getGender());

        var personSeven = people.get(7);
        assertNotNull(personSeven);
        assertNotNull(personSeven.getKey());
        assertNotNull(personSeven.getLinks());

        assertTrue(personSeven.toString().contains("links: [</api/person/v1/7>;rel=\"self\"]"));
        assertEquals("Addres Test7", personSeven.getAddress());
        assertEquals("First Name Test7", personSeven.getFirstName());
        assertEquals("Last Name Test7", personSeven.getLastName());
        assertEquals("Female", personSeven.getGender());

    }

    @Test
    void testFindById() {
        Person entity = input.mockEntity(1);
        entity.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
        assertEquals("Addres Test1", entity.getAddress());
        assertEquals("First Name Test1", entity.getFirstName());
        assertEquals("Last Name Test1", entity.getLastName());
        assertEquals("Female", entity.getGender());
    }

    @Test
    void testUpdate() {
        Person entity = input.mockEntity(1);
        entity.setKey(1L);

        Person persisted = entity;
        persisted.setKey(1L);

        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);

        var result = service.update(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
        assertEquals("Addres Test1", entity.getAddress());
        assertEquals("First Name Test1", entity.getFirstName());
        assertEquals("Last Name Test1", entity.getLastName());
        assertEquals("Female", entity.getGender());

    }
}
