package org.example.controller.car;

import org.example.controller.AbstractController;
import org.example.model.entity.car.Car;
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

@WebServlet(name="allCarsController", urlPatterns = "/cars")
public class AllCarsController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car>  cars = new ArrayList<>();
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            cars = session.createQuery("from Car").list();
            transaction.commit();
        }
        req.setAttribute("cars", cars);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("cars.jsp");
        requestDispatcher.forward(req, resp);

    }
}
