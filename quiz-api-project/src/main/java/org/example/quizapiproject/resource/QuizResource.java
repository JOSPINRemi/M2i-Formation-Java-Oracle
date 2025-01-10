package org.example.quizapiproject.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.quizapiproject.entity.Quiz;
import org.example.quizapiproject.service.QuizService;

import java.util.List;

@Path("/quizzes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QuizResource {
    private final QuizService quizService;

    @Inject
    public QuizResource(QuizService quizService) {
        this.quizService = quizService;
    }

    @POST
    public Quiz createQuiz(Quiz quiz) {
        Quiz savedQuiz = null;
        try {
            savedQuiz = quizService.save(quiz);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return savedQuiz;
    }

    @GET
    public List<Quiz> getAllQuizzes() {
        return quizService.getAll();
    }

    @GET
    @Path("/{id}")
    public Quiz getQuizById(@PathParam("id") Integer id) {
        Quiz quiz = null;
        try {
            quiz = quizService.getById(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return quiz;
    }

    /*@POST
    @Path("/{id}/play")
    public boolean playQuiz(@PathParam("id") Integer id) {
    }*/

    /*@GET
    @Path("/{id}/results")*/

    @DELETE
    @Path("/{id}")
    public void deleteQuizById(@PathParam("id") Integer id) {
        quizService.deleteById(id);
    }
}
