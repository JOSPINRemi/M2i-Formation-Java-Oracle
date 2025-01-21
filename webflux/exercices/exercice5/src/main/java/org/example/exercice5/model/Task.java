package org.example.exercice5.model;

import java.util.UUID;

public class Task {
    private UUID id;
    private String description;
    private boolean completed;

    public Task() {
    }

    public Task(String description) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.completed = false;
    }

    public Task(UUID id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
