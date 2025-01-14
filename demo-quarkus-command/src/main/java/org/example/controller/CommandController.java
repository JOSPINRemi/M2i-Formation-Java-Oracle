package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.example.entity.Command;
import org.example.service.CommandService;

@Path("api/command")
public class CommandController {
    @Inject
    CommandService commandService;

    @GET
    @Path("/{id}")
    public Command getCommandById(@PathParam("id") long id) {
        return commandService.getCommandById(id);
    }
}
