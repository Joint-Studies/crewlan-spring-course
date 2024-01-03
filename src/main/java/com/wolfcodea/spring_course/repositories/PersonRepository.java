package com.wolfcodea.spring_course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wolfcodea.spring_course.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}