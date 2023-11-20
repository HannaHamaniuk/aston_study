package org.example.config;

import org.example.model.entity.country.Country;
import org.example.model.entity.country.Union;
import org.example.model.entity.car.PassengerCar;
import org.example.model.entity.car.SportCar;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryMaker {
    private SessionFactory sessionFactory;

    public  void configureSessionFactory(){
        sessionFactory=new Configuration().addAnnotatedClass(org.example.model.entity.car.Car.class)
                .addAnnotatedClass(PassengerCar.class)
                .addAnnotatedClass(SportCar.class).addAnnotatedClass(Country.class)
                .addAnnotatedClass(Union.class)
                .buildSessionFactory();
    }

    public  SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            configureSessionFactory();
        }
        return sessionFactory;
    }
}
