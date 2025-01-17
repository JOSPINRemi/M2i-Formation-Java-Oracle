package org.example.exercisetwospringbatch.controller;

import org.example.exercisetwospringbatch.dto.PersonDtoRequest;
import org.example.exercisetwospringbatch.dto.PersonDtoResponse;
import org.example.exercisetwospringbatch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/people")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("")
    public ResponseEntity<Long> save(@RequestBody PersonDtoRequest personDtoRequest) {
        return new ResponseEntity<>(personService.save(personDtoRequest).id(), HttpStatus.CREATED);
    }

    @PostMapping("/csv")
    public ResponseEntity<Void> save(@RequestParam MultipartFile file) {
        try {
            personService.save(file);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<PersonDtoResponse>> get() {
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDtoResponse> getById(@PathVariable("id") long id) {
        return ResponseEntity.ok(personService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDtoResponse> put(@PathVariable("id") long id, @RequestBody PersonDtoRequest personDtoRequest) {
        return ResponseEntity.ok(personService.put(id,personDtoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonDtoResponse> deleteById(@PathVariable("id") long id) {
        personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
