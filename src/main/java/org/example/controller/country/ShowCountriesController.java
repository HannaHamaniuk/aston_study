package org.example.controller.country;

import org.example.controller.AbstractController;
import org.example.model.entity.country.Country;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/countries")
public class ShowCountriesController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Country> countries = new ArrayList<>();
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            countries = session.createQuery("from Country").list();
            transaction.commit();

        }
        req.setAttribute("countries", countries);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("countries.jsp");
        requestDispatcher.forward(req, resp);
    }
}
