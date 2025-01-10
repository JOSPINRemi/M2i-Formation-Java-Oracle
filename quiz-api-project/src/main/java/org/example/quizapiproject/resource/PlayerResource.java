package org.example.quizapiproject.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.quizapiproject.service.PlayerService;

@Path("/players")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {
    private final PlayerService playerService;

    @Inject
    public PlayerResource(PlayerService playerService) {
        this.playerService = playerService;
    }

    /*@GET
    @Path("/{id}/history")*/
}
