package org.example.exercisetwospringbatch.service;

import org.example.exercisetwospringbatch.dto.PersonDtoRequest;
import org.example.exercisetwospringbatch.dto.PersonDtoResponse;
import org.example.exercisetwospringbatch.entity.Person;
import org.example.exercisetwospringbatch.repository.PersonRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job importJob;

    public PersonDtoResponse save(PersonDtoRequest personDtoRequest) {
        Person person = dtoRequestToEntity(personDtoRequest);
        Person savedPerson = personRepository.save(person);
        return entityToDtoResponse(savedPerson);
    }

    public void save(MultipartFile multipartFile) throws Exception {
        String fileName = "people.csv";
        File file = new File("./src/main/resources/static/" + fileName);
        multipartFile.transferTo(file);
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .addString("filename", fileName)
                .toJobParameters();
        jobLauncher.run(importJob, jobParameters);
    }

    public List<PersonDtoResponse> getAll() {
        List<Person> people = personRepository.findAll();
        return people.stream().map(this::entityToDtoResponse).toList();
    }

    public PersonDtoResponse getById(long id) {
        if (!personRepository.existsById(id)) {
            throw new RuntimeException("Person with id " + id + " does not exist");
        }
        return entityToDtoResponse(personRepository.getReferenceById(id));
    }

    public PersonDtoResponse put(long id, PersonDtoRequest personDtoRequest) {
        if (!personRepository.existsById(id)) {
            throw new RuntimeException("Person with id " + id + " does not exist");
        }
        Person person = dtoRequestToEntity(personDtoRequest);
        person.setId(id);
        Person updatedPerson = personRepository.save(person);
        return entityToDtoResponse(updatedPerson);
    }

    public void deleteById(long id) {
        if (!personRepository.existsById(id)) {
            throw new RuntimeException("Person with id " + id + " does not exist");
        }
        personRepository.deleteById(id);
    }

    private Person dtoRequestToEntity(PersonDtoRequest personDtoRequest) {
        return new Person(personDtoRequest.lastName(), personDtoRequest.firstName(), personDtoRequest.age());
    }

    private PersonDtoResponse entityToDtoResponse(Person person) {
        return new PersonDtoResponse(person.getId(), person.getLastName(), person.getFirstName(), person.getAge());
    }
}
