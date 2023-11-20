package org.example.controller.car;

import org.example.controller.AbstractController;
import org.example.model.entity.car.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "removeCarController",urlPatterns = "/delete")
public class RemoveCarController extends AbstractController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int id =Integer.parseInt(req.getParameter("id"));
         try(Session session = sessionFactory.openSession()){
             Transaction transaction = session.beginTransaction();
             Car car = session.load(Car.class, id);
             if(car!=null){
                 session.delete(car);

             }
             transaction.commit();
         }

    }
}
