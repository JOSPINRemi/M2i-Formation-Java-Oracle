package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.entity.Command;
import org.example.repository.CommandRepository;

@ApplicationScoped
public class CommandService {
    @Inject
    CommandRepository commandRepository;

    public Command getCommandById(long id) {
        return commandRepository.findById(id);
    }
}
