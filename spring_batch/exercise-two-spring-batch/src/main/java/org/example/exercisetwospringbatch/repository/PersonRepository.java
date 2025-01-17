package org.example.exercisetwospringbatch.repository;

import org.example.exercisetwospringbatch.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}