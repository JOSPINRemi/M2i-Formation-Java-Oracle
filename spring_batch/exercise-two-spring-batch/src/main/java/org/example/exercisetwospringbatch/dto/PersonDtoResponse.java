package org.example.exercisetwospringbatch.dto;

import java.io.Serializable;

/**
 * DTO for {@link org.example.exercisetwospringbatch.entity.Person}
 */
public record PersonDtoResponse(Long id, String firstName, String lastName, int age) {
}