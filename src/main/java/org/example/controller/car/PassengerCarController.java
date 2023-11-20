package org.example.controller.car;

import org.example.controller.AbstractController;
import org.example.model.entity.car.PassengerCar;
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

@WebServlet(name="passengerCarController", urlPatterns = "/pass")
public class PassengerCarController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<PassengerCar> passengerCarList = new ArrayList<>();
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            passengerCarList = session.createQuery("from Car where CAR_TYPE like 'P'").list();
            transaction.commit();


        }
        req.setAttribute("passengers",passengerCarList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("passenger-car.jsp");
        requestDispatcher.forward(req,resp);
    }
}
