package org.example.controller.car;

import org.example.controller.AbstractController;
import org.example.model.entity.car.Car;
import org.example.model.entity.car.PassengerCar;
import org.example.model.entity.car.SportCar;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="addCarController",urlPatterns = "/add")
public class AddCarController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type= req.getParameter("type");
        String brand = req.getParameter("brand");
        String color= req.getParameter("color");
        int power = Integer.parseInt(req.getParameter("engine"));
        int passenger = Integer.parseInt(req.getParameter("passenger"));
        int speed = Integer.parseInt(req.getParameter("speed"));
        if(type.equalsIgnoreCase("Sport")) {
            Car car = new SportCar(brand, color, power, speed);
            try (Session session = sessionFactory.openSession()) {
                Transaction transaction = session.beginTransaction();
                session.save(car);
                transaction.commit();
            }
        }
        else{
                Car car = new PassengerCar(brand, color, power, passenger);
                try(Session session = sessionFactory.openSession()) {
                    Transaction transaction = session.beginTransaction();
                    session.save(car);
                    transaction.commit();
                }

            }

        }
    }

