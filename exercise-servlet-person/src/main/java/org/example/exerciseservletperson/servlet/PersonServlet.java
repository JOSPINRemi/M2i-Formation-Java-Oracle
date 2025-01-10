package org.example.exerciseservletperson.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exerciseservletperson.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "personServlet", value = "/person-servlet")
public class PersonServlet extends HttpServlet {
    private List<Person> people;

    @Override
    public void init() throws ServletException {
        people = new ArrayList<>();

        Person person = new Person("John", "Doe", 30);
        people.add(person);
        person = new Person("Jane", "Doe", 25);
        people.add(person);
        person = new Person("Baby", "Doe", 1);
        people.add(person);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("people", people);
        req.getRequestDispatcher("person.jsp").forward(req, resp);
    }
}
