package org.example.demo1;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonService personService;

    @Inject
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    public Person getPerson() {
        return new Person("toto", 42, 78);
    }

    @GET
    @Path("/usepersonservice")
    public Person getPersonService() {
        return personService.save(45, "tata", 67);
    }

    @GET
    @Path("/usepersonservicev2")
    public Person getPersonServicev2(@QueryParam("id") int id, @QueryParam("name") String name, @QueryParam("age") int age) {
        return personService.save(id, name, age);
    }

    @POST
    public Person createPerson(Person person) {
        return person;
    }

    @PUT
    @Path("{name}")
    public Person putPerson(@PathParam("name") String name) {
        return new Person(name, 42, 78);
    }
}
