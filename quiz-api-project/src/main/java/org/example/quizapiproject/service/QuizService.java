package org.example.quizapiproject.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.quizapiproject.entity.Quiz;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class QuizService {
    private List<Quiz> quizzes;

    public QuizService() {
        quizzes = new ArrayList<>();
    }

    public Quiz save(Quiz quiz) {
        if (!quizzes.add(quiz)) {
            throw new RuntimeException("Le quiz n'a pas été sauvegardé");
        }
        return quiz;
    }

    public List<Quiz> getAll() {
        return quizzes;
    }

    public Quiz getById(Integer id) {
        Quiz searchedQuiz = quizzes.stream()
                .filter(quiz -> quiz.getId() == id)
                .findFirst()
                .orElse(null);
        if (searchedQuiz == null)
            throw new RuntimeException("Le quiz n'existe pas");
        return searchedQuiz;
    }

    public void deleteById(Integer id) {
        Quiz quiz = getById(id);
        quizzes.remove(quiz);
    }
}
