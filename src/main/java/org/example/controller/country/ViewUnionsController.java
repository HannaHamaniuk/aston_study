package org.example.controller.country;

import org.example.controller.AbstractController;
import org.example.model.entity.country.Country;
import org.example.model.entity.country.Union;
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

@WebServlet("/unions")
public class ViewUnionsController extends AbstractController {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Union> unions = new ArrayList<>();
        List<Country>countries = new ArrayList<>();
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
             countries = session.createQuery("select c from Country c LEFT JOIN FETCH c.unions").getResultList();
             unions = countries.get(id).getUnions();
             transaction.commit();

        }
        req.setAttribute("unions", unions);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("unions.jsp");
        requestDispatcher.forward(req,resp);

    }
}
