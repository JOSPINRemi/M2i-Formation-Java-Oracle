package org.example.exercisetwospringbatch.dto;

import org.example.exercisetwospringbatch.entity.Person;

import java.io.Serializable;

/**
 * DTO for {@link Person}
 */
public record PersonDtoRequest(String firstName, String lastName, int age) {
}