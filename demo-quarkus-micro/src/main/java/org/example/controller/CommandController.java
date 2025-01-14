package org.example.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.example.dto.Command;

@Path("api/command")
public class CommandController {
    @GET
    @Path("/{id}")
    public Response getCommandById(@PathParam("id") int id){

    }
}
