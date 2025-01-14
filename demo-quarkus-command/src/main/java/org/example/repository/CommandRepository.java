package org.example.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.entity.Command;

@ApplicationScoped
public class CommandRepository implements PanacheRepository<Command> {
}
