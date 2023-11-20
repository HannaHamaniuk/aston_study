package org.example.controller.car;

import org.example.controller.AbstractController;
import org.example.model.entity.car.SportCar;
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

@WebServlet(name="sportCarController", urlPatterns = "/sport")
public class SportCarController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SportCar> sportCars = new ArrayList<>();
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            sportCars = session.createQuery("from Car where CAR_TYPE like 'S'").list();
            transaction .commit();

        }
        req.setAttribute("sportCars", sportCars);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("sport-car.jsp");
        requestDispatcher.forward(req,resp);

    }
}
