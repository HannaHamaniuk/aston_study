package org.example.controller;

import org.example.config.SessionFactoryMaker;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name="abstractController")
public class AbstractController extends HttpServlet {
    protected SessionFactory sessionFactory;
    @Override
    public void init() throws ServletException {
       sessionFactory = new SessionFactoryMaker().getSessionFactory();
    }
}
